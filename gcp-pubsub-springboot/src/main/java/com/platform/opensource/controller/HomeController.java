package com.platform.opensource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sumeet tiwari<OPEN SOURCE TECHNICAL BLOG>
 *
 */
@Controller
public class HomeController {
	@RequestMapping("/home")
		public String home() {
			return "form";
		}
	
	@RequestMapping("/thanks")
	public String thanks() {
		return "thanks";
	}
}
