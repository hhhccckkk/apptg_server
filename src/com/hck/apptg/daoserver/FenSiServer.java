package com.hck.apptg.daoserver;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.Fensi;

public class FenSiServer extends HibernateDaoSupport {
	public List<Fensi> getFensis(long uid) {
		String sql = "from Fensi f where f.uid="+uid+" order by f.id desc";
		return getHibernateTemplate().find(sql);
	}
	
	
	public List<Fensi> getGuanZhus(long uid) {
		String sql = "from Fensi f where f.fuid="+uid+" order by f.id desc";
		return getHibernateTemplate().find(sql);
	}

	public boolean deleteFenSi(long id) {
		try {
			getHibernateTemplate().delete(
					getHibernateTemplate().get(Fensi.class, id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean addFenSi(Fensi fensi) {
		try {
			getHibernateTemplate().save(fensi);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isGuanZhu(long uid, long fuid) {
		String sql = "from Fensi f where f.uid=" + uid + " and f.fuid=" + fuid;
		List<Fensi> fensis = getHibernateTemplate().find(sql);
		if (fensis != null && !fensis.isEmpty()) {
			return true;
		}
		return false;
	}

}
