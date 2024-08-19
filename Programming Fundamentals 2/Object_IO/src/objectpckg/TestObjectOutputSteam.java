/**
 * Objective: Use Java IO to create an objectoutputstream object
 * Algorithm: We will use the java io class create the objectinputstream object and serialize our variables our object to the "object.dat" file
 *Input and Output: Input is our variables and our date object. Output will be the object.dat file
 * Created by: Austin Robertson
 * Date: 07/24/24
 * Version: 1
 */
package objectpckg;

import java.io.*;

public class TestObjectOutputSteam {
	
	public static void main(String[] args) throws IOException { //Main argument throws exceptions
		
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("object.dat")); //Create our objectoutputstream object
		
		//Output the variables and date object
		output.writeUTF("John");
		output.writeDouble(85.5);
		output.writeObject(new java.util.Date());
		
		output.close();
		
	}
	
}
