package com.apress.isf.ch03.java.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.isf.ch0201.java.model.Document;
import com.apress.isf.ch0201.java.model.Type;
import com.apress.isf.ch0201.java.service.SearchEngine;


public class MyDocumentsTest {

	private ClassPathXmlApplicationContext context;
	private com.apress.isf.ch0201.java.service.SearchEngine engine;
	private Type webType;

	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("META-INF/spring/ch0301-mydocuments-context.xml");
		engine = context.getBean(SearchEngine.class);
		webType = context.getBean("webType",Type.class);
	}
	
	@Test
	public void testWithSpringFindByType() {	
		List<Document> documents = engine.findByType(webType);
		assertNotNull(documents);
		assertTrue(documents.size() == 1);
		assertEquals(webType.getName(),documents.get(0).getType().getName());
		assertEquals(webType.getDesc(),documents.get(0).getType().getDesc());
		assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());
	}

	@Test
	public void testWithSpringListAll() {		
		List<Document> documents = engine.listAll();
		assertNotNull(documents);
		assertTrue(documents.size() == 4);
	}

}
