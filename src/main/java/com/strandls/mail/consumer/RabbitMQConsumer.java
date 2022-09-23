package com.strandls.mail.consumer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.strandls.mail.model.MailInfo;
import com.strandls.mail.model.NotificationInfo;
import com.strandls.mail.model.RecipientInfo;
import com.strandls.mail.service.CCAMailService;
import com.strandls.mail.service.DataTableMailService;
import com.strandls.mail.service.DocumentMailService;
import com.strandls.mail.service.ObservationMailService;
import com.strandls.mail.service.PageMailService;
import com.strandls.mail.service.PermisisonMailService;
import com.strandls.mail.service.SpeciesMailService;
import com.strandls.mail.service.UserGroupService;
import com.strandls.mail.service.UserMailService;
import com.strandls.mail.util.NotificationUtil;
import com.strandls.mail.util.PropertyFileUtil;
import com.strandls.mail_utility.model.EnumModel.MAIL_TYPE;
import com.strandls.mail_utility.util.AppUtil;

public class RabbitMQConsumer {

	@Inject
	private UserMailService userService;

	@Inject
	private ObservationMailService observationService;

	@Inject
	private DocumentMailService documentService;

	@Inject
	private SpeciesMailService speciesService;

	@Inject
	private UserGroupService userGroupService;

	@Inject
	private CCAMailService ccaMailService;

	@Inject
	private PermisisonMailService permissionService;

	@Inject
	private PageMailService pageMailService;

	@Inject
	private DataTableMailService dataTableMailService;

	@Inject
	ObjectMapper mapper;

	private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

	@Inject
	private Channel channel;

