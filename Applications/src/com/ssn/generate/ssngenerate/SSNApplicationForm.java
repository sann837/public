package com.ssn.generate.ssngenerate;

public class SSNApplicationForm {

	private String firstname;
	private String lastname;
	private String passportnumber;
	private String placeofbirth;
	private String dateofbirth;
	private String sex;
	private String mailingaddressline1;
	private String mailingaddressline2;
	private String state;
	private String zipcode;
	private String phnumber;
	private String todaysdate;
	private String yoursignature;

	public SSNApplicationForm() {
	}

	public SSNApplicationForm(String firstname, String lastname, String passportnumber, String placeofbirth,
			String dateofbirth, String sex, String mailingaddressline1, String mailingaddressline2, String state,
			String zipcode, String phnumber, String todaysdate, String yoursignature) {

		this.firstname = firstname;
		this.lastname = lastname;
		this.passportnumber = passportnumber;
		this.placeofbirth = placeofbirth;
		this.dateofbirth = dateofbirth;
		this.sex = sex;
		this.mailingaddressline1 = mailingaddressline1;
		this.mailingaddressline2 = mailingaddressline2;
		this.zipcode = zipcode;
		this.phnumber = phnumber;
		this.todaysdate = todaysdate;
		this.yoursignature = yoursignature;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassportnumber() {
		return passportnumber;
	}

	public void setPassportnumber(String passportnumber) {
		this.passportnumber = passportnumber;
	}

	public String getPlaceofbirth() {
		return placeofbirth;
	}

	public void setPlaceofbirth(String placeofbirth) {
		this.placeofbirth = placeofbirth;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMailingaddressline1() {
		return mailingaddressline1;
	}

	public void setMailingaddressline1(String mailingaddressline1) {
		this.mailingaddressline1 = mailingaddressline1;
	}

	public String getMailingaddressline2() {
		return mailingaddressline2;
	}

	public void setMailingaddressline2(String mailingaddressline2) {
		this.mailingaddressline2 = mailingaddressline2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhnumber() {
		return phnumber;
	}

	public void setPhnumber(String phnumber) {
		this.phnumber = phnumber;
	}

	public String getTodaysdate() {
		return todaysdate;
	}

	public void setTodaysdate(String todaysdate) {
		this.todaysdate = todaysdate;
	}

	public String getYoursignature() {
		return yoursignature;
	}

	public void setYoursignature(String yoursignature) {
		this.yoursignature = yoursignature;
	}

}
