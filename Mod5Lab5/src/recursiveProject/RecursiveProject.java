/*
 * Austin Robertson
 * Module 5 Lab 5
 * 07/15/2024
 * COSC 1174
 * This is a program created for Lab 5 of Module 5
 * This program uses the recursive 
 */

package recursiveProject;

import java.util.Scanner; // Import the Scanner class for user input

public class RecursiveProject {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Create a Scanner object to read input

        System.out.print("Enter Text Here: "); // Prompt the user to enter a string
        String value = input.nextLine(); // Read the input string from the user

        System.out.print("Reversed Text: "); // Print the label for the reversed string
        reverseDisplay(value); // Call the method to reverse and display the string

        input.close(); // Close the Scanner 
    }


    public static void reverseDisplay(String value) {
        if (value.length() == 0) { // Base case: if the string is empty, return
            return;
        } else {
            System.out.print(value.charAt(value.length() - 1)); // Print the last character of the string
            reverseDisplay(value.substring(0, value.length() - 1)); // Recursively call the method with the substring excluding the last character
        }
    }
}
