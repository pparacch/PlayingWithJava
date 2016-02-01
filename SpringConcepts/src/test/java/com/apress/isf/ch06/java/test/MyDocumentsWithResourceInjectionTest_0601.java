package com.apress.isf.ch06.java.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.isf.ch0601.spring.views.Menu;

public class MyDocumentsWithResourceInjectionTest_0601 {
	
	private ClassPathXmlApplicationContext context;
	
	@Before
	public void setUp(){
		context = new ClassPathXmlApplicationContext("META-INF/spring/ch0601-mydocuments-resource-injection-context.xml");
	}
	
	@Test
	public void testMenu(){
		Menu menu = context.getBean(Menu.class);
		Assert.assertNotNull(menu);
		menu.printMenu();
	}
}
