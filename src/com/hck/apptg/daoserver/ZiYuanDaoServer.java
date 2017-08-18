package com.hck.apptg.daoserver;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.Ziyuan;
import com.hck.apptg.vo.Contans;
import com.opensymphony.xwork2.ActionContext;

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

	public List<Ziyuan> getZiyuanTJ() {
		String sql = "from Ziyuan z where z.istj=1 and z.isok=1 order by z.id desc";
		return getHibernateTemplate().find(sql);
	}

	public List<Ziyuan> getZiYuanInfo(int page, int num) {
		String sql = "from Ziyuan z where z.isok=1 and z.istj=0 order by z.id desc,z.istj desc";
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

	public Ziyuan getZiYuan(long id) {
		return (Ziyuan) getHibernateTemplate().get(Ziyuan.class, id);
	}

	private int getZiyuan(String sql) {
		return getHibernateTemplate().find(sql).size();
	}

	/**
	 * pc使用
	 * 
	 * @param page
	 * @return
	 */
	public List<Ziyuan> getZiYuanInfo(int page) {
		String sql = "from Ziyuan z where z.istj=0 order by z.id desc,z.istj desc";
		ActionContext.getContext().getSession()
				.put("ziyuanSize", getZiyuan(sql));
		return getList(sql, page, 20);
	}
	
	public List<Ziyuan> getUserTieZi(int page,long uid) {
		String sql = "from Ziyuan z where z.user.id="+uid+" order by z.id desc,z.istj desc";
		ActionContext.getContext().getSession()
				.put("ziyuanSize", getZiyuan(sql));
		return getList(sql, page, 20);
	}

	/**
	 * 删除资源
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteZiYuan(Long id) {
		Ziyuan ziyuan = (Ziyuan) getHibernateTemplate().get(Ziyuan.class, id);
		if (ziyuan != null) {
			getHibernateTemplate().delete(ziyuan);
		}
		return true;
	}

	/**
	 * 删除资源
	 * 
	 * @param id
	 * @return
	 */
	public boolean updateZiYuan(Long id) {
		Ziyuan ziyuan = (Ziyuan) getHibernateTemplate().get(Ziyuan.class, id);
		if (ziyuan != null) {
			int isok = ziyuan.getIsok() == 0 ? 1 : 0;
			ziyuan.setIsok(isok);
			getHibernateTemplate().update(ziyuan);
			getHibernateTemplate().flush();
		}
		return true;
	}

	/**
	 * 修改推荐状态
	 * 
	 * @param id
	 * @return
	 */
	public boolean tuijian(Long id) {
		Ziyuan ziyuan = (Ziyuan) getHibernateTemplate().get(Ziyuan.class, id);
		if (ziyuan != null) {
			int istj = ziyuan.getIstj() == 0 ? 1 : 0;
			ziyuan.setIstj(istj);
			getHibernateTemplate().update(ziyuan);
			getHibernateTemplate().flush();
		}
		return true;
	}

}
