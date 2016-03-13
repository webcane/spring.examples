package cane.brothers.spring.repository;

import org.springframework.data.repository.CrudRepository;

import cane.brothers.spring.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Iterable<User> findByFirstname(String firstName);
	
	Iterable<User> findByFirstnameOrderByLastnameAsc(String firstName);
	
}
