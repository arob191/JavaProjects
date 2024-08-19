/**
 * Objective: Use the concept of SuperClasses and SubClasses to create reusable code
 * Algorithm: Description how to resolve the problem.
 *Input and Output: Input is Person parameters and output is Person object
 * Created by: Austin Robertson
 * Date: 06/13/2024
 * Version: 1
 */


package person;

import java.util.Scanner;

// Main code
public class Main {

	// Ask the user for new person information for a student, faculty and staff
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Greetings and prompt explanation
		System.out.println("Hello! Please follow the prompts to create a new Person in the database.");
		
		// Input for Student
        System.out.println("Enter student details:");
        System.out.print("Name: ");
        String studentName = input.next();
        System.out.print("Address: ");
        String studentAddress = input.next();
        System.out.print("Phone number: ");
        String studentPhone = input.next();
        System.out.print("Email: ");
        String studentEmail = input.next();
        System.out.print("Class status (Freshman/Sophomore/Senior): ");
        String studentStatus = input.next();

        Student student = new Student(studentName, studentAddress, studentPhone, studentEmail, studentStatus);

        // Input for Faculty
        System.out.println("\nEnter faculty details:");
        System.out.print("Name: ");
        String facultyName = input.next();
        System.out.print("Address: ");
        String facultyAddress = input.next();
        System.out.print("Phone number: ");
        String facultyPhone = input.next();
        System.out.print("Email: ");
        String facultyEmail = input.next();
        System.out.print("Office: ");
        String facultyOffice = input.next();
        System.out.print("Salary: ");
        double facultySalary = input.nextDouble();
        System.out.print("Office hours: ");
        String facultyOfficeHours = input.next();
        System.out.print("Rank: ");
        String facultyRank = input.next();

        Faculty faculty = new Faculty(facultyName, facultyAddress, facultyPhone, facultyEmail,
                facultyOffice, facultySalary, "2024-05-10", facultyOfficeHours, facultyRank);

        // Input for Staff
        System.out.println("\nEnter staff details:");
        System.out.print("Name: ");
        String staffName = input.next();
        System.out.print("Address: ");
        String staffAddress = input.next();
        System.out.print("Phone number: ");
        String staffPhone = input.next();
        System.out.print("Email: ");
        String staffEmail = input.next();
        System.out.print("Office: ");
        String staffOffice = input.next();
        System.out.print("Salary: ");
        double staffSalary = input.nextDouble();
        System.out.print("Title: ");
        String staffTitle = input.next();

        Staff staff = new Staff(staffName, staffAddress, staffPhone, staffEmail, staffOffice, staffSalary, "2023-11-10", staffTitle);

        // Display created objects
        System.out.println("\nCreated objects:");
        System.out.println(student);
        System.out.println(faculty);
        System.out.println(staff);
    }
	
}
