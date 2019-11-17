package com.platform.opensource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.MessageHandler;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author sumeet tiwari<OPEN SOURCE TECHNICAL BLOG>
 *
 */
@SpringBootApplication
public class GcpPubsubSpringbootSenderApplication {

	private static final Log LOGGER = LogFactory.getLog(GcpPubsubSpringbootSenderApplication.class);
	
	@Value("${pub.sub.topic.name}")
	private String topic;

	public static void main(String[] args) {
		SpringApplication.run(GcpPubsubSpringbootSenderApplication.class, args);
	}

	@Bean
	@ServiceActivator(inputChannel = "pubSubOutputChannel")
	public MessageHandler messageSender(PubSubTemplate pubsubTemplate) {
		PubSubMessageHandler adapter = new PubSubMessageHandler(pubsubTemplate,topic);
		adapter.setPublishCallback(new ListenableFutureCallback<String>() {
			@Override
			public void onFailure(Throwable ex) {
				LOGGER.info("There was an error sending the message.");
			}

			@Override
			public void onSuccess(String result) {
				LOGGER.info("Message was sent successfully. ::"+result);
			}
		});

		return adapter;
	}
}
