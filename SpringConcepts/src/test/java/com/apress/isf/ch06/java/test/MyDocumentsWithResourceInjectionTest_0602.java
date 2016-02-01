package com.apress.isf.ch06.java.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.isf.ch0601.spring.views.Menu;
import com.apress.isf.ch0601.spring.views.ResourceLoaderMenu;

public class MyDocumentsWithResourceInjectionTest_0602 {
	
	private ClassPathXmlApplicationContext context;
	
	@Before
	public void setUp(){
		context = new ClassPathXmlApplicationContext("META-INF/spring/ch0602-mydocuments-resource-injection-context.xml");
	}
	
	@Test
	public void testMenu(){
		ResourceLoaderMenu menu = context.getBean(ResourceLoaderMenu.class);
		Assert.assertNotNull(menu);
		menu.printMenu("classpath:META-INF/data/menu.txt");
	}
}
