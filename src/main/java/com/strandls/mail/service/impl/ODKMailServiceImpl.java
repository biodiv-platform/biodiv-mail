package com.strandls.mail.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.service.ODKMailService;
import com.strandls.mail.util.ThreadUtil;
import com.strandls.mail.util.AppUtil.TEMPLATE;

public class ODKMailServiceImpl implements ODKMailService {

	@Inject
	private ThreadUtil threadUtil;

	@Override
	public void sendODKUserMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.ODK.getValue(), "ODK user permission ", info);

	}

}
