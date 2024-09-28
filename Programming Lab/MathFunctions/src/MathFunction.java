//**********************************
// COSC 1173 Programming Lab
// Name: Austin Robertson
// Date: 09/20/2024
// Robertson - Assignment 3: Program to determine the area of a hexagon of the side length chosen by the user
//**********************************

import java.util.Scanner;

// Main Class
public class MathFunction {

    // Main method
    public static void main(String[] args) {

        // Scanner object
        Scanner scanner = new Scanner(System.in);

        // Asking for user input
        System.out.print("Enter the side length of the hexagon: ");

        // Assign our double variable side the user input
        double side = scanner.nextDouble();

        // Calculate the area
        double area = (Math.pow(side, 2) * 6) / (4 * Math.tan(Math.PI / 6));

        // Format the output to two decimal places
        System.out.printf("The area of the hexagon is: %.2f%n", area);

        // Close scanner
        scanner.close();
    }
}