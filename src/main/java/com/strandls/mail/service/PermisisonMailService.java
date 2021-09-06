/**
 * 
 */
package com.strandls.mail.service;

import java.util.List;

import com.strandls.mail.model.MailInfo;

/**
 * @author Abhishek Rudra
 *
 * 
 */
public interface PermisisonMailService {

	public void sendPermissionRequest(List<MailInfo> info);

	public void sendPermissionGranted(List<MailInfo> info);

}
