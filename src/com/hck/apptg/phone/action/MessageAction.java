package com.hck.apptg.phone.action;

import java.util.List;

import com.hck.apptg.bean.Message;
import com.hck.apptg.daoserver.MessageServer;
import com.hck.apptg.vo.Contans;

public class MessageAction extends BaseAction {
	private MessageServer messageServer;

	public MessageServer getMessageServer() {
		return messageServer;
	}

	public void setMessageServer(MessageServer messageServer) {
		this.messageServer = messageServer;
	}

	public void getMessages() {
		List<Message> messages = messageServer.getMessages();
		if (messages != null && !messages.isEmpty()) {
			json.put("code", Contans.SUCCESS);
			json.put("data", messages);
		} else {
			json.put("code", Contans.ERROR);
		}
		write();
	}

}
