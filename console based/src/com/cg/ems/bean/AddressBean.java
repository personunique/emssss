package com.cg.ems.bean;

public class AddressBean {

	private int addressId;
	private int doorNo;
	private String street;
	private String landmark;
	private String area;
	private int pincode;
	private String district;
	private String state;
	
	public AddressBean() {
		
	}

	public AddressBean(int addressId, int doorNo, String street,
			String landmark, String area, int pincode, String district,
			String state) {
		super();
		this.addressId = addressId;
		this.doorNo = doorNo;
		this.street = street;
		this.landmark = landmark;
		this.area = area;
		this.pincode = pincode;
		this.district = district;
		this.state = state;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
}
