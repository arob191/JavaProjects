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
public class Faculty extends Employee {
   
	private String officeHours;
    private String rank;

    public Faculty(String name, String address, String phoneNumber, String email, String office, double salary, String dateHired, String officeHours, String rank) {
        
    	super(name, address, phoneNumber, email, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
        
    }

    public String toString() {
        return "Faculty: " + super.toString() + "Office Hours: " + officeHours + "Rank: " + rank;
    }
	
}
