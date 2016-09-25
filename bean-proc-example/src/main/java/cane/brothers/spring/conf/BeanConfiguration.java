package cane.brothers.spring.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cane.brothers.spring.beans.A;
import cane.brothers.spring.beans.B;
import cane.brothers.spring.beans.C;
import cane.brothers.spring.beans.SystemType;

@Configuration
public class BeanConfiguration {
	private static final Logger log = LoggerFactory.getLogger(BeanConfiguration.class);
	
	@Bean
    public A nameHolder() {
		A b = new A();
		b.setName("beanA");
		log.debug("create A " + b);
		return b;
    }
	
	@Bean
    public B idHolder() {
		B b = new B();
		b.setId(100500L);
		log.debug("create B " + b);
		return b;
    }
	
	@Bean
    public C typeHolder() {
		C b = new C();
		b.setType(SystemType.SIMPLE);
		log.debug("create C " + b);
		return b;
    }
	
	@Bean
	public BeanFactoryPostProcessor beanProcessor() {
		return new SimpleBeanProcessor();
	}
}
