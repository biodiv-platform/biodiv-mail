/**
 * 
 */
package com.strandls.mail.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.service.PermisisonMailService;
import com.strandls.mail.util.ThreadUtil;

/**
 * @author Abhishek Rudra
 *
 * 
 */
public class PermisisonMailServiceImpl implements PermisisonMailService {

	@Inject
	private ThreadUtil threadUtil;

	@Override
	public void sendPermissionRequest(List<MailInfo> info) {
		String role = info.get(0).getData().get("role").toString();
		threadUtil.startThread("taxon-request.ftlh", "Permission Request for the role of " + role, info);

	}

	@Override
	public void sendPermissionGranted(List<MailInfo> info) {
		String role = info.get(0).getData().get("role").toString();
		threadUtil.startThread("taxon-request-granted.ftlh", "Permission Granted for the role of " + role, info);

	}

}
