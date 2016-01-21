package com.apress.isf.ch0201.java.service;

import java.util.List;

import com.apress.isf.ch0201.java.model.*;

public interface SearchEngine {
	List<Document> findByType(Type documentType);
	List<Document> listAll();
}
