package com.strandls.mail.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.service.SpeciesMailService;
import com.strandls.mail.util.ThreadUtil;
import com.strandls.mail.util.AppUtil.TEMPLATE;

public class SpeciesMailServiceImpl implements SpeciesMailService {
	

	@Inject
	private ThreadUtil threadUtil;

	@Override
	public void sendSpeciesPostToGroupMail(List<MailInfo> info) {
		String submitType = info.get(0).getData().get("submitType").toString();
		String subject;
		if (submitType.equalsIgnoreCase("post")) {
			subject = "Posted species to group";
		} else {
			subject = "Removed species from group";
		}

		threadUtil.startThread(TEMPLATE.SPECIES.getValue(), subject, info);



	}

	@Override
	public void sendSpeciesCommentedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.SPECIES.getValue(), "New comment in species", info);

	}
	
	@Override
	public void sendSpeciesDeletedCommentMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.SPECIES.getValue(), "Deleted a comment in species", info);

	}

	@Override
	public void sendSpeciesAddedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.SPECIES.getValue(), "Species added", info);

	}

	@Override
	public void sendSpeciesFactUpdateMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.SPECIES.getValue(), "Species traits updated", info);

	}


	@Override
	public void sendSpeciesUpdatedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.SPECIES.getValue(), "Species updated", info);

	}

	@Override
	public void sendSpeciesDeletedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.SPECIES.getValue(), "Species removed", info);

	}

	@Override
	public void sendSpeciesCommonNameUpdateMail(List<MailInfo> info) {
		
		String submitType = info.get(0).getData().get("submitType").toString();
		String subject;
		if (submitType.equalsIgnoreCase("post")) {
			subject = "Species common name updated";
		} else {
			subject = "Species common name removed";
		}

		threadUtil.startThread(TEMPLATE.SPECIES.getValue(),subject , info);

		
	}

	@Override
	public void sendSpeciesSynonymUpdateMail(List<MailInfo> info) {
		String submitType = info.get(0).getData().get("submitType").toString();
		String subject;
		if (submitType.equalsIgnoreCase("post")) {
			subject = "Species  synonyms  updated";
		} else {
			subject = "Species synonyms removed";
		}
		threadUtil.startThread(TEMPLATE.SPECIES.getValue(), subject, info);

		
	}

	@Override
	public void sendSpeciesFieldUpdatedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.SPECIES.getValue(), "Species field updated", info);

		
	}

	@Override
	public void sendSpeciesUpdatedResorce(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.SPECIES.getValue(), "Species resource updated", info);		
	}

	@Override
	public void sendSpeciesFieldDeletedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.SPECIES.getValue(), "Species field removed", info);
		
	}

	@Override
	public void sendSpeciesFieldAddedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.SPECIES.getValue(), "Species field added", info);
		
	}

	@Override
	public void sendSpeciesTaggedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.SPECIES.getValue(), "Tagged in species comment", info);
		
	}

}
