/**
 * Objective: Use Java IO to create an objectinputstream object
 * Algorithm: We will use the java io class create the objectinputstream object and serialize our variables our object to the "object.dat" file
 *Input and Output: Input is our variables and our date object. Output will be the object.dat file
 * Created by: Austin Robertson
 * Date: 07/24/24
 * Version: 1
 */

package objectpckg;

import java.io.*;

public class TestObjectInput {

	public static void main(String[] args)	throws IOException, ClassNotFoundException { //Main argument that throws exceptions
		
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("object.dat")); //Create our objectinputstream object
		
		//Declare and serialize our variables and data object to the object.dat file
		String name = input.readUTF();
		double score = input.readDouble();
		java.util.Date date = (java.util.Date) (input.readObject());
		
		//Print out our variables and object to the user
		System.out.println(name + " " + score + " " + date);
		
	}
	
}
