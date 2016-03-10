package cane.brothers.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cane.brothers.domain.Todo;
import cane.brothers.persistence.TodoDao;
import cane.brothers.spring.config.TodoConfiguration;


public class TodoMain {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = 
				new AnnotationConfigApplicationContext(TodoConfiguration.class)) {

			TodoDao dao = (TodoDao) context.getBean("todoDao");
			
			Todo t = new Todo();
			t.setSummary("s");
			t.setDescription("d");
			dao.addTodo(t);
		} 
		
//		catch (QuestException e) {
//			System.err.println(e);
//		}
	}

}
