package edu.ektha.student.maintain;
/*These are the imports that we need in this class*/
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Sandeep Thandra 
 *         This class id designed to perform all the logic in
 *         the behaviors using the data members for that we are using arraylist
 *         and we are storing all the objects of student class in the list
 *
 */
public class Roster {

	static ArrayList<Student> studentlist = new ArrayList<Student>();

	/**
	 * @param StudentId
	 *           StudentId is passed to this method as user input logic checks the
	 *            id and remove the student with that particular id
	 */
	public void remove(String StudentId) {
		if (Integer.parseInt(StudentId) > 0 && Integer.parseInt(StudentId) < 6) {
			int size = studentlist.size();
			for (int i = 0; i < studentlist.size(); i++) {
				if (studentlist.get(i).getStudentId().equals(StudentId)) {

					studentlist.remove(i);
					System.out.println("the student with id " + StudentId + " is removed");
				}

			}

			if (size == studentlist.size()) {
				System.out.println("student id doesnot exist");

			}

		} else {
			System.out.println("student id does not exist");
		}

	}

	/**
	 * Here in this behavior we are performing the logic which prints all the
	 * details of the students like first name, last name, age, emailid, grades
	 */
	public static void printall() {
		for (Student s : studentlist) {
			System.out.print("studentId:" + s.getStudentId()+"\t" +"First Name:" + s.getFirstname() + "\t" + "Last Name:" + s.getLastname() + "\t"
					+ "emailAddress:" + s.getEmailaddress() + "\t" + "age:" + s.getAge() + "\t" + "grades:{"
					+ s.getGrades() + "}\n");

		}

	}

	/**
	 * @param StudentId
	 *           StudentId is passed as a user input parameter to this method when
	 *            the entered id equals to the id already in the arraylist logic
	 *            will perform to calculate the average grades of the student
	 *            with that id
	 */
	public static void printAverageGrade(String StudentId) {
		for (Student s : studentlist) {
			if (s.getStudentId().equals(StudentId)) {
				String[] grades = s.getGrades().split(",");
				int i1 = Integer.parseInt(grades[0]);
				int i2 = Integer.parseInt(grades[1]);
				int i3 = Integer.parseInt(grades[2]);
				int average = (i1 + i2 + i3) / (grades.length);
				System.out.println("the average grade of student with Id:" + average);

			}
		}

	}

	/**
	 * this behavior represents logic towards print invalid emails address which
	 * are not matched with the pattern given at the time of filling student
	 * email address.
	 */
	public static void printInvalidEmails() {
		System.out.println("invalid email addresses are:");
		for (Student s : studentlist) {
			if (!Pattern.matches("([A-Za-z0-9]*)\\.*([A-Za-z0-9]*)@([A-Za-z0-9]*)\\.*([A-Za-z0-9]*)",
					s.getEmailaddress()))
				System.out.println(s.getEmailaddress());

		}

	}

	/**
	 * this method calls above all methods and takes the inputs from the user i
	 * defined this method to code readability.
	 */
	public static void callAll() {
		printall();
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the student id you want to remove:");
		String sId = input.nextLine();

		new Roster().remove(sId);
		System.out.println("Enter the student id you want to remove:");
		String sId2 = input.nextLine();

		new Roster().remove(sId2);
		printall();
		System.out.println("enter the student id to find average grade");
		String sID = input.nextLine();
		input.close();
		printAverageGrade(sID);
		printInvalidEmails();
	}

	/**
	 * @param args
	 *            This is starting point of the program here we are creating the
	 *            objects and initializing the values to instance variables
	 *            using constructors add the created objects to the Arraylist we
	 *            already created
	 */
	public static void main(String[] args) {
		Student student1 = new Student("1", "John", "Smith", "John1989@gmail.com", 20, "88,79,59");
		Student student2 = new Student("2", "Suzan", "Erickson", "Erickson_1990@gmailcom", 19, "91,72,85");
		Student student3 = new Student("3", "Jack", "Napoli", "The_lawyer99yahoo.com", 19, "85,84,87");
		Student student4 = new Student("4", "Erin", "Black", "Erin.black@comcast.net", 22, "91,98,82");
		Student student5 = new Student("5", "Sann", "Rao", "askthandra@outlook.com", 23, "80,83,87");

		studentlist.add(student1);
		studentlist.add(student2);
		studentlist.add(student3);
		studentlist.add(student4);
		studentlist.add(student5);

		callAll();

	}
}