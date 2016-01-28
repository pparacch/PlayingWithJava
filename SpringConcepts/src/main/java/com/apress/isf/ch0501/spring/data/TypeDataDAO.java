package com.apress.isf.ch0501.spring.data;

import com.apress.isf.ch0201.java.model.Type;

public interface TypeDataDAO {
	public Type[] getAll();
	public Type findById(String id);
}
