package com.strandls.mail.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.service.DataTableMailService;
import com.strandls.mail.util.ThreadUtil;
import com.strandls.mail.util.AppUtil.TEMPLATE;

public class DataTableServiceImpl implements DataTableMailService {

	@Inject
	private ThreadUtil threadUtil;

	@Override
	public void sendDataTablePostToGroupMail(List<MailInfo> info) {
		String submitType = info.get(0).getData().get("submitType").toString();
		String subject;
		if (submitType.equalsIgnoreCase("post")) {
			subject = "Posted DataTable to group";
		} else {
			subject = "Removed DataTable from group";
		}

		threadUtil.startThread(TEMPLATE.DATATABLE.getValue(), subject, info);

	}

	@Override
	public void sendDataTableCommentedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.DATATABLE.getValue(), "New comment in DataTable", info);

	}

	@Override
	public void sendDataTableAddedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.DATATABLE.getValue(), "DataTable added", info);

	}


	@Override
	public void sendDataTableDeletedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.DATATABLE.getValue(), "DataTable deleted", info);

	}

}
