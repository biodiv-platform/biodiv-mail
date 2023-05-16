package com.strandls.mail.service;

import java.util.List;

import com.strandls.mail.model.MailInfo;

public interface ODKMailService {
	void sendODKUserMail(List<MailInfo> info);

}
