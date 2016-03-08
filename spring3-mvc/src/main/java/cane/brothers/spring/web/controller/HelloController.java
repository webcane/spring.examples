package cane.brothers.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cane.brothers.spring.web.service.MessageService;

@Controller
public class HelloController {
	
	@Autowired
    private MessageService service;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView hello() {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", service.getMessage());
		model.addObject("title", "hello page");

		return model;
	}

}
