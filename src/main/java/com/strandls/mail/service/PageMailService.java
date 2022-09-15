package com.strandls.mail.service;

import java.util.List;

import com.strandls.mail.model.MailInfo;

public interface PageMailService {
	void sendPageCommentedMail(List<MailInfo> info);

	void sendPageAddedMail(List<MailInfo> info);

	void sendPageUpdatedMail(List<MailInfo> info);

	void sendPageDeletedMail(List<MailInfo> info);

}
