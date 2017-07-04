package com.hck.apptg.daoserver;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.Fankui;

public class FanKuiServer extends HibernateDaoSupport {
	public boolean addFanKui(Fankui fankui) {
		try {
			getHibernateTemplate().save(fankui);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Fankui> getFankuis() {
		return getHibernateTemplate().find("from Fankui f order by f.id desc");
	}

	public boolean deleteFanKui(long id) {
		try {
			Fankui fankui = (Fankui) getHibernateTemplate().get(Fankui.class,
					id);
			getHibernateTemplate().delete(fankui);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
