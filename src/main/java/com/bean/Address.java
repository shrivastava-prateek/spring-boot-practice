package com.bean;

public class Address {

	String city;
	String postalCode;
	String country;
	
	
	public Address() {
		super();

	}

	public Address(String city, String postalCode, String country) {
		super();
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", postalCode=" + postalCode + ", country=" + country + "]";
	}
	
	
	
}
