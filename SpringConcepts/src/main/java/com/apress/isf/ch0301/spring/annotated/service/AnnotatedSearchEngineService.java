package com.apress.isf.ch0301.spring.annotated.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apress.isf.ch0201.java.model.Document;
import com.apress.isf.ch0201.java.model.Type;
import com.apress.isf.ch0201.java.service.SearchEngine;
import com.apress.isf.ch0301.spring.data.DocumentDAO;

@Service("engine") //marker - specialization of @Component, id: engine
public class AnnotatedSearchEngineService implements SearchEngine {
	
	@Autowired //tell the Spring container to actually create the instance and assign it to the declared variable
	private DocumentDAO documentDAO;
	
	public DocumentDAO getDocumentDAO() {
		return documentDAO;
	}

	public void setDocumentDAO(DocumentDAO documentDAO) {
		this.documentDAO = documentDAO;
	}

	public List<Document> findByType(Type documentType) {
		List<Document> result = new ArrayList<Document>();
		for(Document doc: listAll()){
			if(doc.getType().equals(documentType)){
				result.add(doc);
			}
		}
		return result;
	}

	public List<Document> listAll() {
		return Arrays.asList(documentDAO.getAll());
	}

}
