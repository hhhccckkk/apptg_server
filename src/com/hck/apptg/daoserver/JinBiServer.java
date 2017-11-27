package com.hck.apptg.daoserver;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.Jinbi;
import com.hck.apptg.bean.User;
import com.hck.apptg.util.LogUtil;

public class JinBiServer extends HibernateDaoSupport {
	public boolean isAddJinBi(long uid, int jifen, int point) {
		String sql = "from Jinbi j where j.uid=" + uid;
		List<Jinbi> jinbis = getHibernateTemplate().find(sql);
		if (jinbis == null || jinbis.isEmpty()) {
			Jinbi jinbi2 = new Jinbi();
			jinbi2.setShijian(new Timestamp(System.currentTimeMillis()));
			jinbi2.setJinbi(point);
			jinbi2.setUid(uid);
			jinbi2.setJifen(jifen);
			getHibernateTemplate().save(jinbi2);
			updateUser(uid, jifen, point);
			return true;
		}
		Jinbi jinbi = jinbis.get(0);
		boolean isJinT = isJinTian(jinbi.getShijian().toString());
		LogUtil.log("今天吗?" + isJinT);

		if (!isJinT) {
			jinbi.setJinbi(point);
			jinbi.setShijian(new Timestamp(System.currentTimeMillis()));
			getHibernateTemplate().update(jinbi);
			updateUser(uid, jifen, point);
			return true;
		} else {
			if (jinbi.getJinbi() > 100) {
				return false;
			} else {
				jinbi.setJinbi(jinbi.getJinbi() + point);
				getHibernateTemplate().update(jinbi);
				updateUser(uid, jifen, point);
				return true;
			}
		}

	}

	private void updateUser(long uid, int jifen, int point) {
		User user = (User) getHibernateTemplate().get(User.class, uid);
		user.setJifeng(user.getJifeng() + jifen);
		user.setJinbi(user.getJinbi()+point);
		getHibernateTemplate().update(user);
		getHibernateTemplate().flush();
	}

	/**
	 * 格式化时间
	 * 
	 * @param time
	 * @return
	 */
	private boolean isJinTian(String time) {
		SimpleDateFormat format = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm");
		if (time == null || "".equals(time)) {
			return false;
		}
		Date date = null;
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar current = Calendar.getInstance();

		Calendar today = Calendar.getInstance(); // 今天

		today.set(Calendar.YEAR, current.get(Calendar.YEAR));
		today.set(Calendar.MONTH, current.get(Calendar.MONTH));
		today.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
		// Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);

		Calendar yesterday = Calendar.getInstance(); // 昨天

		yesterday.set(Calendar.YEAR, current.get(Calendar.YEAR));
		yesterday.set(Calendar.MONTH, current.get(Calendar.MONTH));
		yesterday.set(Calendar.DAY_OF_MONTH,
				current.get(Calendar.DAY_OF_MONTH) - 1);
		yesterday.set(Calendar.HOUR_OF_DAY, 0);
		yesterday.set(Calendar.MINUTE, 0);
		yesterday.set(Calendar.SECOND, 0);

		current.setTime(date);

		if (current.after(today)) {
			return true;
		} else {
			return false;
		}
	}

}
