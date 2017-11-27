package com.hck.apptg.daoserver;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.Huitie;
import com.hck.apptg.bean.Ziyuan;
import com.hck.apptg.util.LogUtil;
import com.opensymphony.xwork2.ActionContext;

public class HUiTieServer extends HibernateDaoSupport {
	public boolean addHuiTie(Huitie huitie) {
		try {
			getHibernateTemplate().save(huitie);
			getHibernateTemplate().flush();
			return true;
		} catch (Exception e) {
			LogUtil.log("HUiTieServer e: " + e);
			return false;

		}
	}

	@SuppressWarnings("unchecked")
	public List<Huitie> getHuities(long tid) {
		String sqlString = "from Huitie h where h.tid=" + tid
				+ " order by h.id asc ";
		return getHibernateTemplate().find(sqlString);
	}

	@SuppressWarnings("unchecked")
	public List<Huitie> getHuiFus(long uid) {
		String sqlString = "from Huitie h where h.buid=" + uid
				+ " or h.user.id="+uid+" order by h.id desc ";
		return getHibernateTemplate().find(sqlString);
	}

	@SuppressWarnings("unchecked")
	private List<Huitie> getList(String sql, int page, int num) {

		List<Huitie> mZiyuans = new ArrayList<Huitie>();

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

	public Huitie getHuiTie(long id) {
		return (Huitie) getHibernateTemplate().get(Huitie.class, id);
	}

	private int getHuiTieSize(String sql) {
		return getHibernateTemplate().find(sql).size();
	}

	/**
	 * pc使用
	 */
	public List<Huitie> getHuities(int page) {
		String sql = "from Huitie z order by z.id desc";
		ActionContext.getContext().getSession()
				.put("huitieSize", getHuiTieSize(sql));
		return getList(sql, page, 20);
	}

	public List<Huitie> getUserHuiTie(int page, long uid) {
		String sql = "from Huitie z where z.user.id=" + uid
				+ " order by z.id desc";
		ActionContext.getContext().getSession()
				.put("huitieSize", getHuiTieSize(sql));
		return getList(sql, page, 20);
	}

	public boolean deleteHuiTie(long id) {
		try {
			getHibernateTemplate().delete(getHuiTie(id));
			getHibernateTemplate().flush();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
