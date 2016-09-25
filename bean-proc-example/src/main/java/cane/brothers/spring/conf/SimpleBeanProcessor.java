package cane.brothers.spring.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleBeanProcessor implements BeanFactoryPostProcessor {

	private static final Logger log = LoggerFactory.getLogger(SimpleBeanProcessor.class);

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] names = beanFactory.getBeanDefinitionNames();
		for (String name : names) {
			BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
			String className = beanDefinition.getBeanClassName();
			if (className != null && className.startsWith("cane.brothers.spring.beans")) {
				
				if(name != null && !name.equals("b")) {
					beanDefinition.setDependsOn("b");
				}
				
				log.debug("bean \"{}\" for class {}", name, className);
				log.debug(" depends on {}", beanDefinition.getDependsOn());
			}
		}
	}
}
