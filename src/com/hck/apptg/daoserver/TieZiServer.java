package com.hck.apptg.daoserver;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.Qudao;
import com.hck.apptg.bean.Ziyuan;

public class TieZiServer extends HibernateDaoSupport {
	private static final int MAX_SIZE = 500;
	private List<Ziyuan> mZiyuans;
	private List<Qudao> mQudaos;

	public List<Ziyuan> getZiyuans(long uid) {
		String sql = "from Ziyuan z where z.user.id="+uid+" order by z.id desc";
		return getList(sql, 1, MAX_SIZE);
	}

	@SuppressWarnings("unchecked")
	private List<Ziyuan> getList(String sql, int page, int num) {
		if (mZiyuans == null) {
			mZiyuans = new ArrayList<Ziyuan>();
		}
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

	public List<Qudao> getQudaos(long uid) {
		String sql = "from Qudao q  where q.user.id="+uid+" order by q.id desc";
		return getListQd(sql, 1, MAX_SIZE);
	}

	@SuppressWarnings("unchecked")
	private List<Qudao> getListQd(String sql, int page, int num) {
		if (mQudaos == null) {
			mQudaos = new ArrayList<Qudao>();
		}
		Query query = null;
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		query = session.createQuery(sql);
		query.setFirstResult((page - 1) * num);
		query.setMaxResults(num);
		mQudaos = query.list();
		super.releaseSession(session);
		return mQudaos;
	}

}
