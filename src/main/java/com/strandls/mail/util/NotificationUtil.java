package com.strandls.mail.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NotificationUtil {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private static final String NOTIFICATION_KEY;
	private static final String NOTIFICATION_ENDPOINT;

	static {
		Properties prop = PropertyFileUtil.fetchProperty("config.properties");
		NOTIFICATION_ENDPOINT = prop.getProperty("notification_url");
		NOTIFICATION_KEY = prop.getProperty("notification_key");
	}

	public NotificationUtil() {
		super();
	}

	public void sendNotification(String message) throws IOException {

		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		HttpPost postRequest = new HttpPost(NOTIFICATION_ENDPOINT);
		StringBuilder notificationKey = new StringBuilder("key=");
		notificationKey.append(NOTIFICATION_KEY);
		postRequest.addHeader("Authorization", notificationKey.toString());
		postRequest.addHeader("Content-Type", "application/json");

		postRequest.setEntity(new StringEntity(message));

		CloseableHttpResponse response = null;

		log.debug(message);

		try {
			response = httpClient.execute(postRequest);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				InputStream body = response.getEntity().getContent();
				ObjectMapper mapper = new ObjectMapper();

				Map<String, Object> json = null;
				json = mapper.readValue(body, new TypeReference<Map<String, Object>>() {
				});
				log.debug(json.toString());
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
		} finally {
			HttpClientUtils.closeQuietly(httpClient);
			HttpClientUtils.closeQuietly(response);
		}
	}
}