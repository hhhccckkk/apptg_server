package com.hck.apptg.daoserver;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.Ziyuan;
import com.hck.apptg.vo.Contans;

public class ZiYuanDaoServer extends HibernateDaoSupport {
	private List<Ziyuan> mZiyuans;

	public long addZiYuan(Ziyuan ziyuan) {
		try {
			return (Long) getHibernateTemplate().save(ziyuan);
		} catch (Exception e) {
			return 0;
		}
	}

	public List<Ziyuan> getZiyuans(int page, int key) {
		String sql = null;
		switch (key) {
		case Contans.JIAGE_GAO:
			sql = "from Ziyuan z order by z.jiage desc";
			break;
		case Contans.JIAGE_DI:
			sql = "from Ziyuan z order by z.jiage asc";
			break;
		case Contans.ANZHUO:
			sql = "from Ziyuan z where z.xitong='安卓' order by z.id desc,z.istj desc";
			break;
		case Contans.IOS:
			sql = "from Ziyuan z where z.xitong='IOS' order by z.id desc,z.istj desc";
			break;
		case Contans.PC:
			sql = "from Ziyuan z where z.xitong='PC' order by z.id desc,z.istj desc";
			break;
		case Contans.RI_JIE:
			sql = "from Ziyuan z where z.jiesuantime='日结' order by z.id desc,z.istj desc";
			break;
		case Contans.ZHOU_JIE:
			sql = "from Ziyuan z where z.jiesuantime='周结' order by z.id desc,z.istj desc";
			break;
		case Contans.YUE_JIE:
			sql = "from Ziyuan z where z.jiesuantime='月结' order by z.id desc,z.istj desc";
			break;
		default:
			break;
		}
		return getList(sql, page, 10);
	}

	public List<Ziyuan> getZiYuanInfo(int page, int num) {
		String sql = "from Ziyuan z order by z.id desc,z.istj desc";
		return getList(sql, page, num);
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

	public int getCount(long uid) {
		String sql = "from Ziyuan";
		return this.getHibernateTemplate().find(sql).size();
	}
	public Ziyuan getZiYuan(long id){
		return (Ziyuan) getHibernateTemplate().get(Ziyuan.class, id);
	}

}
