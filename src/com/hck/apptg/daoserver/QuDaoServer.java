package com.hck.apptg.daoserver;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.Qudao;
import com.opensymphony.xwork2.ActionContext;

public class QuDaoServer extends HibernateDaoSupport {
	private List<Qudao> mQudaos;

	public List<Qudao> getQudaos(int page, int key) {
		String sql = null;
		switch (key) {
		case 1:
			sql = "from Qudao q where q.leixing='联盟' order by q.id desc";
			break;
		case 2: // IOS平台
			sql = "from Qudao q where q.leixing='应用' order by q.id desc";
			break;
		case 3: // PC平台
			sql = "from Qudao q where q.leixing='网站' order by q.id desc";
			break;
		case 4: // 量级从高到低
			sql = "from Qudao q where q.leixing='市场' order by q.id desc";
			break;
		case 5: // 量级从低到高
			sql = "from Qudao q where q.leixing='预装' order by q.id desc";
			break;
		case 6: // 量级从低到高
			sql = "from Qudao q where q.leixing='地推' order by q.id desc";
			break;
		case 7: // 量级从低到高
			sql = "from Qudao q where q.leixing='其他' order by q.id desc";
			break;

		case 100: // 量级从低到高
			sql = "from Qudao q where q.dengji=100 order by q.id desc";
			break;
		case 101: // 量级从低到高
			sql = "from Qudao q where q.dengji=101 order by q.id desc";
			break;
		case 102: // 量级从低到高
			sql = "from Qudao q where q.dengji=102 order by q.id desc";
			break;
		case 103: // 量级从低到高
			sql = "from Qudao q where q.dengji=103 order by q.id desc";
			break;
		case 104: // 量级从低到高
			sql = "from Qudao q where q.dengji=104 order by q.id desc";
			break;
		case 105: // 量级从低到高
			sql = "from Qudao q where q.dengji=105 order by q.id desc";
			break;
		case 106: // 量级从低到高
			sql = "from Qudao q where q.dengji=106 order by q.id desc";
			break;
		default:
			sql = "from Qudao q where q.isok=1 and q.istj=0 order by q.id desc";
			break;
		}
		return getList(sql, page, 10);
	}

	public List<Qudao> getTj() {
		String sql = " from Qudao q where q.istj=1 and q.isok=1";
		return getHibernateTemplate().find(sql);
	}

	@SuppressWarnings("unchecked")
	private List<Qudao> getList(String sql, int page, int num) {
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

	public boolean addQuDao(Qudao qudao) {
		try {
			getHibernateTemplate().save(qudao);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public int getCount(long uid) {
		String sql = "from Qudao";
		return this.getHibernateTemplate().find(sql).size();
	}

	private int getSize(String sql) {
		return getHibernateTemplate().find(sql).size();
	}

	/**
	 * pc
	 */
	public List<Qudao> getQudaos(int page) {
		String sql = "from Qudao z where z.istj=0 order by z.id desc";
		ActionContext.getContext().getSession().put("qudaoSize", getSize(sql));
		return getList(sql, page, 20);
	}

	public List<Qudao> getQudaos(int page, long uid) {
		String sql = "from Qudao z where z.user.id=" + uid
				+ "order by z.id desc";
		ActionContext.getContext().getSession().put("qudaoSize", getSize(sql));
		return getList(sql, page, 20);
	}

	public void updateState(long id, int type) {
		Qudao qudao = (Qudao) getHibernateTemplate().get(Qudao.class, id);
		if (type == 1) {
			int istj = qudao.getIstj() == 1 ? 0 : 1;
			qudao.setIstj(istj);
		} else {
			int isok = qudao.getIsok() == 1 ? 0 : 1;
			qudao.setIsok(isok);
		}
		getHibernateTemplate().update(qudao);
		getHibernateTemplate().flush();
	}

}
