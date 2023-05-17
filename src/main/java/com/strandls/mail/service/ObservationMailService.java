package com.strandls.mail.service;

import java.util.List;

import com.strandls.mail.model.MailInfo;

public interface ObservationMailService {
	
	void sendObservationPostToGroupMail(List<MailInfo> info);
	void sendObservationTaggedMail(List<MailInfo> info);
	void sendObservationSuggestedMail(List<MailInfo> info);
	void sendObservationCommentedMail(List<MailInfo> info);
	void sendObservationDeletedCommentMail(List<MailInfo> info);
	void sendObservationDownloadMail(List<MailInfo> info);
	void sendObservationFactAddedMail(List<MailInfo> info);
	void sendObservationFactUpdatedMail(List<MailInfo> info);
	void sendObservationAgreedSpeciesMail(List<MailInfo> info);
	void sendObservationRemovedSpeciesMail(List<MailInfo> info);
	void sendObservationCustomFieldUpdatedMail(List<MailInfo> info);
	void sendObservationFeaturedMail(List<MailInfo> info);
	void sendObservationAddedMail(List<MailInfo> info);
	void sendObservationFlaggedMail(List<MailInfo> info);
	void sendObservationLockedMail(List<MailInfo> info);
	void sendObservationUpdatedMail(List<MailInfo> info);
	void sendObservationUnlockedMail(List<MailInfo> info);
	void sendObservationDeletedMail(List<MailInfo> info);
	void sendRatedMediaMail(List<MailInfo> info);
	void sendObservationTagUpdatedMail(List<MailInfo> info);
	void sendMyUploadsDeletionMail(List<MailInfo> info);

}
