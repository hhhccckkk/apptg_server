package com.hck.apptg.daoserver;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.User;
import com.hck.apptg.bean.Ziyuan;
import com.opensymphony.xwork2.ActionContext;

public class UserDaoServer extends HibernateDaoSupport {

	public User addUser(User user) {
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
			List<User> users = getHibernateTemplate().find(sqlString);
			if (users == null || users.isEmpty()) {
				return null;
			} else {
				user2 = users.get(0);
				user2.setJingdu(user.getJingdu());
				user2.setWeidu(user.getWeidu());
				updateUser(user2);
			}
			return user2;
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
	public User updateUserFenSi(long uid,int fensi) {
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
		ActionContext.getContext().getSession().put("userSize", getCount(sqlString));
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

}
