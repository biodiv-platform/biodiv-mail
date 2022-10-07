package com.strandls.mail.model;

import java.util.List;
import java.util.Map;

public class RecipientInfo {

	private String type;
	private String objectType;
	private List<Map<String, Object>> recipients;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Map<String, Object>> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<Map<String, Object>> recipients) {
		this.recipients = recipients;
	}

	@Override
	public String toString() {
		return "RecipientInfo [type=" + type + ", recipients=" + recipients + "]";
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

}
