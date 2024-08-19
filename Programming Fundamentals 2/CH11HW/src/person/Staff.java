/**
 * Objective: Use the concept of SuperClasses and SubClasses to create reusable code
 * Algorithm: Description how to resolve the problem.
 *Input and Output: Input is Person parameters and output is Person object
 * Created by: Austin Robertson
 * Date: 06/13/2024
 * Version: 1
 */

package person;

// Subclass of Employee
public class Staff extends Employee {
	
    private String title;

    public Staff(String name, String address, String phoneNumber, String email, String office, double salary, String dateHired, String title) {
       
    	super(name, address, phoneNumber, email, office, salary, dateHired);
        this.title = title;
        
    }

    public String toString() {
        return "Staff: " + super.toString() + "Title: " + title;
    }
}
