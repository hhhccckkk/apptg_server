package com.hck.apptg.daoserver;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.apptg.bean.Message;

public class MessageServer extends HibernateDaoSupport {
	public List<Message> getMessages() {
		return getHibernateTemplate().find("from Message m order by m.id desc");
	}

	public boolean deleteMessage(long id) {
		try {
			Message message = (Message) getHibernateTemplate().get(
					Message.class, id);
			getHibernateTemplate().delete(message);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void addMessage(Message message) {
		getHibernateTemplate().save(message);
	}

	
}
