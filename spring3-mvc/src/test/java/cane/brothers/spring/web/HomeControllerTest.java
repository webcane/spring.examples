package cane.brothers.spring.web;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.ui.ModelMap;

public class HomeControllerTest {


	@Test
	public void shouldDisplayMessageOnHomePage() {
		// Создаем контроллер и модель
		HomeController controller = new HomeController();
		ModelMap model  = new ModelMap();
		
		// получаем id view
		String viewName = controller.showHomePage(model);
		assertEquals("home", viewName);
		
		// ?
		// Проверяем сообщение в модели
		//assertSame(, model.get("spittles"));
		assertEquals("Spring 3 MVC Hello World", model.get("message"));
	}
}
