//**********************************
// COSC 1173 Programming Lab
// Name: Austin Robertson
// Date: 09/05/2024
// Robertson - Assignment2: Calculate the area and volume of a cylinder with the dimensions chosen by the user.
//**********************************

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Try catch block to catch any unexpected strings (non-numbers)
        try {
            System.out.println("Hello and welcome to my program!");

            Scanner input = new Scanner(System.in); //Create new scanner object

            // Ask the user for the raidus and parse the string to a double
            System.out.print("Please enter the radius of the Cylinder: ");
            String radiusStr = input.nextLine();
            double radius = Double.parseDouble(radiusStr);

            // Ask the user for the length of the cylinder and parse it to a double
            System.out.print("Please enter the length of the cylinder: ");
            String lengthStr = input.nextLine();
            double length = Double.parseDouble(lengthStr);

            // Call our calculate method, pass our radius and length
            calculate(radius, length);

        } catch (NumberFormatException e) { // Catch any issues when parsing to doubles
            System.out.println("Invalid input. Please enter integers only.");
        }

    }

    public static void calculate( double r, double l) {
        double pi = Math.PI; // Set our PI variable

        double area = r * r * pi; // Calculate our area by using the radius and pi
        double volume = area * l; // Calculate our volume by using the area and length

        System.out.println("The area is: " + area);
        System.out.println("The volume is: " + volume);
    }
}