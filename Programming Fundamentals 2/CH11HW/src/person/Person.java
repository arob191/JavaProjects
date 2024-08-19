/**
 * Objective: Use the concept of SuperClasses and SubClasses to create reusable code
 * Algorithm: Description how to resolve the problem.
 *Input and Output: Input is Person parameters and output is Person object
 * Created by: Austin Robertson
 * Date: 06/13/2024
 * Version: 1
 */

package person;

// The Superclass
public class Person {
	
	private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public Person(String name, String address, String phoneNumber, String email) {
    	
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        
    }

    public String toString() {
        return "Name: " + name + "Address: " + address + "Phone Number: " + phoneNumber + "Email: " + email;
    }
}
