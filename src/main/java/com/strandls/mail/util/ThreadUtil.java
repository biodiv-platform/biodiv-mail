package com.strandls.mail.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.strandls.mail.model.MailInfo;
import com.strandls.mail.thread.MailThread;

import freemarker.template.Configuration;

public class ThreadUtil {

	public static void startThread(Configuration configuration, String templateFile, String mailSubject,
			List<MailInfo> recipients) {
		TemplateUtil template = new TemplateUtil(configuration);
		String subject = "";
		String content = "";
		if (recipients != null) {
			for (MailInfo info : recipients) {

				Map<String, Object> data = info.getData();
				System.out.println(info.toString());

				data.put("siteName", PropertyFileUtil.fetchProperty("config.properties", "siteName"));
				data.put("serverUrl", PropertyFileUtil.fetchProperty("config.properties", "serverUrl"));
				String iconUrl = data.get("whatPosted.icon").toString();
				iconUrl = iconUrl.replace("_th1.", ".");
				data.put("whatPosted.icon", iconUrl);
				String userIcon = data.get("whoPosted.icon").toString();
				userIcon = userIcon.replace("_gall_th.", ".");
				data.put("whoPosted.icon", userIcon);

				info.setData(data);
				System.out.println(info.toString());

				content = template.getTemplateAsString(templateFile, data);
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
