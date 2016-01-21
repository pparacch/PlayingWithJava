package com.apress.isf.ch0201.java.model;

public class Type {
	private String name;
	private String desc;
	private String extension;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	@Override
    public String toString() {
        return "(" + getName() + "," + getDesc() + ",[" + getExtension() + "])";
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        
        if (obj instanceof Type && obj != null) {
            Type oType = (Type) obj;
            if (!this.getName().equals(oType.getName())) {
                result = false;
            } else if (!this.getDesc().equals(oType.getDesc())) {
                result = false;
            } else if (!this.getExtension().equals(oType.getExtension())) {
                result = false;
            } else {
                result = true;
            }
        }
        return result;
    }

}
