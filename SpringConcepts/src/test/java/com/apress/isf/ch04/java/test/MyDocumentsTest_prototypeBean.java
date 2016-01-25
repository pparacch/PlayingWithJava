package com.apress.isf.ch04.java.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.isf.ch0201.java.model.Document;
import com.apress.isf.ch0201.java.model.Type;
import com.apress.isf.ch0201.java.service.SearchEngine;


public class MyDocumentsTest_prototypeBean {

	private ClassPathXmlApplicationContext context;
	private com.apress.isf.ch0201.java.service.SearchEngine engine;
	private Type webType;

	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("META-INF/spring/ch0401-mydocuments-context.xml");
	}
	
	@Test
	public void testAll() {
		//By default beans are created in a singleton mode (spring framework)
		//By default the Spring Framework only creates a Singleton instance of your bean, so even if you call this bean 
		//(with the getBean method) several times, you are going to get the same instance.
		engine = context.getBean(SearchEngine.class);
		webType = context.getBean("webType", Type.class);
		List<Document> documents = engine.findByType(webType);
		
		assertTrue(documents.size() == 1);
		assertEquals(webType.getName(),documents.get(0).getType().getName());
		assertEquals(webType.getDesc(),documents.get(0).getType().getDesc());
		assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());
		
		SearchEngine newEngine = context.getBean(SearchEngine.class);
		//The assertionis going to fail cause the engine bean is not a singleton anymore.
		//assertTrue(engine == newEngine); //Same instance of the SearchEngine bean
		
		documents = engine.listAll();
		assertTrue(documents.size() == 4);
	}


}
