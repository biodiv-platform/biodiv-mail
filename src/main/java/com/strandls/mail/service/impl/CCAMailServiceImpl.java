package com.strandls.mail.service.impl;

import java.util.List;
import javax.inject.Inject;
import com.strandls.mail.model.MailInfo;
import com.strandls.mail.service.CCAMailService;
import com.strandls.mail.util.ThreadUtil;
import com.strandls.mail.util.AppUtil.TEMPLATE;

public class CCAMailServiceImpl implements CCAMailService {

	@Inject
	private ThreadUtil threadUtil;
	
	@Override
	public void sendCCAPostToGroupMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.CCA.getValue(), "Activate your account with ", info);
	}

	@Override
	public void sendCCACommentedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.CCA.getValue(), "CCA comment added", info);
	}

	@Override
	public void sendCCAAddedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.CCA.getValue(), "CCA added", info);
	}

	@Override
	public void sendCCAUpdatedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.CCA.getValue(), "CCA updated", info);
	}

	@Override
	public void sendCCADeletedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.CCA.getValue(), "CCA deleted", info);
	}

	@Override
	public void sendCCAFollowMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.CCA.getValue(), "Added follower to cca data", info);
	}

	@Override
	public void sendCCATemplateAddedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.CCA.getValue(), "Template created", info);
	}

	@Override
	public void sendCCATemplateUpdatedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.CCA.getValue(), "Template updated", info);
	}

	@Override
	public void sendCCATemplateDeletedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.CCA.getValue(), "Template deleted", info);
	}

	@Override
	public void sendCCAPermissionMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.CCA.getValue(), "Added permission to contribute", info);
	}

}
