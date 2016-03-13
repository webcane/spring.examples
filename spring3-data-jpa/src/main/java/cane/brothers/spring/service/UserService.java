package cane.brothers.spring.service;

import org.springframework.data.domain.Page;

import cane.brothers.spring.domain.User;

public interface UserService {

	User addUser(User user);

	Iterable<User> getAllUsers();

	User getUserByName(String username);
	
	Iterable<User> findUsersByName(String username, boolean isOrderByLastName);
	
	Iterable<User> findAllActiveUsers(boolean isOrderByLastName);
	
	Page<User> findFirst3Users();
}
