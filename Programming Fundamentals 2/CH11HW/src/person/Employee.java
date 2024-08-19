/**
 * Objective: 
 * Algorithm: Description how to resolve the problem.
 *Input and Output: Input is Person parameters and output is Person object
 * Created by: Austin Robertson
 * Date: 06/13/2024
 * Version: 1
 */

package person;

// Subclass of Person
public class Employee extends Person {
    
	private String office;
    private double salary;
    private String dateHired;

    public Employee(String name, String address, String phoneNumber, String email, String office, double salary, String dateHired) {
        
    	super(name, address, phoneNumber, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
        
    }

    public String toString() {
        return super.toString() + "Office: " + office + "Salary: " + salary + "Date Hired: " + dateHired;
    }
}
