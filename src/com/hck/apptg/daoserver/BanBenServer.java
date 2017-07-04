package com.hck.apptg.daoserver;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.Version;

public class BanBenServer extends HibernateDaoSupport {
	public Version getVersion(int id) {
		return (Version) getHibernateTemplate().get(Version.class, id);
	}

}
