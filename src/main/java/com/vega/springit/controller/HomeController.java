package com.vega.springit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping(path = "/",method = RequestMethod.GET)
	private String home() {
		return "This is spring boot 2.0 course.";
	}

}
