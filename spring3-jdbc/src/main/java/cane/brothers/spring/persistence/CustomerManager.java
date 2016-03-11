package cane.brothers.spring.persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import cane.brothers.spring.domain.Customer;



@Component
public class CustomerManager {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void dropTable() {
		jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
	}

	public void createTable() {
		jdbcTemplate.execute("CREATE TABLE customers(" + "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
	}

	public void inserTableData(final List<Customer> customers) {
		
		// Uses JdbcTemplate's batchUpdate operation to bulk load data
		jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)",
				new BatchPreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						Customer customer = customers.get(i);
						ps.setString(1, customer.getFirstName());
						ps.setString(2, customer.getLastName());
						//log.info(String.format("Inserting customer record for %s %s", customer.getFirstName(),
						//		customer.getLastName()));
					}

					@Override
					public int getBatchSize() {
						return customers.size();
					}
				});
	}

}
