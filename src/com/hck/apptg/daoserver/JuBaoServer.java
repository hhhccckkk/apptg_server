package com.hck.apptg.daoserver;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.Jubao;
import com.hck.apptg.util.LogUtil;

public class JuBaoServer extends HibernateDaoSupport {

	public boolean addJuBao(Jubao jubao) {
		try {
			getHibernateTemplate().save(jubao);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
