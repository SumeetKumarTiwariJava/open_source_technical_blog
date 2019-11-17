package com.platform.opensource.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gcp.pubsub.support.BasicAcknowledgeablePubsubMessage;
import org.springframework.cloud.gcp.pubsub.support.GcpPubSubHeaders;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sumeet tiwari<OPEN SOURCE TECHNICAL BLOG>
 *
 */
@Controller
public class ReceiverController {
	
	private static final Log LOGGER = LogFactory.getLog(ReceiverController.class);
	
	private String payLoad;
	
	public String getPayLoad() {
		return payLoad;
	}

	public void setPayLoad(String payLoad) {
		this.payLoad = payLoad;
	}

	@ServiceActivator(inputChannel = "pubsubInputChannel")
	public void messageReceiver(String payload,
			@Header(GcpPubSubHeaders.ORIGINAL_MESSAGE) BasicAcknowledgeablePubsubMessage message) {
		LOGGER.info("Message arrived! Payload: " + payload);
		setPayLoad(payload);
		message.ack();
	}
	
	@GetMapping("/showmsg")
	public String showMessage(Model model) {
		model.addAttribute("message",this.getPayLoad());
		return "thanks";
	}
}
