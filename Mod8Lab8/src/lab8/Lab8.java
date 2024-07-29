/*
 * Austin Robertson
 * Module 6 Lab 6
 * 07/18/2024
 * COSC 1174
 * This is a program created for Lab 66 of Module 6
 * This program users the scanner and filename classes to input user data and read through text files containing a list of the most popular baby names between 2001-2010
 */

package lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lab8 {
	
    public static void main(String[] args) throws IOException {
        
    	String filePath = "C:/Users/Austin/OneDrive/Documents/Personal Projects/GitHub/JavaProjects/Mod8Lab8/cmudict_0_6.txt"; // Update with the actual file path
    	
    	List<String> words = new ArrayList<>(); // Create our words array
        List<String> pronunciations = new ArrayList<>(); // Create our pronunciation array

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) { // Read in our file
            String line; // Create our line variable
            int numOfWords = 0; // Variable to count the number of words in our data file
            while ((line = reader.readLine()) != null) { // Continue the loop until our line variable is null
                String[] parts = line.split("\\s+", 2); // Split each line into a max of 2 parts
                if (parts.length == 2) { // If we have two parts then continue
                    String word = parts[0]; // Set part one(0) to the word array
                    String pronunciation = parts[1]; // Set part two(1) to the pronunciation array
                    words.add(word); // Add the word to the array
                    pronunciations.add(pronunciation); // Add the pronunciation to the array
                numOfWords++; // Increase our word count
                } else {
                    System.out.println("Invalid line format: " + line); // In case there was an unexpected line
                }
            }
            System.out.println("Words array: " + numOfWords + " words"); // Print our how many words we got from the data set
            Scanner scanner = new Scanner(System.in); // Create our scanner for user input
            System.out.print("Enter a word: "); // Ask the user for a word
            String userInput = scanner.nextLine().toUpperCase(); // Convert to uppercase for case-insensitive lookup

            // Look up the pronunciation
            int index = words.indexOf(userInput); // Find the index of the word
            if (index != -1) { // As long as the index is not -1 continue
                String pronunciation = pronunciations.get(index); // Match the index of the word to the pronunciation
                System.out.println("Pronunciation for '" + userInput + "': " + pronunciation); // Print our the word and the pronunciation
            } else {
                System.out.println("Word not found in the dictionary."); // If the word is not in the array
            }
        
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage()); // Throw an error if for anything unexpected
        }
 
    }
}
