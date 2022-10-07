package com.strandls.mail.service;

import java.util.List;

import com.strandls.mail.model.MailInfo;

public interface DocumentMailService {

	void sendDocumentPostToGroupMail(List<MailInfo> info);

	void sendDocumentCommentedMail(List<MailInfo> info);

	void sendDocumentAddedMail(List<MailInfo> info);

	void sendDocumentFlaggedMail(List<MailInfo> info);

	void sendDocumentUpdatedMail(List<MailInfo> info);

	void sendDocumentDeletedMail(List<MailInfo> info);

	void sendDocumentTaggedMail(List<MailInfo> info);
}
