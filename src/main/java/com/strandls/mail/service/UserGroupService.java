package com.strandls.mail.service;

import java.util.List;

import com.strandls.mail.model.MailInfo;

public interface UserGroupService {

	public void sendInvites(List<MailInfo> info);

	public void sendRequest(List<MailInfo> info);

}
