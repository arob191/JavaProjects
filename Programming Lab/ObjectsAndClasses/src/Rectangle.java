/**
 * Class: COSC 1173 Programming Lab
 * Name: Austin Robertson
 * Date: 11/10/2024
 * Rectangle class has a default constructor and constructor that creates a rectangle of a specified length and width
 */

public class Rectangle {

    // Initialize our variables
    double width = 0;
    double length = 0;

    //Default constructor creates a rectangle with a width of 5 and length of 5
    Rectangle() {
        width = 5;
        length = 5;
    }

    //Constructor for creating a rectangle with a specified length and width
    Rectangle(double w, double l){
         width = w;
         length = l;
    }

    double getArea() {
        return width * length;
    }

    double getPerimeter() {
        return 2 * width + 2 * length;
    }
}
