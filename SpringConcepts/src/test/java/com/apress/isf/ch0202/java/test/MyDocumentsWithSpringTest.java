package com.apress.isf.ch0202.java.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apress.isf.ch0201.java.model.Document;
import com.apress.isf.ch0201.java.model.Type;
import com.apress.isf.ch0201.java.service.MySearchEngine;
import com.apress.isf.ch0201.java.service.SearchEngine;

public class MyDocumentsWithSpringTest {
	
	private ClassPathXmlApplicationContext context;
	private SearchEngine engine = null;
	private Type documentType = null;

	@Before
	public void setup(){
		//A first approach to dependency injection
		context = new ClassPathXmlApplicationContext("META-INF/Spring/ch0202-mydocuments-context.xml");
		engine = context.getBean(SearchEngine.class);
		documentType = context.getBean(Type.class);
	}
	
	@Test
	public void testFindByType() {
		
		List<Document> documents = engine.findByType(documentType);

		assertNotNull(documents);
		assertTrue(documents.size() == 1);
		assertEquals(documentType, documents.get(0).getType());
	}
	
	@Test
	public void testListAll() {		
		List<Document> documents = engine.listAll();
		assertNotNull(documents);
		assertEquals(2, documents.size());
	}
	

}
