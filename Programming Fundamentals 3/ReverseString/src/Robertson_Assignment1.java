/**
Austin Robertson
COSC 2336-01
Programming Assignment 1
Due:  09/04/2024
Submitted:  09/02/2024
This code reverses the user's input and prints it
*/

import java.util.Scanner;

public class Robertson_Assignment1 {
    /**
     * The Robertson_Assignment1 class takes the users input and reverses it using recursion
     *
     * Class Information:
     * - Name: Austin Robertson
     * - Dependencies: java.util.Scanner
     * - Package: None
     * - Inheritance: None
     *
     * Purpose:
     * - Runs the main code
     *
     * Constants and Variables:
     * - Constants: None
     * - Instance Variables:
     *   - input (Scanner): Scanner object.
     *   - userInput (String): Stores the users input.
     *
     * Constructors:
     * - Default Constructor
     *
     * Methods:
     * - reverse(): Reverses the users string.
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Create scanner object
        System.out.print("Enter a string: "); // Ask user for input
        String userInput = input.nextLine(); // Set userInput as the string provided by the user
        System.out.print("The reversal of your string: "); // Print to terminal
        reverse(userInput); // Call our reverse method and pass the userInput

    }

    /**
     * Reverses a given string recursively.
     * Method:
     * - Input: The input string to reverse.
     * - Return: None, Void
     */
    public static void reverse(String s) {
        if (s.length() == 0) { // The base case
            return;
        } else {
            System.out.print(s.charAt(s.length() - 1)); // Prints the last character in the input string
            reverse(s.substring(0, s.length() - 1)); // Makes a recursive call with the input string, removes the last character
        }

    }


}