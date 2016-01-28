package com.apress.isf.ch0501.spring.data;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.apress.isf.ch0201.java.model.Type;

public class TypeDataRepository implements TypeDataDAO {
	private static final Logger logger = Logger.getLogger("com.apress.ifs.ch0501.spring.data");
	private Map<String, Type> types = null;
 
	public TypeDataRepository(){
		logger.log(Level.INFO, "Start <TypeDataRepository>");
	}
	
	public Map<String, Type> getTypes() {
		return types;
	}

	public void setTypes(Map<String, Type> types) {
		logger.log(Level.INFO, "Start <setTypes> Params: "+ types);
		this.types = types;
		logger.log(Level.INFO, "End <setTypes> Result:");
	}

	public Type[] getAll() {
		logger.log(Level.INFO, "Start <findBy> Params: ");
		Type[] result = types.values().toArray(new Type[types.values().size()]);
		logger.log(Level.INFO, "Start <findBy> Result: " + result);
		return null;
	}

	public Type findById(String id) {
		logger.log(Level.INFO, "Start <findBy> Params: " + id);
		Type result = types.get(id);
		logger.log(Level.INFO, "End <findBy> Result: " + result);
		return result;
	}

}
