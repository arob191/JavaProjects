//**********************************
// COSC 1173 Programming Lab
// Name: Austin Robertson
// Date: 10/06/2024
// Robertson - Create a method to convert Celsius to Fahrenheit
//**********************************
import java.util.Scanner;

// Main code
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input a temperature in Celsius: ");
        // Set our Celsius variable to the user input
        double celsius = scanner.nextDouble();
        // Set our Fahrenheit variable using our conversion method
        double fahrenheit = conversion(celsius);
        // Print results
        System.out.println(celsius + " degrees Celsius is equal to " + fahrenheit + " degrees Fahrenheit");
    }

    // Static double method that returns the user input converted into Fahrenheit
    public static double conversion(double celsius){
        return ((double) 9 /5) * celsius + 32;
    }

}