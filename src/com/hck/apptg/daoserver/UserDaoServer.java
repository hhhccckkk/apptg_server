package com.hck.apptg.daoserver;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.aspectj.apache.bcel.generic.RET;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.User;
import com.hck.apptg.bean.Ziyuan;
import com.hck.apptg.util.LogUtil;
import com.opensymphony.xwork2.ActionContext;

public class UserDaoServer extends HibernateDaoSupport {
	private static final int TODY_SIZE = 1;
	private static final int ZUOTIAN_SIZE = 2;

	public User addUser(User user) {
		LogUtil.log("addUseraddUseraddUseraddUser");
		if (user != null) {
			try {
				long id = (Long) getHibernateTemplate().save(user);
				getHibernateTemplate().flush();
				User newUser = getUser(id);
				return newUser;
			} catch (Exception e) {
				System.out.println("Exception: " + e);
				return null;
			}

		}
		return null;
	}

	public User userExit(User user) {
		try {
			String sqlString = "from User u where u.qqid='" + user.getQqid()
					+ "'";
			User user2 = null;
			@SuppressWarnings("unchecked")
			List<User> users = getHibernateTemplate().find(sqlString);
			if (users == null || users.isEmpty()) {
				return null;
			} else {
				user2 = users.get(0);
			}
			return user2;
		} catch (Exception e) {
			System.out.println("userExit: " + e);
			return null;
		}

	}

	public boolean isUserExit(String zhanghao) {
		try {
			String sqlString = "from User u where u.name='" + zhanghao + "'";
			User user2 = null;
			@SuppressWarnings("unchecked")
			List<User> users = getHibernateTemplate().find(sqlString);
			if (users == null || users.isEmpty()) {
				return false;
			}
			return true;
		} catch (Exception e) {
			System.out.println("userExit: " + e);
			return false;
		}

	}

	public User login(String name, String password) {
		try {
			String sqlString = "from User u where u.name='" + name + "'"
					+ " and u.password='" + password + "'";
			@SuppressWarnings("unchecked")
			List<User> users = getHibernateTemplate().find(sqlString);
			if (users == null || users.isEmpty()) {
				return null;
			}
			return users.get(0);
		} catch (Exception e) {
			System.out.println("userExit: " + e);
			return null;
		}
	}

	private User updateUser(User user) {
		getHibernateTemplate().update(user);
		return user;
	}

	/**
	 * �����û���Ϣ
	 * 
	 * @param user
	 * @return
	 */
	public User prefectUser(User user) {
		try {
			User oldUser = getUser(user.getId());
			oldUser.setQq(user.getQq());
			oldUser.setAddress(user.getAddress());
			oldUser.setGongsi(user.getGongsi());
			oldUser.setWeixin(user.getWeixin());
			oldUser.setJieshao(user.getJieshao());
			oldUser.setPhone(user.getPhone());
			oldUser.setUsertype(user.getUsertype());
			updateUser(oldUser);
			getHibernateTemplate().flush();
			return oldUser;
		} catch (Exception e) {
			return null;
		}

	}

	public void updateUserGuangZhu(long uid) {
		User user = (User) getHibernateTemplate().get(User.class, uid);
		user.setGuanzhu(user.getGuanzhu() + 1);
		getHibernateTemplate().update(user);
		getHibernateTemplate().flush();

	}

	/**
	 * ��ȡһ���û�
	 * 
	 * @param uid
	 * @return
	 */
	public User getUser(long uid) {
		return (User) getHibernateTemplate().get(User.class, uid);
	}

	/**
	 * �����û�pushid
	 * 
	 * @param user
	 * @return
	 */
	public User updateUserPushId(User user) {
		User oldUser = (User) getHibernateTemplate().get(User.class,
				user.getId());
		if (oldUser != null) {
			oldUser.setPushid(user.getPushid());
			getHibernateTemplate().update(oldUser);
		}
		return oldUser;
	}

	/**
	 * �����û���˿����
	 * 
	 * @param uid
	 * @return
	 */
	public User updateUserFenSi(long uid, int fensi) {
		User oldUser = (User) getHibernateTemplate().get(User.class, uid);
		if (oldUser != null) {
			oldUser.setFensi(oldUser.getFensi() + fensi);
			getHibernateTemplate().update(oldUser);
		}
		return oldUser;
	}

	public User updateUserJIfen(long uid, Long jinbi) {
		try {
			User oldUser = (User) getHibernateTemplate().get(User.class, uid);
			if (oldUser != null) {
				long newJinbi = oldUser.getJinbi() + jinbi;
				if (newJinbi < 0) {
					oldUser.setJinbi(0l);
				} else {
					oldUser.setJinbi(newJinbi);
				}

				getHibernateTemplate().update(oldUser);
			}
			return oldUser;
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * pc使用
	 */
	public List<User> getUsers(int page) {
		String sqlString = "from User u order by  u.id desc";
		ActionContext.getContext().getSession()
				.put("userSize", getCount(sqlString));
		return getList(sqlString, page, 12);
	}

	@SuppressWarnings("unchecked")
	private List<User> getList(String sql, int page, int num) {
		List<User> mZiyuans = new ArrayList<User>();
		Query query = null;
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		query = session.createQuery(sql);
		query.setFirstResult((page - 1) * num);
		query.setMaxResults(num);
		mZiyuans = query.list();
		super.releaseSession(session);
		return mZiyuans;
	}

	private int getCount(String sql) {

		return this.getHibernateTemplate().find(sql).size();
	}

	public List<User> searchUser(String key) {
		String sqlString = "from User u where u.nicheng like '%" + key + "'";
		ActionContext.getContext().getSession()
				.put("userSize", getCount(sqlString));
		return getHibernateTemplate().find(sqlString);
	}

	public long getUserSize(int type) {
		Date endDate = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTime(endDate);
		String sql = "from User u WHERE date(u.registertime) = curdate()";
		if (type == TODY_SIZE) {
			return getCount(sql);
		} else if (type == ZUOTIAN_SIZE) {
			cl.add(Calendar.DATE, -1);
			Date startDate = cl.getTime();
			SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
			// 格式化开始日期和结束日期
			String start = dd.format(startDate);
			String end = dd.format(endDate);

			sql = "from User u where u.registertime >= '" + start
					+ "' and u.registertime <= '" + end + "'";
			return getCount(sql);
		} else {
			return getCount("select id from User");
		}

	}

}
