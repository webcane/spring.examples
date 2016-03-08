package cane.brothers.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Объявить компонент как контроллер
@Controller 
public class HomeController {

	//@RequestMapping({ "/", "/home" })
	// Обрабатывать запросы с указанными путями для показа главной страницы
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomePage(ModelMap model) {
		
		// Добавить сообщения в модель
		model.addAttribute("message", "Spring 3 MVC Hello World");
		
		// Вернуть имя представления
		return "home";
	}
}
