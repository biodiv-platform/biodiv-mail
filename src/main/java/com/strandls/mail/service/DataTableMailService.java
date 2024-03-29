package com.strandls.mail.service;

import java.util.List;

import com.strandls.mail.model.MailInfo;

public interface DataTableMailService {

	void sendDataTablePostToGroupMail(List<MailInfo> info);

	void sendDataTableCommentedMail(List<MailInfo> info);

	void sendDataTableAddedMail(List<MailInfo> info);

	void sendDataTableDeletedMail(List<MailInfo> info);

	void sendDataTableTaggedMail(List<MailInfo> info);

	void sendDataTableCommentDeleteMail(List<MailInfo> info);

}
