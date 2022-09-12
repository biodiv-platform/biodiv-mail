package com.strandls.mail.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.service.PageMailService;
import com.strandls.mail.util.AppUtil.TEMPLATE;
import com.strandls.mail.util.ThreadUtil;

public class PageMailServiceImpl implements PageMailService {

	@Inject
	private ThreadUtil threadUtil;

	@Override
	public void sendPageCommentedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.PAGE.getValue(), "New comment in page", info);

	}

	@Override
	public void sendPageAddedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.PAGE.getValue(), "Page added", info);

	}

	@Override
	public void sendPageUpdatedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.PAGE.getValue(), "Page updated", info);

	}

	@Override
	public void sendPageDeletedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.PAGE.getValue(), "Page removed", info);

	}

}
