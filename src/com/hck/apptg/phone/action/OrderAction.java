package com.hck.apptg.phone.action;

import com.hck.apptg.bean.User;
import com.hck.apptg.daoserver.UserDaoServer;
import com.hck.apptg.duiba.CreditConsumeParams;
import com.hck.apptg.duiba.CreditConsumeResult;
import com.hck.apptg.duiba.CreditNotifyParams;
import com.hck.apptg.duiba.CreditTool;
import com.hck.apptg.util.LogUtil;
import com.hck.apptg.vo.Contans;

public class OrderAction extends BaseAction {
	private UserDaoServer mDaoServer;

	public UserDaoServer getmDaoServer() {
		return mDaoServer;
	}

	public void setmDaoServer(UserDaoServer mDaoServer) {
		this.mDaoServer = mDaoServer;
	}

	/**
	 * 接收兑吧返回的订单处理通知.
	 */
	public void duihuanResult() {
		init();
		CreditTool tool = new CreditTool(Contans.DUIHUANG_BA_KEY,
				Contans.DUIHUANG_BA_Secret);

		try {
			CreditNotifyParams params = tool.parseCreditNotify(request);// 利用tool来解析这个请求
			String orderNum = params.getOrderNum();
			String errorMsg = params.getErrorMessage();

			if (params.isSuccess()) {
				// chuLiOrderOK(orderNum, Contans.DUIHUAN_SUCCESS, null);
				LogUtil.log("兑换成功");
				// 兑换成功
			} else {
				LogUtil.log("兑换失败");
				// 兑换失败，根据orderNum，对用户的金币进行返还，回滚操作
				// if (Contans.ERROR_MSG.equals(errorMsg)) {
				// chuLiOrderOK(orderNum, Contans.DUIHUAN_ERROR_SHEHE,
				// errorMsg);
				// } else {
				// chuLiOrderOK(orderNum, Contans.DUIHUAN_ERROR_OTHER,
				// errorMsg);
				// }

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// }

	}

	/**
	 * 兑吧,增加订单.
	 */
	public void duihuanOrder() {
		init();
		CreditTool tool = new CreditTool(Contans.DUIHUANG_BA_KEY,
				Contans.DUIHUANG_BA_Secret);
		int orderType = Contans.ORDER_ORDER;
		try {
			CreditConsumeParams params = tool.parseCreditConsume(request);// 利用tool来解析这个请求
			String uid = params.getUid();// 用户id
			long uid2 = Long.parseLong(uid);
			User user = mDaoServer.getUser(uid2);
			if (user == null || user.getJinbi() <= 0 || user.getIsok() == 0) {
				CreditConsumeResult result = new CreditConsumeResult(false);
				result.setBizId(System.currentTimeMillis() + "");
				result.setErrorMessage("失败");
				response.getWriter().write(result.toString());
			} else {
				Long credits = params.getCredits();
				String type = params.getType();// 获取兑换类型
				String description = params.getDescription();
				String orderNum = params.getOrderNum();
				String content = null;
				String info = null;
				int size = (int) (credits / 1000);
				if (type.equals("alipay")) {
					content = "提现支付宝" + size + "元";
					info = "支付宝帐号:" + params.getAlipay() + "提现: " + size + "元";
				} else if (type.equals("qb")) {
					content = "兑换Q币" + size + "个";
					info = "QQ号码:" + params.getQq() + "兑换: " + size + "个";
				} else if (type.equals("phonebill")) {
					content = "提现话费" + size + "元";
					info = "电话号码:" + params.getPhone() + "提现: " + size + "元";
				} else {
					info = description;
					content = description;
					orderType = Contans.ORDER_HUODONG;
				}
				String bizId = null;
				bizId = uid + System.currentTimeMillis();

				if (bizId != null) {
					User user2 = mDaoServer.updateUserJIfen(uid2, -credits);
					if (user2 != null) {
						CreditConsumeResult result = new CreditConsumeResult(
								true);
						result.setBizId(bizId);
						response.getWriter().write(result.toString());
					} else {
						CreditConsumeResult result = new CreditConsumeResult(
								false);
						result.setBizId(bizId);
						response.getWriter().write(result.toString());
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				CreditConsumeResult result = new CreditConsumeResult(false);
				result.setBizId(System.currentTimeMillis() + "");
				result.setErrorMessage("未知错误");
				response.getWriter().write(result.toString());
			} catch (Exception e2) {

			}

		}

	}

}
