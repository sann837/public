package edu.ektha.student.maintain;



/**
 * @author Sandeep Thandra
 * This class is designed to hold the entities which is needed to achieve  requirement given
 * along with this we are providing getters and setters that means we providing security to data members
 * we can access them only through getters and setters
 *
 */
public class Student {

	private String studentId;
	private String firstname;
	private String lastname;
	private String emailaddress;
	private int age;
	private String grades;

	public Student() {

	}

	public Student(String studentId, String firstname, String lastname, String emailaddress, int age, String grades) {
		this.studentId = studentId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailaddress = emailaddress;
		this.age = age;
		this.grades = grades;

	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGrades() {
		return grades;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}

}
