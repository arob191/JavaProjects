/**
 Austin Robertson
 COSC 2336-01
 Programming Assignment 2
 Due: 09/11/2024
 Submitted: 09/10/2024
 Uses Generics to sort user input of 10 integers and 5 strings
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
      The Main class takes the users input sorts it using generic methods
      Class Information:
      - Name: Main
      - Dependencies:
          - java.util.Scanner
          - jave.util.Arraylist
      - Package: None
      - Inheritance: None

      Purpose:
      - Used for running the main code

      Constants and Variables:
      - Constants: None
      - Instance Variables: None
      - intInput: Stores the user input for integers.
      - intStrings: An array of strings obtained by splitting intInput at spaces.
      - strings: An array of strings obtained by splitting the user input for strings at spaces.
      - stringInput: Stores the user input for strings.
      - intList: An ArrayList to store the parsed integers.
      - stringList: An ArrayList to store the user-provided strings.
      - E currentMin: The minimum element
      - currentMinIndex: the minimum element index

      Constructors:
      - Default Constructor

      Methods:
      - sort(): Uses the generic type e and an array to sort the user input.
     */

    // Main code
    public static void main(String[] args) {
        System.out.println("Hello and welcome to my program!"); // Greet our user!

        Scanner scanner = new Scanner(System.in); // Create our scanner object for user input

        // Sort for integers
        ArrayList<Integer> intList = new ArrayList<>(); // Create our array to store the user input (integer objects)
        System.out.println("Enter 10 number:"); // Ask for user for 10 integers
        String intInput = scanner.nextLine(); // Set our temp variable as the user input
        String[] intStrings = intInput.split(" "); // Splits our user input at each space and stores it in a temp array
        for (String intString : intStrings) { // Loop through each string
            intList.add(Integer.parseInt(intString)); // Parse and populate our array with our user input
        }
        sort(intList); // Call our sort method, pass our array
        System.out.println("The sorted numbers: " + intList); // Print the results

        // Sort for strings
        ArrayList<String> stringList = new ArrayList<>(); // Create an array to store our user input
        System.out.println("Enter 5 strings:"); // Ask the user for 5 strings
        String stringInput = scanner.nextLine(); // Set our temp variable as the user input
        String[] strings = stringInput.split(" "); // Splits our user input at each space and populate our temp array
        for (String str : strings) { // Loop through our temp array
            stringList.add(str); // No need to parse, just populate our array
        }
        sort(stringList); // Call our method, pass our array
        System.out.println("The sorted strings: " + stringList); // Print results
    }


    /**
     Used for taking in an array to sort the elements.
     Method:
     - Input: The arrays for us to sort
     - Return: None, Void
     */
    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        E currentMin;
        int currentMinIndex;

        // First we need to grab the minimum in our array
        for (int i = 0; i < list.size() - 1; i++) {
            currentMin = list.get(i);

            currentMinIndex = i;

            // Compare to our next element and if the element is smaller set it as the Min
            for (int j = i + 1; j < list.size(); j++) {
                if (currentMin.compareTo(list.get(j)) > 0) {
                    currentMin = list.get(j);
                    currentMinIndex = j;
                }
            }

            // If our currentMinIndex is now j then swap the elements
            if (currentMinIndex != i) {
                list.set(currentMinIndex, list.get(i));
                list.set(i, currentMin);
            }
        }
    }
}







//        for (int i = 0; i < list.size() - 1; i++) { // Our outer loop to iterate through our list
//            for (int j = i + 1; j < list.size(); j++) { // Inner loop to compare the elements, grabs our current and the following element
//                if (list.get(i).compareTo(list.get(j)) > 0) { // Compare our elements to each out
//                    // Swap elements if needed
//                    E temp = list.get(i); // Set our temp element
//                    list.set(i, list.get(j)); // Set the element in position i as element j
//                    list.set(j, temp); // Set our element at position j as element i (temp)
//                }
//            }
//        }