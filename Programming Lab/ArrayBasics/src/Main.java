//**********************************
// COSC 1173 Programming Lab
// Name: Austin Robertson
// Date: 10/06/2024
// Understanding Array Basic
//**********************************

import java.util.Scanner;

public class Main {

    //Method for printing our max
    public static void max(int[] array){
        //Initialize our max value
        int max = 0;
        //Compare each index in our array to the max variable
        for (int num : array){
            if (num > max) {
                max = num; //Set the max to the value in the array if it is larger than the current max
            }
        }
        System.out.println("The max is: " + max);
    }

    //Method for printing our min
    public static void min(int[] array){
        //Initialize our min value
        int min = array[0]; // Cannot set min to 0 or else the min will always be 0
        //Compare each index in our array to the min variable
        for (int num : array){
            if (num < min){
                min = num; //Set the min to the value in the array if it is smaller than the current max
            }
        }

        System.out.println("The min is: " + min);
    }

    //Main code
    public static void main(String[] args) {

        //Declare our arrays
        int[] array1 = new int[10];
        int[] array2 = new int[10];

        Scanner scanner = new Scanner(System.in);

        //Ask for input and initialize our array
        System.out.print("Please provide 10 integers: ");
        for (int i = 0; i < array1.length; i++){
            array1[i] = scanner.nextInt();
        }

        //Now we will set array2 to the inverse of array1
        for (int i = 0; i < array2.length; i++){
            array2[i] = array1[array2.length -1 -i];
        }

        //Print out the users array
        for (int num : array1){
            System.out.print(num);
            System.out.print(" ");
        }

        System.out.println(); //Break after printing our initial print array

        //Print our the inverse array
        for (int num : array2){
            System.out.print(num);
            System.out.print(" ");
        }

        System.out.println(); //Break after printing our inverse print array

        //Call our max and min methods
        max(array1);
        min(array1);
    }

}