package cane.brothers.spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "Users") //--> not working with @Query
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String firstname;
	private String lastname;

	private boolean active;

	public User() {
	}

	public User(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public User(String firstname, String lastname, boolean active) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.active = active;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public boolean isActive() {
		return active;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, firstname=%s, lastname=%s, active=%b]", 
				id, firstname, lastname, active);
	}
}
