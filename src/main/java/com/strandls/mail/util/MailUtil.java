package com.strandls.mail.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {

	private String[] to;
	private String[] bcc;
	private String subject;
	private String text;
	private boolean isHtml;

	private static final String USERNAME;
	private static final String PASSWORD;
	private static final String MAILSENDEREMAIL;
	private static final String SMTPHOST;
	private static final String SMTPPORT;

	static {
		Properties prop = PropertyFileUtil.fetchProperty("config.properties");
		USERNAME = prop.getProperty("mail_smtp_username");
		PASSWORD = prop.getProperty("mail_smtp_password");
		MAILSENDEREMAIL = prop.getProperty("mail_sender_email");
		SMTPHOST = prop.getProperty("mail_smtp_host");
		SMTPPORT = prop.getProperty("mail_smtp_port");
	}

	public MailUtil() {
	}

	public MailUtil(String[] to, String[] bcc, String subject, String text, boolean isHtml) {
		this.to = to;
		this.bcc = bcc;
		this.subject = subject;
		this.text = text;
		this.isHtml = isHtml;
	}

	public void sendMail() throws MessagingException, AddressException {
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", SMTPHOST);
		props.setProperty("mail.smtp.port", SMTPPORT);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.debug", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USERNAME, PASSWORD);
			}
		});

		MimeMessage message = new MimeMessage(session);
		List<InternetAddress> address = new ArrayList<>();
		for (String recipient : to) {
			address.add(new InternetAddress(recipient));
		}
		List<InternetAddress> bccAddress = new ArrayList<>();
		for (String recipient : bcc) {
			bccAddress.add(new InternetAddress(recipient));
		}
		InternetAddress[] addresses = new InternetAddress[address.size()];
		InternetAddress[] bccAddresses = new InternetAddress[address.size()];
		message.setFrom(new InternetAddress(MAILSENDEREMAIL));
		message.addRecipients(Message.RecipientType.TO, address.toArray(addresses));
		if (!bccAddress.isEmpty()) {
			message.addRecipients(Message.RecipientType.BCC, bccAddress.toArray(bccAddresses));
		}
		message.setSubject(subject);
		message.setContent(text, isHtml ? "text/html" : "text/plain");

		Transport.send(message);
	}

}
