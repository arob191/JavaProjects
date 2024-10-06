//**********************************
// COSC 1173 Programming Lab
// Name: Austin Robertson
// Date: 10/06/2024
// Robertson - Bonus Assignment for Assignment 6
//**********************************

public class Main {

    // Main Code
    public static void main(String[] args) {
        // Print the header
        System.out.printf("%-15s%15s%n", "---------------", "---------------");
        System.out.printf("%-15s%15s%n", "Celsius", "Fahrenheit"); // Left and right justify
        System.out.printf("%-15s%15s%n", "---------------", "---------------");

        //For loop that will use our conversion function
        for(int i=40; i > 30; i--) { // Start at 40 and go down by 1
            double fahrenheit = conversion(i);
            System.out.printf("%-15d%15.1f%n", i, fahrenheit); // Left and right justify and display 1 decimal place
        }

        System.out.printf("%-15s%15s%n", "---------------", "---------------");
    }

    //Our public function that return Fahrenheit as a double
    public static double conversion(double celsius){
        return ((double) 9 /5) * celsius + 32; // Celsius to Fahrenheit conversion
    }
}