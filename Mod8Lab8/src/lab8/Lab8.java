package lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class Lab8 {
	
    public static void main(String[] args) throws IOException {
        
    	String filePath = "C:/Users/Austin/OneDrive/Documents/Personal Projects/GitHub/JavaProjects/Mod8Lab8/cmudict_0_6.txt"; // Update with the actual file path
    	String[] words = new String[getRowCount(filePath)]; // Create an array for the words and adjust the size of the array to the size of the data file
    	String[] pronunciations = new String[words.length]; // Create an array for pronunciations and set the size equal to the words array

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int index = 0; // Keep track of the current word index
            while ((line = reader.readLine()) != null) { // While the lines still have data keep going
                String[] parts = line.split("\\s+"); // Split our data into two parts to read for later
                if (parts.length >= 2) { // Stop if our parts is null
                    words[index] = parts[0]; // Fill our first array with the words
                    pronunciations[index] = parts[1]; // Fill our second array with the pronunciations
                    index++;
                }
            }
            System.out.println("Total number of words read:" + index); // Print how many lines have been read
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage()); // Throw error to user if there was anything unexpected
        }
        
        
        Scanner scanner = new Scanner(System.in); // Prompt the user to look up a word
        System.out.print("Enter a word: "); // Print the prompt
        String userWord = scanner.nextLine(); // Set the variable to the word that the user chose

        // Look up the pronunciation using the method created
        String foundPronunciation = findPronunciation(userWord, words, pronunciations);

        if (foundPronunciation != null) { // If the word that the user chose is found
            System.out.println("Pronunciation of '" + userWord + "': " + foundPronunciation); // Print the pronunciation
        } else {
            System.out.println("The pronunciation could not be found for '" + userWord + "'."); // Else print that the word/pronunciation could not be found
        }
    }

    public static int getRowCount(String filePath) throws IOException { // Our method to count the number of rows in our data set so we can make sure that the array is the size equal to the data set
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {// Read in our file
            int count = 0; // Set the count
            while (reader.readLine() != null) { // Read until the data is null
                count++; // Increase our count
            }
            return count; // Return count to our array
        }
    }

    public static String findPronunciation(String word, String[] words, String[] pronunciations) { // Method for finding the word and then finding the pronunciation with the same index aka our binary search
        for (int i = 0; i < words.length; i++) { // For loop to find our word
            if (words[i] != null && words[i].equalsIgnoreCase(word)) { // Finding our word and ignoring case sensitivity
                return pronunciations[i]; // Once we find our word we find the pronunciation with the same index
            }
        }
        return null; // Word not found   
    }
}
