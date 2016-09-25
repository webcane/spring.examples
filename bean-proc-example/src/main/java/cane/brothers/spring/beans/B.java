package cane.brothers.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class B {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
