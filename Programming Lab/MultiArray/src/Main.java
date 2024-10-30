/**
 * Class: COSC 1173 Programming Lab
 * Name: Austin Robertson
 * Date: 10/30/2024
 * MultiArray: Initialize an array through user input. Calculate the sum of rows and specified column
 */

import java.util.Scanner;

public class Main {

    //Method accepts multidimensional arrays and returns the sum of the chosen column
    public static double sumColumn(double[][] myArray, int column){
        //Keep track of our total
        double columnTotal = 0;

        //Add the element of the chose column of each row to the columnTotal
        for (int i = 0; i < 3; i++) {
            columnTotal += myArray[i][column];
        }

        return columnTotal;
    }

    //Main code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Initialize our array
        double[][] myArray = new double[3][4];

        //For loop to fill our multidimensional array
        for (int i = 0; i < myArray.length; i++){
            //Ask user for 4 integers for each row
            System.out.print("Enter separate 4 integers: ");
            String input = scanner.nextLine();
            //Split the user input and insert into the string array
            String[] myStringArray = input.split(" ");
            //For each element in the string array parse the string into a double element
            for (int j = 0; j < 4; j++){
                //Parsing the string element to double and inserting into our array
                myArray[i][j] = Double.parseDouble(myStringArray[j]);
            }
        }

        //Break
        System.out.println(" ");

        //For loop to calculate the sum of each row
        for (int i = 0; i < myArray.length; i++){
            //Keep track of our total
            double rowTotal = 0;
            //For each element in the first row add to the rowTotal
            for (int j = 0; j < 4; j++){
                rowTotal += myArray[i][j];
            }
            System.out.println("The sum of row " + (i +1) + " is: " + rowTotal);
        }

        //Break
        System.out.println(" ");

        //Call our sumColumn method for each column
        for (int i = 0; i < 4; i++){
            System.out.println("The sum of column " + (i + 1) + " is: " + sumColumn(myArray, i));
        }

    }
}