package com.hck.apptg.pc.action;

import java.util.List;

import com.hck.apptg.bean.Message;
import com.hck.apptg.daoserver.MessageServer;
import com.hck.apptg.util.LogUtil;

public class MessageAction extends BaseAction {
	private MessageServer messageServer;
	private List<Message> messages;
	private Message msg;

	

	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}

	public MessageServer getMessageServer() {
		return messageServer;
	}

	public void setMessageServer(MessageServer messageServer) {
		this.messageServer = messageServer;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public String getMsgs() {
		messages = messageServer.getMessages();
		return SUCCESS;
	}

	public String deleteMsg() {
		messageServer.deleteMessage(id);
		return SUCCESS;
	}

	public String addMsg() {
		messageServer.addMessage(msg);
		return SUCCESS;
	}
}
