package com.platform.opensource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.platform.opensource.GcpPubsubSpringbootApplication.PubsubOutboundGateway;

@RestController
public class PubSubController {

	// tag::autowireGateway[]
	@Autowired
	private PubsubOutboundGateway messagingGateway;
	// end::autowireGateway[]

	@PostMapping("/publishMessage")
	public RedirectView publishMessage(@RequestParam("message") String message) {
		messagingGateway.sendToPubsub(message);
		return new RedirectView("/thanks");
	}
}