	public void getMessage() throws IOException {
		DeliverCallback callback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
			processMessage(message);
		};
		DeliverCallback notificationCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
			processNotification(message);
		};
		channel.basicConsume(PropertyFileUtil.fetchProperty("config.properties", "rabbitmq_queue"), true, callback,
				consumerTag -> {
				});
		channel.basicConsume(PropertyFileUtil.fetchProperty("config.properties", "rabbitmq_n_queue"), true,
				notificationCallback, consumerTag -> {
				});
	}

	private void processMessage(String message) {
		try {
			RecipientInfo recipient = mapper.readValue(message, RecipientInfo.class);
			List<MailInfo> info = new ArrayList<MailInfo>();
			if (recipient.getRecipients() != null) {
				recipient.getRecipients().forEach(r -> {
					MailInfo m = mapper.convertValue(r, MailInfo.class);
					info.add(m);
				});
			}

			if (info.isEmpty()) {
				logger.error("No recipients: {}", recipient.getRecipients());
				return;
			}

			MAIL_TYPE type = AppUtil.getMailType(recipient.getType());
			switch (type) {
			case RESET_PASSWORD:
				userService.sendResetPasswordMail(info);
				break;
			case USER_REGISTRATION:
				userService.sendActivationMail(info);
				break;
			case WELCOME_MAIL:
				userService.sendWelcomeMail(info);
				break;
			case DOWNLOAD_MAIL:
				observationService.sendObservationDownloadMail(info);
				break;

			case SPECIES_ADDED:
				speciesService.sendSpeciesAddedMail(info);
				break;
			case SPECIES_UPDATED:
				speciesService.sendSpeciesUpdatedMail(info);
				break;
			case SPECIES_DELETED:
				speciesService.sendSpeciesDeletedMail(info);
				break;
			case SPECIES_FACT:
				speciesService.sendSpeciesFactUpdateMail(info);
				break;
			case SPECIES_RESOURCE:
				speciesService.sendSpeciesUpdatedResorce(info);
				break;
			case SPECIES_SYNONYMS:
				speciesService.sendSpeciesSynonymUpdateMail(info);
				break;
			case SPECIES_COMMON_NAME:
				speciesService.sendSpeciesCommonNameUpdateMail(info);
				break;
			case SPECIES_FIELD_ADDED:
				speciesService.sendSpeciesFieldAddedMail(info);
				break;
			case SPECIES_FIELD_DELETED:
				speciesService.sendSpeciesFieldDeletedMail(info);
				break;
			case SPECIES_FIELD_UPDATED:
				speciesService.sendSpeciesFieldUpdatedMail(info);
				break;

			case SPECIES_POST_TO_GROUP:
				speciesService.sendSpeciesPostToGroupMail(info);
				break;
			case SPECIES_COMMENT_POST:
				speciesService.sendSpeciesCommentedMail(info);
				break;

			case DOCUMENT_ADDED:
				documentService.sendDocumentAddedMail(info);
				break;
			case DOCUMENT_UPDATED:
				documentService.sendDocumentUpdatedMail(info);
				break;
			case DOCUMENT_DELETED:
				documentService.sendDocumentDeletedMail(info);
				break;
			case DOCUMENT_FLAGGED:
				documentService.sendDocumentFlaggedMail(info);
				break;
			case DOCUMENT_POST_TO_GROUP:
				documentService.sendDocumentPostToGroupMail(info);
				break;
			case DOCUMENT_COMMENT_POST:
				documentService.sendDocumentCommentedMail(info);
				break;

			case COMMENT_POST:
				observationService.sendObservationCommentedMail(info);
				break;
			case SUGGEST_MAIL:
				observationService.sendObservationSuggestedMail(info);
				break;
			case TAGGED_MAIL:
				observationService.sendObservationTaggedMail(info);
				break;
			case POST_TO_GROUP:
				observationService.sendObservationPostToGroupMail(info);
				break;
			case FACT_ADDED:
				observationService.sendObservationFactAddedMail(info);
				break;
			case FACT_UPDATED:
				observationService.sendObservationFactUpdatedMail(info);
				break;
			case AGREED_SPECIES:
				observationService.sendObservationAgreedSpeciesMail(info);
				break;
			case REMOVED_SPECIES:
				observationService.sendObservationRemovedSpeciesMail(info);
				break;
			case CUSTOM_FIELD_UPDATED:
				observationService.sendObservationCustomFieldUpdatedMail(info);
				break;
			case FEATURED_POST:
				observationService.sendObservationFeaturedMail(info);
				break;
			case FEATURED_POST_IBP:
				observationService.sendObservationFeaturedMail(info);
				break;
			case OBSERVATION_ADDED:
				observationService.sendObservationAddedMail(info);
				break;
			case OBSERVATION_FLAGGED:
				observationService.sendObservationFlaggedMail(info);
				break;
			case OBSERVATION_LOCKED:
				observationService.sendObservationLockedMail(info);
				break;
			case OBSERVATION_UNLOCKED:
				observationService.sendObservationUnlockedMail(info);
				break;
			case OBSERVATION_UPDATED:
				observationService.sendObservationUpdatedMail(info);
				break;
			case OBSERVATION_DELETED:
				observationService.sendObservationDeletedMail(info);
				break;
			case CCA_DATA_ADDED:
				ccaMailService.sendCCAAddedMail(info);
				break;
			case CCA_DATA_DELETED:
				ccaMailService.sendCCADeletedMail(info);
				break;
			case CCA_DATA_UPDATED:
				ccaMailService.sendCCAUpdatedMail(info);
				break;
			case CCA_TEMPLATE_ADDED:
				ccaMailService.sendCCATemplateAddedMail(info);
				break;
			case CCA_TEMPLATE_DELETED:
				ccaMailService.sendCCATemplateDeletedMail(info);
				break;
			case CCA_TEMPLATE_UPDATED:
				ccaMailService.sendCCATemplateUpdatedMail(info);
				break;
			case CCA_DATA_COMMENT:
			case CCA_TEMPLATE_COMMENT:
				ccaMailService.sendCCACommentedMail(info);
				break;
			case CCA_DATA_FOLLOW:
				ccaMailService.sendCCAFollowMail(info);
				break;
			case CCA_DATA_UNFOLLOW:
				ccaMailService.sendCCAUnfollowMail(info);
				break;
			case CCA_DATA_PERMISSION:
				ccaMailService.sendCCAPermissionMail(info);
				break;
			case RATED_MEDIA_RESOURCE:
				observationService.sendRatedMediaMail(info);
				break;
			case TAG_UPDATED:
				observationService.sendObservationTagUpdatedMail(info);
				break;
			case MY_UPLOADS_DELETE_MAIL:
				observationService.sendMyUploadsDeletionMail(info);
				break;
			case SEND_INVITE:
				userGroupService.sendInvites(info);
				break;
			case SEND_REQUEST:
				userGroupService.sendRequest(info);
				break;
			case PERMISSION_REQUEST:
				permissionService.sendPermissionRequest(info);
				break;
			case PERMISSION_GRANTED:
				permissionService.sendPermissionGranted(info);
				break;
			case PAGE_COMMENT_POST:
				pageMailService.sendPageCommentedMail(info);
				break;
			case PAGE_CREATE:
				pageMailService.sendPageAddedMail(info);
				break;
			case PAGE_UPDATE:
				pageMailService.sendPageUpdatedMail(info);
				break;
			case PAGE_DELETED:
				pageMailService.sendPageDeletedMail(info);
				break;
			case DATATABLE_CREATED:
				dataTableMailService.sendDataTableAddedMail(info);
				break;
			case DATATABLE_DELETED:
				dataTableMailService.sendDataTableDeletedMail(info);
				break;
			case DATATABLE_COMMENT_POST:
				dataTableMailService.sendDataTableCommentedMail(info);
				break;
			case DATATABLE_POST_TO_GROUP:
				dataTableMailService.sendDataTablePostToGroupMail(info);
				break;

			default:
				logger.error("Invalid mail type: {}", type);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Could not resolve: {}", ex.getMessage());
		}
	}

	private void processNotification(String message) {
		try {
			NotificationInfo info = mapper.readValue(message, NotificationInfo.class);
			if (info != null) {
				NotificationUtil notification = new NotificationUtil();
				notification.sendNotification(message);
			}
		} catch (Exception ex) {
			logger.error("Could not resolve: {}", ex.getMessage());
		}
	}

}
