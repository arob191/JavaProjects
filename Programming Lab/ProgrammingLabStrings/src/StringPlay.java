//**********************************
// COSC 1173 Programming Lab
// Name: Austin Robertson
// Date: 09/20/2024
// Robertson - Assignment 3: Program
//**********************************

// Main class
public class StringPlay
{
    // Main method
    public static void main (String[] args)
    {
        // Set variables
        String college = new String ("PoDunk College");
        String town = new String("Anytown, USA");
        int stringLength;
        String change1, change2, change3;
        stringLength = college.length();

        // Print new line
        System.out.println (college + " contains " + stringLength +
                " characters.");

        // Set change variable
        change1 = college.toUpperCase();
        change2 = change1.replace("O", "*");
        change3 = college + " " + town;

        // Print final line
        System.out.println ("The final string is " + change3);
    }
}
