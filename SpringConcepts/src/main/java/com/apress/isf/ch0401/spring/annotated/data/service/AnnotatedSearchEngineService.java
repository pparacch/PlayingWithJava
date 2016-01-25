package com.apress.isf.ch0401.spring.annotated.data.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.apress.isf.ch0201.java.model.Document;
import com.apress.isf.ch0201.java.model.Type;
import com.apress.isf.ch0201.java.service.SearchEngine;
import com.apress.isf.ch0301.spring.data.DocumentDAO;

@Service("engine") //marker - specialization of @Component, id: engine
@Scope("prototype")//multiple instance setting
public class AnnotatedSearchEngineService implements SearchEngine {
	private static Logger logger = Logger.getLogger("com.apress.isf.ch0401.spring.annotated.data.service");
	
	public AnnotatedSearchEngineService() {
		logger.log(Level.INFO, "AnnotatedSearchEngineService created: " + this);
	}
	
	@Autowired //tell the Spring container to actually create the instance and assign it to the declared variable
	private DocumentDAO documentDAO;
	
	public DocumentDAO getDocumentDAO() {
		return documentDAO;
	}

	public void setDocumentDAO(DocumentDAO documentDAO) {
		logger.log(Level.INFO, "DocumentDAO: " + documentDAO);
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
