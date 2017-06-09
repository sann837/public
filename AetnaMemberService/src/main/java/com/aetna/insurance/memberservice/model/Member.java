package com.aetna.insurance.memberservice.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@XmlAccessorType
public class Member implements Serializable {

	@Id
	/*@GeneratedValue(strategy = GenerationType.AUTO)*/
	private String memberId;
	private String firstName;
	private String lastName;
	
	@Basic(fetch = FetchType.LAZY) 
	private String ssn;
	private String selectedPlan;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AddId")
	private Address address;

	public Member(){
		
	}
	
	public Member(String memberId, String firstName, String lastName, String ssn, String selectedPlan, Address address) {
		super();
		this.memberId = memberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.selectedPlan = selectedPlan;
		this.address = address;
	}

	public String getMemberId() {
		return memberId;
	}

	@XmlTransient
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

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

	
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getSelectedPlan() {
		return selectedPlan;
	}

	public void setSelectedPlan(String selectedPlan) {
		this.selectedPlan = selectedPlan;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn
				+ ", selectedPlan=" + selectedPlan + ", address=" + address + "]";
	}
	
	
	
}
