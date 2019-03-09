package com.opensource.technical.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author sumeet tiwari<OPEN SOURCE TECHNICAL BLOG>
 *
 */
@SpringBootApplication
@ComponentScan("com.opensource.technical.blog")
@EnableJpaRepositories(basePackages = "com.opensource.technical.blog")
public class SpringBootSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSpringDataJpaApplication.class, args);
	}

}

