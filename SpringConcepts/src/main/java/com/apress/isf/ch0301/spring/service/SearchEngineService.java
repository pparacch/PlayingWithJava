package com.apress.isf.ch0301.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import java.util.logging.Level;
import java.util.logging.Logger;

import com.apress.isf.ch0201.java.model.Document;
import com.apress.isf.ch0201.java.model.Type;
import com.apress.isf.ch0201.java.service.SearchEngine;
import com.apress.isf.ch0301.spring.data.DocumentDAO;

public class SearchEngineService implements SearchEngine {
	private static Logger logger = Logger.getLogger("com.apress.isf.ch0301.spring.service");
	
	private DocumentDAO documentDAO;
	
	public SearchEngineService(){
		logger.log(Level.INFO, "SearchEngineService created: " + this);
	}
	
	public DocumentDAO getDocumentDAO() {
		return documentDAO;
	}

	public void setDocumentDAO(DocumentDAO documentDAO) {
		logger.log(Level.INFO, "Document DAO set: " + documentDAO);
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
