package com.opensource.technical.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author sumeet tiwari<OPEN SOURCE TECHNICAL BLOG>
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class SpringBootSpringCloudNetflixZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSpringCloudNetflixZuulApplication.class, args);
	}

}
