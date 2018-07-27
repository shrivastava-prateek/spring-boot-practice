package com.bean;

public class Person {

	private String name;
	private String mobileNumber;
	private String profession;
    private Address address;


	
	public Person(String name, String mobileNumber, String profession, Address address) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.profession = profession;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}

	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", mobileNumber=" + mobileNumber + ", profession=" + profession + ", address="
				+ address + "]";
	}

	
	
	
	
	
	
}
