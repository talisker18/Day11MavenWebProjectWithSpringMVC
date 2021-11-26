package com.Day11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Day11.models.User;

@Controller
public class UserController {
	
	@RequestMapping("/user-add") //this is the endpoint in the URL
	public String displayUserForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "userForm"; //this is the name of the jsp file
	}

	@RequestMapping("/print")
	public String display() {
		return "print"; //if we do not return ModelAndView, we have to return exactly the same
		//name of the jsp, in this case print.jsp
	}
	
	@RequestMapping(value="/user-details", method=RequestMethod.POST)
	public String displayUserDetails(@ModelAttribute User userDetail, Model model) {
		System.out.println("backend msg: form was submitted");
		model.addAttribute("userDetail", userDetail); //we can access the created user object in jsp by ${userDetail}
		return "userDetails";
	}
}
