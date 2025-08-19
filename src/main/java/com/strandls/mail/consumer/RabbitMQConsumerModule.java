package com.strandls.mail.consumer;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class RabbitMQConsumerModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(RabbitMQConsumer.class).in(Scopes.SINGLETON);
	}

}
