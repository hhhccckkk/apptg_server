package com.hck.apptg.daoserver;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.Tongzhi;
import com.hck.apptg.util.LogUtil;

public class TongZhiServer extends HibernateDaoSupport {
	public boolean addTz(Tongzhi tongzhi) {
		try {
			getHibernateTemplate().save(tongzhi);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	public List<Tongzhi> getTongzhis(long uid) {
		String sqlString = "from Tongzhi t where t.uid=" + uid
				+ " or t.type=2 order by t.id desc";
		return getHibernateTemplate().find(sqlString);
	}

	public boolean deleteTongZhi(long id) {
		try {
			Tongzhi tongzhi = (Tongzhi) getHibernateTemplate().get(
					Tongzhi.class, id);
			getHibernateTemplate().delete(tongzhi);
			return true;
		} catch (Exception e) {
			LogUtil.log("eeee: "+e);
			return false;
		}

	}
	@SuppressWarnings("unchecked")
	public List<Tongzhi> getTongzhiXT() {
		String sqlString = "from Tongzhi t where t.type=2 order by t.id desc";
		return getHibernateTemplate().find(sqlString);
	}
	

}
