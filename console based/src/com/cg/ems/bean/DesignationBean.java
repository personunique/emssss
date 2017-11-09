package com.cg.ems.bean;

public class DesignationBean {

	
	private int desigId;
	private String desigName;
	
	public DesignationBean() {
		
	}
	
	public DesignationBean(int desigId, String desigName) {
		super();
		this.desigId = desigId;
		this.desigName = desigName;
	}

	public int getDesigId() {
		return desigId;
	}
	public void setDesigId(int desigId) {
		this.desigId = desigId;
	}
	public String getDesigName() {
		return desigName;
	}
	public void setDesigName(String desigName) {
		this.desigName = desigName;
	}

	@Override
	public String toString() {
		return "DesignationBean [desigId=" + desigId + ", desigName="
				+ desigName + "]";
	}
	
	
	
}
