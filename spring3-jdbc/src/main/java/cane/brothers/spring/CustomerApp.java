package cane.brothers.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cane.brothers.spring.domain.Customer;
import cane.brothers.spring.persistence.CustomerManager;

public class CustomerApp {
	
	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = 
				new AnnotationConfigApplicationContext(CustomerConfiguration.class)) {

			CustomerManager customerDAO = (CustomerManager) context.getBean("customerManager");
			
	        List<Customer>customers = new ArrayList<Customer>();
	        customers.add(new Customer("John", "Woo"));
	        customers.add(new Customer("Jeff", "Dean"));
	        customers.add(new Customer("Josh", "Bloch"));
	        
	        customerDAO.dropTable();
	        customerDAO.createTable();
	        customerDAO.inserTableData(customers);

		} 
	}
}
