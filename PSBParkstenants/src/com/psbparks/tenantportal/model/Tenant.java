package com.psbparks.tenantportal.model;





/**
 * @author Sandeep Thandra
 * This class is designed to hold entities related to
 * the Tenant and providing access through only getters by making them
 * private
 *
 *
 */
public class Tenant {

	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private Address address;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
}