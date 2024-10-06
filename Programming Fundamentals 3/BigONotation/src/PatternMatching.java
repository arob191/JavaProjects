import java.util.Scanner;

/**
 Austin Robertson
 COSC 2336-01
 Programming Assignment 5
 Due: 10/09/2024
 Submitted: 10/06/2024
Use KMP algorithm to find the substring in a string
 */

public class PatternMatching {

    /**
     The Main class takes the users input for two strings (text and substring) and tries to find the
     substring within the text
     Class Information:
     - Name: PatternMatching
     - Dependencies:
     - java.util.Scanner
     - Package: None
     - Inheritance: None

     Purpose:
     - Used for running the main code

     Constants and Variables:
     - Constants: none
     - failure: Array that holds the failure function of the substring
     - index: Used for the output of the program

     Constructors:
     - Default Constructor

     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Initialize our text and substring variables
        System.out.println("Please provide string one: ");
        String text = scanner.nextLine();
        System.out.println("Please provide the substring you'd like to check for: ");
        String substring = scanner.nextLine();

        //We call our checkSubstring method
        int index = checkSubstring(text, substring); //Initialize our index and set it to the return value of our method
        if(index >= 0){
            System.out.println("The substring matched the text at index " + index);
        } else {
            System.out.println("No match found, try again");
        }

    }

    /**
     *This method uses our failure function and compares the text to the substring to find a match
     * Method:
     *  -Input: User input for text and substring
     *  -Returns: Returns the index that the substring matched at or return -1 for no match
     */
    public static int checkSubstring(String text, String substring){
        int[] failure = substringFailure(substring); //Define the failure function for the substring
        //Initialize our i and k values
        int i = 0; //For the text string
        int k = 0; //For the substring
        while (i < text.length()) {
            //Compare our text to our substring
            if (text.charAt(i) == substring.charAt(k)){
                //If k is our final index then we found a match
                if(k == substring.length() - 1){
                    return i - substring.length() + 1; //Return the index where the substring matches the text
                }
                //If we are not at the end of our substring increase i and k
                i++;
                k++;
            }
            else{ // If we do not find a match we will utilize our failure function to realign our substring
                if(k > 0) {
                    k = failure[k - 1]; //Match the prefix position if k is greater than 0
                }
                else { //If k = 0 then we just move to the next index in the text
                    i++;
                }
            }
        }
        return -1; //If we looped through the entire text and did not find a complete match with the substring
    }


    /**
     * Creates our failure array for the substring
     * Method:
     * - Input: The substring
     * - Return: The failure array of our substring
     */
    private static int[] substringFailure(String substring) {
        int[] failure = new int[substring.length()]; // Initialize our failure array
        //Set our i and k variables. Offset k by one to find the prefix
        int i = 1;
        int k = 0;
        while (i < substring.length()) {
            //If we find that index i matches index k then we increase our k value and set our fail array
            if (substring.charAt(i) == substring.charAt(k)) {
                failure[i] = k + 1;
                i++;
                k++;
            }
            else if (k > 0) { // If i and k do not match and k is greater than 0 subtract one from k
                k = failure[k - 1];
            }
            else { // If i and k do not match and k = 0 then increase i to compare the next indexes
                i++;
            }
        }

        return failure; // Return our array to our checkSubstring method
    }
}