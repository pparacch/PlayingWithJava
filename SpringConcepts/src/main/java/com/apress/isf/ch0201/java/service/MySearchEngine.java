package com.apress.isf.ch0201.java.service;

import java.util.ArrayList;
import java.util.List;

import com.apress.isf.ch0201.java.model.Document;
import com.apress.isf.ch0201.java.model.Type;

public class MySearchEngine implements SearchEngine {

	public List<Document> findByType(Type documentType) {
		List<Document> result = new ArrayList<Document>();
		
		for(Document doc: storage()){
			if(doc.getType().getName().equals(documentType.getName())){
				result.add(doc);
			}
		}
		return result;
	}

	public List<Document> listAll() {
		return storage();
	}
	
	private List<Document> storage() {
		List<Document> result = new ArrayList<Document>();
		
		Type aType = new Type();
		aType.setName("PDF");
		aType.setDesc("Portable Document Format");
		aType.setExtension(".pdf");
		Document aDoc = new Document();
		aDoc.setName("Book Template");
		aDoc.setType(aType);
		aDoc.setLocation("/Documents/BookTemplate.pdf");
		result.add(aDoc);
		
		
		aType = new Type();
		aType.setName("WEB");
		aType.setDesc("Web Link");
		aType.setExtension(".url");
		aDoc = new Document();
		aDoc.setName("Spring Framework url");
		aDoc.setType(aType);
		aDoc.setLocation("https://spring.io/");
		result.add(aDoc);
		
		aType = new Type();
		aType.setName("NOTE");
		aType.setDesc("Text Notes");
		aType.setExtension(".txt");
         
        aDoc = new Document();
        aDoc.setName("Clustering with RabbitMQ");
        aDoc.setType(aType);
        aDoc.setLocation("/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt");
        result.add(aDoc);
		
		return result;
	}


}
