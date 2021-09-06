package com.strandls.mail.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.service.UserGroupService;
import com.strandls.mail.util.AppUtil.TEMPLATE;
import com.strandls.mail.util.ThreadUtil;

public class UserGroupServiceImpl implements UserGroupService {

	private final Logger logger = LoggerFactory.getLogger(UserGroupServiceImpl.class);
	@Inject
	private ThreadUtil threadUtil;

	@Override
	public void sendInvites(List<MailInfo> info) {
		try {
			String role = info.get(0).getData().get("role").toString();
			threadUtil.startThread(TEMPLATE.UGINVITE.getValue(), "Invitation to join as " + role + " for group", info);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

	@Override
	public void sendRequest(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.UGREQUEST.getValue(), "Request to join as a member in group", info);
	}

}
