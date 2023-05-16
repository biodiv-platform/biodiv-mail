package com.strandls.mail.util;

public class AppUtil {

	/**
	 * 
	 */
	private AppUtil() {
		super();
	}

	public enum MAIL_TYPE {
		INVALID("INVALID"), USER_REGISTRATION("USER_REGISTRATION"), RESET_PASSWORD("RESET_PASSWORD"),
		WELCOME_MAIL("WELCOME_MAIL"), DOWNLOAD_MAIL("DOWNLOAD_MAIL"), TAGGED_MAIL("TAGGED_MAIL"),
		COMMENT_POST("COMMENT_POST"), POST_TO_GROUP("POST_TO_GROUP"), SUGGEST_MAIL("SUGGEST_MAIL");

		private String action;

		private MAIL_TYPE(String action) {
			this.action = action;
		}

		public String getAction() {
			return action;
		}
	}

	public static MAIL_TYPE getMailType(String type) {
		for (MAIL_TYPE types : MAIL_TYPE.values()) {
			if (types.name().equalsIgnoreCase(type)) {
				return types;
			}
		}
		return MAIL_TYPE.INVALID;
	}

	public enum TEMPLATE {
		SPECIES("species.ftlh"), OBSERVATION("observation.ftlh"), PAGE("page.ftlh"), DOCUMENT("document.ftlh"),
		DELETION("deletion.ftlh"), WELCOME("welcome.ftlh"), UGINVITE("invite.ftlh"), UGREQUEST("request.ftlh"),
		AUTHENTICATION("auth.ftlh"), CCA("cca.ftlh"), DATATABLE("datatable.ftlh"), ODK("odk-request-granted.ftlh");

		private String action;

		private TEMPLATE(String action) {
			this.action = action;
		}

		public String getValue() {
			return action;
		}
	}

}
