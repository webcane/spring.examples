package cane.brothers.spring.service;

import cane.brothers.spring.domain.User;

public interface UserService {

	User addUser(User user);

	Iterable<User> getAllUsers();

	User getUserByName(String username);
}
