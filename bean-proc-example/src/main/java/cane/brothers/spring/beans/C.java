package cane.brothers.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class C {
	private SystemType type;

	public SystemType getType() {
		return type;
	}

	public void setType(SystemType type) {
		this.type = type;
	}
}
