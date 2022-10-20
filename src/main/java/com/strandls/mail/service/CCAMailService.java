package com.strandls.mail.service;

import java.util.List;

import com.strandls.mail.model.MailInfo;

public interface CCAMailService {

	void sendCCAPostToGroupMail(List<MailInfo> info);

	void sendCCACommentedMail(List<MailInfo> info);

	void sendCCAAddedMail(List<MailInfo> info);

	void sendCCAUpdatedMail(List<MailInfo> info);

	void sendCCADeletedMail(List<MailInfo> info);

	void sendCCAFollowMail(List<MailInfo> info);

	void sendCCAUnfollowMail(List<MailInfo> info);

	void sendCCAPermissionMail(List<MailInfo> info);

	void sendCCATemplateAddedMail(List<MailInfo> info);

	void sendCCATemplateUpdatedMail(List<MailInfo> info);

	void sendCCATemplateDeletedMail(List<MailInfo> info);

	void sendCCATemplateTaggedMail(List<MailInfo> info);

	void sendCCAPermissionRemovalMail(List<MailInfo> info);

}
