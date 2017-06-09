package com.maxxis.ccprocessing.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Applicant {
    
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="custID", nullable=false, unique=true, length=4)
	private int id;
	private String firstName;
	private String middle;
	private String lastName;
	private String dateOfBirth;
	private String SSN;
	private String email;
	private String telephone;
	private String CompanyName;
	
	private String applicationStatus;
	private String annualIncome;
	private String houseMortage;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="AddID")
	private Address address;
	
	public Applicant(){
		
	}
	

	public Applicant(int id, String firstName, String middle, String lastName, String dateOfBirth, String sSN,
			String email, String telephone, String companyName, String applicationStatus, String annualIncome,
			String houseMortage, Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middle = middle;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		SSN = sSN;
		this.email = email;
		this.telephone = telephone;
		CompanyName = companyName;
		this.applicationStatus = applicationStatus;
		this.annualIncome = annualIncome;
		this.houseMortage = houseMortage;
		this.address = address;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCompanyName() {
		return CompanyName;
	}



	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}



	public String getApplicationStatus() {
		return applicationStatus;
	}



	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}



	public String getAnnualIncome() {
		return annualIncome;
	}



	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}



	public String getHouseMortage() {
		return houseMortage;
	}



	public void setHouseMortage(String houseMortage) {
		this.houseMortage = houseMortage;
	}



	@Override
	public String toString() {
		return "Applicant [id=" + id + ", firstName=" + firstName + ", middle=" + middle + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", SSN=" + SSN + ", email=" + email + ", telephone=" + telephone
				+ ", CompanyName=" + CompanyName + ", applicationStatus=" + applicationStatus + ", annualIncome="
				+ annualIncome + ", houseMortage=" + houseMortage + ", address=" + address + "]";
	}

	
	
	
	
}

