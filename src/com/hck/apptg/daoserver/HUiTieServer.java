package com.hck.apptg.daoserver;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.Huitie;
import com.hck.apptg.util.LogUtil;

public class HUiTieServer extends HibernateDaoSupport {
	public boolean addHuiTie(Huitie huitie) {
		try {
			getHibernateTemplate().save(huitie);
			getHibernateTemplate().flush();
			return true;
		} catch (Exception e) {
			LogUtil.log("HUiTieServer e: "+e);
			return false;
			
		}
	}

	@SuppressWarnings("unchecked")
	public List<Huitie> getHuities(long tid) {
		String sqlString = "from Huitie h where h.tid=" + tid;
		return getHibernateTemplate().find(sqlString);
	}
	
	@SuppressWarnings("unchecked")
	public List<Huitie> getHuiFus(long uid) {
		String sqlString = "from Huitie h where h.buid=" + uid;
		return getHibernateTemplate().find(sqlString);
	}

}
