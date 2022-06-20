package com.strandls.mail.service;

import java.util.List;

import com.strandls.mail.model.MailInfo;

public interface SpeciesMailService {

	void sendSpeciesPostToGroupMail(List<MailInfo> info);

	void sendSpeciesCommentedMail(List<MailInfo> info);

	void sendSpeciesAddedMail(List<MailInfo> info);

	void sendSpeciesFactUpdateMail(List<MailInfo> info);

	void sendSpeciesCommonNameUpdateMail(List<MailInfo> info);

	void sendSpeciesSynonymUpdateMail(List<MailInfo> info);

	void sendSpeciesFieldUpdatedMail(List<MailInfo> info);
	
	void sendSpeciesFieldDeletedMail(List<MailInfo> info);
	
	void sendSpeciesFieldAddedMail(List<MailInfo> info);

	void sendSpeciesUpdatedMail(List<MailInfo> info);

	void sendSpeciesUpdatedResorce(List<MailInfo> info);

	void sendSpeciesDeletedMail(List<MailInfo> info);
}