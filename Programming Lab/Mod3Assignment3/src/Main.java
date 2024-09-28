//**********************************
// COSC 1173 Programming Lab
// Name: Austin Robertson
// Date: 09/13/2024
// Robertson - Assignment 3: Program to determine the total cost of shipping plus the price of an item.
//**********************************

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to input the weight then the cost of the package
        System.out.print("Enter the weight of the package (in pounds): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter the price of the product (in dollars): ");
        double price = scanner.nextDouble();

        // Check to make sure that the price and weight are not negative
        if (weight < 0 || price < 0) {
            System.out.println("The weight/price cannot be negative.");
            return;
        }

        // Using if else statements find the cost of the shipping
        double shippingCost;
        if (weight > 20) {
            System.out.println("The package cannot be shipped (weight exceeds 20 pounds).");
            return;
        } else if (weight <= 1) {
            shippingCost = 3.5;
        } else if (weight <= 3) {
            shippingCost = 5.5;
        } else if (weight <= 10) {
            shippingCost = 8.5;
        } else {
            shippingCost = 10.5;
        }

        // Add the price and the shipping cost
        double totalBill = price + shippingCost;

        // Display results
        System.out.println("Shipping cost: $" + shippingCost);
        System.out.println("Total bill: $" + totalBill);
    }
}