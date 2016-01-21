package com.apress.isf.ch0201.java.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.apress.isf.ch0201.java.model.Document;
import com.apress.isf.ch0201.java.model.Type;
import com.apress.isf.ch0201.java.service.MySearchEngine;
import com.apress.isf.ch0201.java.service.SearchEngine;

public class MyDocumentsTest {
	
	private SearchEngine engine = new MySearchEngine();

	@Test
	public void testFindByType() {
		Type documentType = new Type();
		documentType.setName("WEB");
		documentType.setDesc("Web Link");
		documentType.setExtension(".url");
		
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
