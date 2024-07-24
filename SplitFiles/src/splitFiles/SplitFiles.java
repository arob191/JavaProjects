/**
 * Objective: Use Java IO to split a file into multiple files
 * Algorithm: We will use the java io class to intake one file and split it into multiple files
 *Input and Output: Input is one source file and output is multiple source files
 * Created by: Austin Robertson
 * Date: 07/24/24
 * Version: 1
 */


package splitFiles;

import java.io.*;

public class SplitFiles {

	public static void main(String[] args) throws Exception {
		
		// This establishes the amount of arguments that should be given in command line. If more than 2 we notify the user
		if (args.length !=2) {
			System.out.println("Usage: Java SplitFile.java SourceFile numberOfPieces");
			System.exit(0);
		}
		
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(new File(args[0]))); //Buffer the data input
		
		int numberOfPieces = Integer.parseInt(args[1]); //Parse the number of times the user wants to split up the data into int
		
		System.out.println("File  size: " + input.available() + " bytes"); //Display the file size of the input file
		long fileSize = input.available(); //Make a variable for the entire file size
		int splitFileSize = (int) Math.ceil(1.0 * fileSize / numberOfPieces); //Divide the number of bytes by how many files the user would like
		
		for (int i = 1; i <= numberOfPieces; i++) { //Create a for loop to start outputting the data on to new files
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(args[0] + "." + i))); //create a new file to start outputing the data
			
			//Declare out variables
			int value; 
			int count = 0;
			
			while (count++ < splitFileSize && (value = input.read()) !=-1) { //To determine when we have reached the number of times the user wanted to split the file or if we have reached the end of the input file
				output.write(value);
				
			}
			output.close();
		}
		input.close();
	}
	
}
