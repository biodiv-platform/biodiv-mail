package com.strandls.mail.util;

import java.io.StringWriter;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TemplateUtil {

	private final Logger logger = LoggerFactory.getLogger(TemplateUtil.class);
	@Inject
	private Configuration configuration;

	public String getTemplateAsString(String templateFile, Map<String, Object> model) {

		Template template = null;
		StringWriter writer = new StringWriter();
		try {
			template = configuration.getTemplate(templateFile);
			template.process(model, writer);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return writer.toString();
	}

}
