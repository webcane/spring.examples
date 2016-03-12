package cane.brothers.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cane.brothers.spring.domain.User;
import cane.brothers.spring.service.UserService;

public class UserApp {

	private static final Logger log = LoggerFactory.getLogger(UserApp.class);

	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class)) {

			UserService userService = context.getBean(UserService.class);

			userService.addUser(new User("John", "Woo"));
			userService.addUser(new User("Jeff", "Dean"));
			userService.addUser(new User("Josh", "Bloch"));
			userService.addUser(new User("John", "Bull"));

			for (User u : userService.getAllUsers()) {
				log.info(u.toString());
			}

			User john = userService.getUserByName("John");
			if (john != null) {
				log.info(john.toString());
			} else {
				log.warn("No user or many users");
			}

		}
	}
}
