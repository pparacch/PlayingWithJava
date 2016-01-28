package com.apress.isf.ch05.java.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.isf.ch0201.java.model.Document;
import com.apress.isf.ch0201.java.model.Type;
import com.apress.isf.ch0201.java.service.SearchEngine;
import com.apress.isf.ch0501.spring.data.TypeDataRepository;

public class MyDocumentsTest {

	private ClassPathXmlApplicationContext context;
	private SearchEngine engine;
	private Type webType;
	
	@Before
	public void setup(){
		new TypeDataRepository();
		context = new ClassPathXmlApplicationContext("META-INF/spring/ch0501_mydocuments-context.xml");
	}
	
	@Test
	public void testAll() {	
		engine = context.getBean(SearchEngine.class);
		webType = context.getBean("webType",Type.class);
		
		List<Document> documents = engine.findByType(webType);
		assertNotNull(documents);
		assertTrue(documents.size() == 2);
		assertEquals(webType.getName(),documents.get(0).getType().getName());
		assertEquals(webType.getDesc(),documents.get(0).getType().getDesc());
		assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());
		
		assertEquals(webType.getName(),documents.get(1).getType().getName());
		assertEquals(webType.getDesc(),documents.get(1).getType().getDesc());
		assertEquals(webType.getExtension(),documents.get(1).getType().getExtension());
		
		engine = context.getBean(SearchEngine.class);
		
		documents = engine.listAll();
		assertNotNull(documents);
		assertTrue(documents.size() == 5);
	}
}
