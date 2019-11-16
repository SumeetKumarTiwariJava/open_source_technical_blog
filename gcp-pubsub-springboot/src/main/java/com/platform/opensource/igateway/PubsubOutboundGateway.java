/**
 * 
 */
package com.platform.opensource.igateway;

import org.springframework.integration.annotation.MessagingGateway;

/**
 * @author sumeet tiwari<OPEN SOURCE TECHNICAL BLOG>
 *
 */
@MessagingGateway(defaultRequestChannel = "pubsubOutputChannel")
public interface PubsubOutboundGateway {
	void sendToPubsub(String text);
}
