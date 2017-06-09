package com.maxxis.ccprocessing.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.maxxis.ccprocessing.service.ApplicationService;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		 Resource resource = new ClassPathResource("servlet-context.xml");
		 
		 BeanFactory bean = new XmlBeanFactory(resource);
		 

	/*	ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");*/

		ApplicationService appService = (ApplicationService) bean.getBean("ApplicationService");

	appService.processApplication();
		

	}

}
