package cn.com.gzx.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHelper implements ApplicationContextAware {

	public static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ApplicationContextHelper.applicationContext = applicationContext;
	}

	public static Object getBean(String beanName) {
		return applicationContext != null ? applicationContext
				.getBean(beanName) : null;
	}

}