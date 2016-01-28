package com.apress.isf.ch0501.spring.data;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.apress.isf.ch0201.java.model.Document;
import com.apress.isf.ch0301.spring.data.DocumentDAO;

public class DocumentRepository implements DocumentDAO {
	private static Logger logger = Logger.getLogger("com.apress.isf.ch0501.spring.data");
	private List<Document> documents = null;
	
	
	
	public List<Document> getDocuments() {
		return documents;
	}



	public void setDocuments(List<Document> documents) {
		logger.log(Level.INFO, "Start <setDocuments> Params: " + documents);
		this.documents = documents;
		logger.log(Level.INFO, "End <setDocuments> Results");
	}



	public Document[] getAll() {
		logger.log(Level.INFO, "Start <getAll> Params");
		Document[] result = documents.toArray(new Document[documents.size()]);
		logger.log(Level.INFO, "End <getAll> Result: " + result);
		return result;
	}
	
	

}
