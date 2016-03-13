package cane.brothers.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

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
		Iterable<User> users = userRepo.findByFirstnameOrderByLastnameAsc(username);
		for (User u : users) {
			user = (uniqueUser ? u : null);
			uniqueUser = false;
		}
		return user;
	}

	public Iterable<User> findUsersByName(String username, boolean isOrderByLastName) {
		return (isOrderByLastName ? userRepo.findByFirstnameOrderByLastnameAsc(username)
				: userRepo.findByFirstname(username));
	}

	public Iterable<User> findAllActiveUsers(boolean isOrderByLastName) {
		return (isOrderByLastName ? userRepo.findAllActiveUsers(true) : userRepo.findByActive(true));
	}

	public Page<User> findFirst3Users() {
		// sort by last name then return first 3 users
		final PageRequest page3 = new PageRequest(0, 3, 
				new Sort(new Order(Direction.ASC, "lastname")));
		Page<User> users = userRepo.findAll(page3);
		return users;
	}
}
