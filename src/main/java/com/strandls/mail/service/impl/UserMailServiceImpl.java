package com.strandls.mail.service.impl;

import java.util.List;
import java.util.Properties;

import javax.inject.Inject;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.service.UserMailService;
import com.strandls.mail.util.AppUtil.TEMPLATE;
import com.strandls.mail.util.PropertyFileUtil;
import com.strandls.mail.util.ThreadUtil;

public class UserMailServiceImpl implements UserMailService {

	@Inject
	private ThreadUtil threadUtil;

	private Properties props = PropertyFileUtil.fetchProperty("config.properties");
	String portalName = props.getProperty("siteName");

	@Override
	public void sendActivationMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.AUTHENTICATION.getValue(), "Activate your account with " + portalName, info);
	}

	@Override
	public void sendWelcomeMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.WELCOME.getValue(), "Welcome to " + portalName, info);
	}

	@Override
	public void sendResetPasswordMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.AUTHENTICATION.getValue(), "Reset password with " + portalName, info);
	}

}
