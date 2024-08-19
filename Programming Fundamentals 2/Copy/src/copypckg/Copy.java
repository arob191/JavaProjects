/**
 * Objective: Use Java IO to copy the contents of a source file to a target file
 * Algorithm: We will use the java io to take in a sourcefile argument and a targetfile argument, read the bytes of data, then copy the bytes to a targetfile
 *Input and Output: Input is our source file and our output will be the target file
 * Created by: Austin Robertson
 * Date: 07/24/24
 * Version: 1
 */

package copypckg;

import java.io.*;

public class Copy {
	
	public static void main(String[] args) throws IOException { //Main argument that takes 2 arguments and throws exception
		if (args.length !=2) { //Let the user know that we need 2 arguments for this program
			System.out.println("Usage: Java Copy sourceFile targetFile");
			System.exit(0);
		}
		
		File sourceFile = new File(args[0]); //Declares the first argument as our source file
		if (!sourceFile.exists()) {//If the source file does not exist we let the user know
			System.out.println("Source file" + args[0] + " does not exist");
			System.exit(0);
		}
		
		File targetFile = new File(args[1]);//Declares the second argument as our target file
		if (targetFile.exists()) {//We let the user know if the file already exists
			System.out.println("Target file" + args[1] + " already exists");
		}
		
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile)); //Buffer input to make the input easier to work with
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile)); //Buffer output to target file
		
		//Declare our variables
		int r;
		int numberOfBytesCopied = 0;
		
		while((r = input.read()) != -1) { //While there are still bytes to be copied we continue to keep track of them
			output.write((byte) r);
			numberOfBytesCopied++;
		}
		
		input.close();
		output.close();
		
		System.out.println(numberOfBytesCopied + " bytes copied"); //Let the user know how many bytes were copied
		
	}
	
}
