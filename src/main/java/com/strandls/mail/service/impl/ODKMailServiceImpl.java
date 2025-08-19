package com.strandls.mail.service.impl;

import java.util.List;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.service.ODKMailService;
import com.strandls.mail.util.AppUtil.TEMPLATE;
import com.strandls.mail.util.ThreadUtil;

import jakarta.inject.Inject;

public class ODKMailServiceImpl implements ODKMailService {

	@Inject
	private ThreadUtil threadUtil;

	@Override
	public void sendODKUserMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.ODK.getValue(), "ODK user permission ", info);

	}

}
