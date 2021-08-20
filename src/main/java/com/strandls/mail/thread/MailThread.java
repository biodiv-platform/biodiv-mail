package com.strandls.mail.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.strandls.mail.util.MailUtil;

public class MailThread extends MailUtil implements Runnable {

	private final Logger logger = LoggerFactory.getLogger(MailThread.class);

	public MailThread(String[] to, String[] bcc, String subject, String content, boolean isHTML) {
		super(to, bcc, subject, content, isHTML);
	}

	@Override
	public void run() {
		try {
			sendMail();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
	}

}
