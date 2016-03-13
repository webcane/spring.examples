package cane.brothers.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cane.brothers.spring.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Iterable<User> findByFirstname(String firstName);
	
	Iterable<User> findByFirstnameOrderByLastnameAsc(String firstName);
	
	Iterable<User> findByActive(boolean active);
	
	@Query("FROM Users where active = ?1 ORDER BY lastname ASC")
	Iterable<User> findAllActiveUsers(boolean active);
	
}
