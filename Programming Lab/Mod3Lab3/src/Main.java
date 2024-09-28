//**********************************
// COSC 1173 Programming Lab
// Name: Austin Robertson
// Date: 09/13/2024
// Robertson - Assignment3: Create a program that generates a random number between 1 and 12 and displays the corresponding month
//**********************************

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // Create our random object and then set monthNumber to a number between 1 and 12
        Random random = new Random();
        int MonthNumber = random.nextInt(12) + 1;

        // Get the corresponding month name using a switch statement
        String MonthName;
        switch (MonthNumber) {
            case 1: MonthName = "January"; break;
            case 2: MonthName = "February"; break;
            case 3: MonthName = "March"; break;
            case 4: MonthName = "April"; break;
            case 5: MonthName = "May"; break;
            case 6: MonthName = "June"; break;
            case 7: MonthName = "July"; break;
            case 8: MonthName = "August"; break;
            case 9: MonthName = "September"; break;
            case 10: MonthName = "October"; break;
            case 11: MonthName = "November"; break;
            case 12: MonthName = "December"; break;
            default: MonthName = "Invalid month"; break;
        }

        // Print the result
        System.out.println("Random number: " + MonthNumber);
        System.out.println("Month name: " + MonthName);
    }
}
