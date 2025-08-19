package com.strandls.mail.model;

import java.util.Map;

public class MailInfo {

	private String type;
	private String subject;
	private Map<String, Object> data;
	private String[] to;
	private Boolean subscription;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public Boolean getSubscription() {
		return subscription;
	}

	public void setSubscription(Boolean subscription) {
		this.subscription = subscription;
	}

	@Override
	public String toString() {
		return "MailInfo [type=" + type + ", subject=" + subject + ", data=" + data + ", to=" + to + "]";
	}

}
