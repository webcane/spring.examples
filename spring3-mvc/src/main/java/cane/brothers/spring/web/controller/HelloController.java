package cane.brothers.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView hello() {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", "my message");
		model.addObject("title", "hello page");

		return model;
	}

}