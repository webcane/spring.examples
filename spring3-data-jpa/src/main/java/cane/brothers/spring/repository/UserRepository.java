package cane.brothers.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cane.brothers.spring.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Iterable<User> findByFirstname(String firstName);
	
	Iterable<User> findByFirstnameOrderByLastnameAsc(String firstName);
	
	Iterable<User> findByActive(boolean active);
	
	@Query("FROM User where active = ?1 ORDER BY lastname ASC")
	Iterable<User> findAllActiveUsers(boolean active);
	
}
