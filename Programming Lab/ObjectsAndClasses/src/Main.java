/**
 * Class: COSC 1173 Programming Lab
 * Name: Austin Robertson
 * Date: 11/10/2024
 * Main function creates our rectangle objects from the Rectangle class
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Create our own two rectangles
        Rectangle rectangle1 = new Rectangle(4, 40);
        Rectangle rectangle2 = new Rectangle(3.5, 35.9);

        //Display our measurements for rectangle 1
        System.out.println("------Measurements for rectangle 1------");
        System.out.println("Width: " + rectangle1.width);
        System.out.println("Length: " + rectangle1.length);
        System.out.println("Area: " + rectangle1.getArea());
        System.out.println("Perimeter: " + rectangle1.getPerimeter());
        //Display measurements for rectangle 2
        System.out.println("------Measurements for rectangle 2------");
        System.out.println("Width: " + rectangle2.width);
        System.out.println("Length: " + rectangle2.length);
        System.out.println("Area: " + rectangle2.getArea());
        System.out.println("Perimeter: " + rectangle2.getPerimeter());


    }
}