package cane.brothers.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class A {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
