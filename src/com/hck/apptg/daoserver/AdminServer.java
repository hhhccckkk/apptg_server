package com.hck.apptg.daoserver;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.Admin;
import com.hck.apptg.util.LogUtil;

public class AdminServer extends HibernateDaoSupport {
	public Admin login(Admin admin) {
		List<Admin> admin2 = null;
		Admin admin3 = null;
		String sql = "from Admin a where a.name='" + admin.getName()
				+ "' and a.password='" + admin.getPassword() + "'";
		admin2 = this.getHibernateTemplate().find(sql);
		if (admin2.size() > 0) {
			admin3 = admin2.get(0);
		}
		return admin3;
	}

}
