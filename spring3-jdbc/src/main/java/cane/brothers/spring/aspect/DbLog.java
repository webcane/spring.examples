package cane.brothers.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class DbLog {

	private static final Logger log = LoggerFactory.getLogger(DbLog.class);

	// drop
	@Pointcut("execution(void cane.brothers.spring.persistence.CustomerManager.dropTable())")
	public void dropTable() {
	}

	@Before("dropTable()")
	public void logBeforeDrop() {
		log.info("drop customers table");
	}

	// create
	@Pointcut("execution(void cane.brothers.spring.persistence.CustomerManager.createTable())")
	public void createTable() {
	}

	@Before("createTable()")
	public void logBeforeCreate() {
		log.info("create customers table");
	}

	// insert
	@Pointcut("execution(void cane.brothers.spring.persistence.CustomerManager.inserTableData(*))")
	public void insertCustomers() {
	}

	@Before("insertCustomers()")
	public void singBeforeQuest() {
		log.info("Inserting customer records ");
	}

}
