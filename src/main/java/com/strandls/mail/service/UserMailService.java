package com.strandls.mail.service;

import java.util.List;

import com.strandls.mail.model.MailInfo;

public interface UserMailService {

	void sendActivationMail(List<MailInfo> info);

	void sendWelcomeMail(List<MailInfo> info);

	void sendResetPasswordMail(List<MailInfo> info);

}
