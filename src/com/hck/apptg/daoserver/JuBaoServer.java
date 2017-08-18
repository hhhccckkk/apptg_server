package com.hck.apptg.daoserver;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.Jubao;
import com.hck.apptg.bean.User;
import com.hck.apptg.util.LogUtil;
import com.opensymphony.xwork2.ActionContext;

public class JuBaoServer extends HibernateDaoSupport {

	public boolean addJuBao(Jubao jubao) {
		try {
			getHibernateTemplate().save(jubao);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Jubao> getJuBao(int page) {
		String sqlString = "from Jubao j order by  j.id desc";
		ActionContext.getContext().getSession()
				.put("jubaoSize", getCount(sqlString));
		return getList(sqlString, page, 20);
	}

	@SuppressWarnings("unchecked")
	private List<Jubao> getList(String sql, int page, int num) {
		List<Jubao> jubaos = new ArrayList<Jubao>();
		Query query = null;
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		query = session.createQuery(sql);
		query.setFirstResult((page - 1) * num);
		query.setMaxResults(num);
		jubaos = query.list();
		super.releaseSession(session);
		return jubaos;
	}

	private int getCount(String sql) {

		return this.getHibernateTemplate().find(sql).size();
	}

	public void deleteJuBao(long id) {
		getHibernateTemplate().delete(
				getHibernateTemplate().get(Jubao.class, id));
		getHibernateTemplate().flush();
	}

}
