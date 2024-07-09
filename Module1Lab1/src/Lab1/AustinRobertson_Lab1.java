/*
 * Austin Robertson
 * Module 1 Lab 1
 * 06/03/2024
 * COSC 1174
 * This is a program created for Lab 1 of Module 1
 * This program repeatedly takes user input of any integer, provides the total and average, and ends when the input is 0
 */



package Lab1;

//Import scanner to take user input
import java.util.Scanner;

//Main class
public class AustinRobertson_Lab1 {
	
	//Main method
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Lets declare our variables
		int total = 0;
		int positiveCount = 0;
		int negativeCount = 0;
		
		//Initially ask the user for the first integer, we will ask for the next entry during the while loop
		System.out.print("Please type an integer: ");
		int x;
		x = input.nextInt();
		
		//While loop for counting the negative and positive numbers. Exit loop on "0"
		while (x != 0) {
			if (x > 0) {
				positiveCount++;
			} else {
				negativeCount++;
			}
			total += x;
			
			//Ask user for the next int, let them know they can exit by entering "0"
			System.out.print("Please enter another integer or enter '0' to exit: ");
			x = input.nextInt();
		}
		
		//Find the average, then display the total positives, total negatives, the overall total, and the average. Only executes if the user entered a valid input.
		if (positiveCount + negativeCount > 0) {
			double average = (double) total / (positiveCount + negativeCount);
			System.out.println("Total Positives: " + positiveCount);
			System.out.println("Total Negatives: " + negativeCount);
			System.out.println("Total: " + total);
			System.out.println("Average: " + average);
		} else {
			System.out.println("No valid input provided.");
		}
		
		input.close();
		
	}
}