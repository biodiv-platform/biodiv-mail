package com.strandls.mail.model;

import java.util.Map;

public class NotificationInfo {

	private String to;
	private Map<String, String> notification;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Map<String, String> getNotification() {
		return notification;
	}

	public void setNotification(Map<String, String> notification) {
		this.notification = notification;
	}

	@Override
	public String toString() {
		return "NotificationInfo [to=" + to + ", notification=" + notification + "]";
	}

}
