package com.opensource.technical.blog.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sumeet tiwari<OPEN SOURCE TECHNICAL BLOG>
 *
 */
@RestController
public class UserController {

	@RequestMapping(value = "/user")
	public Principal user(Principal principal) {
		return principal;
	}
}
