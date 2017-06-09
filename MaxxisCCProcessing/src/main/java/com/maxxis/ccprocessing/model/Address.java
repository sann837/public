package com.maxxis.ccprocessing.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Address {

	
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
@Column(name="AddID", nullable=false, unique=true, length=4)
private int id;	
private String addressLine1;
private String addressLine2;
private String city;
private String state;
private String zip;




public Address(){
	
}

public Address(int id, String addressLine1, String addressLine2, String city, String state, String zip) {
	super();
	this.id = id;
	this.addressLine1 = addressLine1;
	this.addressLine2 = addressLine2;
	this.city = city;
	this.state = state;
	this.zip = zip;

}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getAddressLine1() {
	return addressLine1;
}
public void setAddressLine1(String addressLine1) {
	this.addressLine1 = addressLine1;
}
public String getAddressLine2() {
	return addressLine2;
}
public void setAddressLine2(String addressLine2) {
	this.addressLine2 = addressLine2;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getZip() {
	return zip;
}
public void setZip(String zip) {
	this.zip = zip;
}

@Override
public String toString() {
	return "Address [id=" + id + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
			+ ", state=" + state + ", zip=" + zip + "]";
}



}


