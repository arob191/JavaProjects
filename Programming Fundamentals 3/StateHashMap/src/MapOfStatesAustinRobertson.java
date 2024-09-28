/**
 Austin Robertson
 COSC 2336-01
 Programming Assignment 3
 Due: 09/25/2024
 Submitted: 09/22/2024
 Use a hashmap to create key-value pairs of states and their respective capital
 */

import java.util.Scanner;
import java.util.HashMap;


public class MapOfStatesAustinRobertson {

    /**
     The Main class takes the users input and compares it to the key-value pairs in our HashMap
     Class Information:
     - Name: MapOfStatesAustinRobertson
     - Dependencies:
     - java.util.Scanner
     - java.util.HashMap
     - Package: None
     - Inheritance: None

     Purpose:
     - Used for running the main code

     Constants and Variables:
     - Constants: none
     - stateCapital: Array holding the states and capitals
     - states: The Hashmap used for storing our key-value pairs

     Constructors:
     - Default Constructor

     */

    public static void main(String[] args) {

        // Prompt for user input
        Scanner input = new Scanner(System.in);
        System.out.print("Hello! Please enter a state: ");
        String userInput = input.nextLine().toLowerCase(); // Convert user input to all lowercase

        // Add our String Array
        String[][] stateCapital = {
                {"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"},
                {"California", "Sacramento"},
                {"Colorado", "Denver"},
                {"Connecticut", "Hartford"},
                {"Delaware", "Dover"},
                {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"},
                {"Hawaii", "Honolulu"},
                {"Idaho", "Boise"},
                {"Illinois", "Springfield"},
                {"Indiana", "Indianapolis"},
                {"Iowa", "Des Moines"},
                {"Kansas", "Topeka"},
                {"Kentucky", "Frankfort"},
                {"Louisiana", "Baton Rouge"},
                {"Maine", "Augusta"},
                {"Maryland", "Annapolis"},
                {"Massachusetts", "Boston"},
                {"Michigan", "Lansing"},
                {"Minnesota", "Saint Paul"},
                {"Mississippi", "Jackson"},
                {"Missouri", "Jefferson City"},
                {"Montana", "Helena"},
                {"Nebraska", "Lincoln"},
                {"Nevada", "Carson City"},
                {"New Hampshire", "Concord"},
                {"New Jersey", "Trenton"},
                {"New York", "Albany"},
                {"New Mexico", "Santa Fe"},
                {"North Carolina", "Raleigh"},
                {"North Dakota", "Bismarck"},
                {"Ohio", "Columbus"},
                {"Oklahoma", "Oklahoma City"},
                {"Oregon", "Salem"},
                {"Pennsylvania", "Harrisburg"},
                {"Rhode Island", "Providence"},
                {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"},
                {"Tennessee", "Nashville"},
                {"Texas", "Austin"},
                {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"},
                {"Washington", "Olympia"},
                {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"},
                {"Wyoming", "Cheyenne"}
        };

        // Create our states hashmap
        HashMap<String,String> states = new HashMap<String,String>();

        // Create a for loop to add each state and capital as a key-value pair inside our Hashmap
        for (String[] pair : stateCapital) {
            String state = pair[0].toLowerCase(); // Set our state as the variable in index 0 and make it all lowercase
            String capital = pair[1]; // Set our state as the variable in index 1
            states.put(state, capital); // Add the state and capital as a key-value pair
        }

        // Check user input to see if the state is in the hashmap
        if (states.containsKey(userInput)) {
            String capital = states.get(userInput);
            System.out.println("Capital: " + capital);
        } else {
            System.out.println("Invalid State");
        }
    }
}