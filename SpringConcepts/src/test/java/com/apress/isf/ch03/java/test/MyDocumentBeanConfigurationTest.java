package com.apress.isf.ch03.java.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.apress.isf.ch0201.java.model.Document;
import com.apress.isf.ch0201.java.model.Type;
import com.apress.isf.ch0201.java.service.SearchEngine;
import com.apress.isf.ch0301.spring.config.MyDocumentsContext;

public class MyDocumentBeanConfigurationTest {
	
	private ApplicationContext context;
	private SearchEngine engine;
	private Type webType;
	
	@Before
	public void setUp(){
		context = new AnnotationConfigApplicationContext(MyDocumentsContext.class);
		engine = context.getBean(SearchEngine.class);
		webType = context.getBean(Type.class);
	}
	
	@Test
	public void findByType(){
		List<Document> documents = engine.findByType(webType);
		
		Assert.assertNotNull(documents);
		Assert.assertTrue(documents.size() == 1);
		Assert.assertEquals(webType, documents.get(0).getType());
	}
	
	@Test
	public void listAll(){
		List<Document> documents = engine.listAll();
		Assert.assertNotNull(documents);
		Assert.assertTrue(documents.size() == 4);
	}

}
