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

			userService.addUser(new User("John", "Woo", true));
			userService.addUser(new User("Jeff", "Dean"));
			userService.addUser(new User("Josh", "Bloch", true));
			userService.addUser(new User("John", "Bull"));

			log.info("active users");
			for (User u : userService.findAllActiveUsers(false)) {
				log.info(u.toString());
			}
			
			log.info("\nactive users with ordering");
			for (User u : userService.findAllActiveUsers(true)) {
				log.info(u.toString());
			}
			
			
			log.info("\nfind Johns with ordering");
			for (User u : userService.findUsersByName("John", true)) {
				log.info(u.toString());
			}
			
			log.info("\nfind Johns");
			for (User u : userService.findUsersByName("John", false)) {
				log.info(u.toString());
			}

			log.info("\nfind single John");
			User john = userService.getUserByName("John");
			if (john != null) {
				log.info(john.toString());
			} else {
				log.warn("No user or many users");
			}

		}
	}
}
