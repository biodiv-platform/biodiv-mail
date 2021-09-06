package com.strandls.mail.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.service.ObservationMailService;
import com.strandls.mail.util.AppUtil.TEMPLATE;
import com.strandls.mail.util.ThreadUtil;

public class ObservationMailServiceImpl implements ObservationMailService {

	@Inject
	private ThreadUtil threadUtil;

	@Override
	public void sendObservationPostToGroupMail(List<MailInfo> info) {
		String submitType = info.get(0).getData().get("submitType").toString();
		String subject;
		if (submitType.equalsIgnoreCase("post")) {
			subject = "Posted observation to group";
		} else {
			subject = "Removed observation from group";
		}

		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), subject, info);
	}

	@Override
	public void sendObservationTaggedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "Tagged in observation comment", info);
	}

	@Override
	public void sendObservationSuggestedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "Species name suggested", info);
	}

	@Override
	public void sendObservationCommentedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "New comment in observation", info);
	}

	@Override
	public void sendObservationDownloadMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "Download request", info);
	}

	@Override
	public void sendObservationFactAddedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "Fact added", info);
	}

	@Override
	public void sendObservationFactUpdatedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "Fact updated", info);
	}

	@Override
	public void sendObservationAgreedSpeciesMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "Species name suggested", info);
	}

	@Override
	public void sendObservationRemovedSpeciesMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "Species name deleted", info);
	}

	@Override
	public void sendObservationCustomFieldUpdatedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "Custom field edited", info);
	}

	@Override
	public void sendObservationFeaturedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "Featured observation", info);
	}

	@Override
	public void sendObservationAddedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "Observation added", info);
	}

	@Override
	public void sendObservationFlaggedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "Observation flagged", info);
	}

	@Override
	public void sendObservationLockedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "Validated and locked species name", info);
	}

	@Override
	public void sendObservationUpdatedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "Observation updated", info);
	}

	@Override
	public void sendObservationUnlockedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "Unlocked species name", info);
	}

	@Override
	public void sendObservationTagUpdatedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "Observation tag updated", info);
	}

	@Override
	public void sendObservationDeletedMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "Observation deleted", info);
	}

	@Override
	public void sendRatedMediaMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.OBSERVATION.getValue(), "Observation media rated", info);
	}

	@Override
	public void sendMyUploadsDeletionMail(List<MailInfo> info) {
		threadUtil.startThread(TEMPLATE.DELETION.getValue(), "Attn: Your image uploads are due for deletion", info);
	}

}
