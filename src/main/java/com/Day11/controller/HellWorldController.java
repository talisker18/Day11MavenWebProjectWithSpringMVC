package com.Day11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HellWorldController {
	
	@RequestMapping("/helloworld")
	public String hello() {
		return "welcome";
	}
	
	@RequestMapping("/message")
	public String getMessage() {
		return "message";
	}
	
	@RequestMapping("/welcome")
	public ModelAndView getWelcomeMessage() {
		String myMessage = "welcome folks...lets learn spring"; //see in welcome-message.jsp: this
		//message will be printed with the help of ${message}...at the top of the jsp we have to add
		//isELIgnored="false" so that jsp references to vars do work
		
		return new ModelAndView("welcome-message", "message", myMessage); //here, welcome-message is the jsp file
		//, message is the model name -> we need this to map the String myMessage to the jsp var message, see jsp file ${message}
		//and myMessage we will print as var in the welcome-message.jsp
	}

}
