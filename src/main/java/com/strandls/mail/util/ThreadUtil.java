package com.strandls.mail.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.thread.MailThread;

public class ThreadUtil {

	@Inject
	private TemplateUtil templateUtil;

	@SuppressWarnings("unchecked")
	public void startThread(String templateFile, String mailSubject, List<MailInfo> recipients) {
		String subject = "";
		String content = "";
		if (recipients != null) {
			for (MailInfo info : recipients) {

				Map<String, Object> data = info.getData();
				if (data != null) {
					System.out.println("Before manipulation");
					System.out.println(info.toString());

					data.put("siteName", PropertyFileUtil.fetchProperty("config.properties", "siteName"));
					data.put("serverUrl", PropertyFileUtil.fetchProperty("config.properties", "serverUrl"));

					Map<String, Object> whatPosted = (Map<String, Object>) data.get("whatPosted");
					if (whatPosted != null) {
						if(whatPosted.get("icon") != null) {
							String iconUrl = whatPosted.get("icon").toString();
							iconUrl = iconUrl.replace("_th1.", ".");
							whatPosted.put("icon", iconUrl);
						}		
						data.put("whatPosted", whatPosted);
					}

					Map<String, Object> whoPosted = (Map<String, Object>) data.get("whoPosted");
					if (whoPosted != null) {
						String userIcon = whoPosted.get("icon").toString();
						userIcon = userIcon.replace("_gall_th.", ".");
						whoPosted.put("icon", userIcon);
						data.put("whoPosted", whoPosted);
					}

					info.setData(data);
					System.out.println("After manipulation");
					System.out.println(info.toString());

				}

				content = templateUtil.getTemplateAsString(templateFile, data);
				subject = info.getSubject();
				boolean containsIBP = Arrays.asList(info.getTo()).stream().anyMatch(id -> {
					return id.contains("ibp.org");
				});
				if (info.getSubscription() != null && info.getSubscription() && !containsIBP) {
					MailThread mail = new MailThread(info.getTo(), new String[] {},
							(subject == null || subject.isEmpty()) ? mailSubject : subject, content, true);
					Thread thread = new Thread(mail);
					thread.start();
				}
			}
		}

		// Admin Thread
		String bcc = PropertyFileUtil.fetchProperty("config.properties", "mail_bcc");
		MailThread aMail = new MailThread(bcc.split(","), new String[] {},
				(subject == null || subject.isEmpty()) ? mailSubject : subject, content, true);
		Thread aThread = new Thread(aMail);
		aThread.start();
	}

}
