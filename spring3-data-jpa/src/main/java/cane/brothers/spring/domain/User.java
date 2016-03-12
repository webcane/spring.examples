package cane.brothers.spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	private String firstname;
	private String lastname;
	
	public User() {
	}
	
	
	public User(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}


	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		return String.format("User [id=%s, firstname=%s, lastname=%s]", id, firstname, lastname);
	}
}
