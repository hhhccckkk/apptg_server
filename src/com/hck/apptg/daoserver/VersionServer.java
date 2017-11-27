package com.hck.apptg.daoserver;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.Version;

public class VersionServer extends HibernateDaoSupport {
	public Version getVersion() {
		Version version = (Version) getHibernateTemplate()
				.get(Version.class, 1);
		return version;
	}

}
