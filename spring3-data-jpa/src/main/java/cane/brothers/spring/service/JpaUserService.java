package cane.brothers.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import cane.brothers.spring.domain.User;
import cane.brothers.spring.repository.UserRepository;

public class JpaUserService implements UserService {

	@Autowired
	UserRepository userRepo;

	public User addUser(User user) {
		return userRepo.save(user);
	}

	public Iterable<User> getAllUsers() {
		return userRepo.findAll();
	}

	public User getUserByName(String username) {
		User user = null;
		boolean uniqueUser = true;
		Iterable<User> users = userRepo.findByFirstname(username);
		for(User u: users) {
			user = (uniqueUser ? u : null);
			uniqueUser = false;
		}
		return user;
	}
}
