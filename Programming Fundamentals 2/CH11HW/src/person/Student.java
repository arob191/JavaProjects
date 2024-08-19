/**
 * Objective: Use the concept of SuperClasses and SubClasses to create reusable code
 * Algorithm: Description how to resolve the problem.
 *Input and Output: Input is Person parameters and output is Person object
 * Created by: Austin Robertson
 * Date: 06/13/2024
 * Version: 1
 */

package person;

// Subclass of Person
public class Student extends Person {
	
	// Constants for class status
    public static final String FRESHMAN = "Freshman";
    public static final String SOPHOMORE = "Sophomore";
    public static final String SENIOR = "Senior";

    private String classStatus;

    public Student(String name, String address, String phoneNumber, String email, String classStatus) {
    
    	super(name, address, phoneNumber, email);
    	this.classStatus = classStatus;
    
    }

    public String toString() {

    	return "Student: " + super.toString() + "Class Status: " + classStatus;
    
    }
}
