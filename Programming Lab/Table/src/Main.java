//**********************************
// COSC 1173 Programming Lab
// Name: Austin Robertson
// Date: 10/03/2024
// Robertson - Assignment3: Print a table of kilograms to Pounds
//**********************************
import javax.swing.text.Style;

public class Main {
    public static void main(String[] args) {
        // Print the header
        System.out.printf("%-15s%15s%n", "---------------", "---------------");
        System.out.printf("%-15s%15s%n", "Kilograms", "Pounds"); // Left and right justify
        System.out.printf("%-15s%15s%n", "---------------", "---------------");

        //For loop to calculate and print our kg to pounds
        for(int i=1; i < 200; i+=2) { // Start at 1 and increase i by 2
            double pound = i * 2.2; // Initialize our pound variable
            System.out.printf("%-15d%15.1f%n", i, pound); // Left and right justify and display 1 decimal place
        }

        System.out.printf("%-15s%15s%n", "---------------", "---------------");
    }
}