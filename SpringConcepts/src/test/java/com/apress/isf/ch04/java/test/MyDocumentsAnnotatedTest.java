package com.apress.isf.ch04.java.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.isf.ch0201.java.model.Document;
import com.apress.isf.ch0201.java.service.SearchEngine;


public class MyDocumentsAnnotatedTest {
	
	private ApplicationContext context;
	private com.apress.isf.ch0201.java.model.Type webType;
	
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("META-INF/spring/ch0401-mydocuments-annotations-context.xml");	
	}
	
	@Test
	public void testSearchEngineNotSIngleton() {	
		SearchEngine engine1 = context.getBean(SearchEngine.class);
		SearchEngine engine2 = context.getBean(SearchEngine.class);
		assertTrue(engine1 != engine2);//Not the same class
	}
	
	@Test
	public void testWithAnnotationsFindByType() {
		SearchEngine engine = context.getBean(SearchEngine.class);
		webType = context.getBean(com.apress.isf.ch0201.java.model.Type.class);
		
		List<Document> documents = engine.findByType(webType);
		assertNotNull(documents);
		assertTrue(documents.size() == 1);
		assertEquals(webType.getName(),documents.get(0).getType().getName());
		assertEquals(webType.getDesc(),documents.get(0).getType().getDesc());
		assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());
	}
	
	@Test
	public void testAll() {
		SearchEngine engine = context.getBean(SearchEngine.class);
		
		List<Document> documents = engine.listAll();
		assertEquals(4, documents.size());
	}
}
