// Going over intro to java class by Bro Code
import java.util.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.math.*;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
//        System.out.println("\"Hello world!\"");
//        System.out.println("\tHello world!");
//        System.out.println("\\Hello World!");
//        System.out.println("What is your favorite pizza?: ");
//
//        //intialization
//        int x = 123;
//        double y = 3.14; // Doubles will be more precise than floats
//        boolean True = false; // Not a smart way to initialize a boolean
//        char symbol = '@'; // Need to use single quotes
//
//        System.out.println("my number is: " + x);
//
//        //Swapping variables
//        String z = "Water";
//        String w = "Hotsauce";
//        String temp;
//
//        temp = z;
//        z = w;
//        w = temp;
//
//        System.out.println(z);
//        System.out.println(w);
//
//        // Using a scanner
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("What is your name? ");
//        String name = input.nextLine();
//
//        System.out.println("How old are you? ");
//        Double age = input.nextDouble();
//        input.nextLine();
//
//        System.out.println("What is your favorite food? ");
//        String food = input.nextLine();
//
//        // Expressions and Casting
//        int numb = 10;
//        System.out.println((double) numb /3); // Cast int variable to double variable to precise division
//
//        // Using GUI through the JOptionPane class
//        String name = JOptionPane.showInputDialog("Enter your name");
//        JOptionPane.showMessageDialog(null, "Hello " + name);
//
//        // Use Integer wrapper class and parse the string to int
//        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
//        JOptionPane.showMessageDialog(null, "You are " + age + " years old");
//
//        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height"));
//        JOptionPane.showMessageDialog(null, "You are " + height + "cm tall");
//
//        // Using the Math class
//        double x;
//        double y;
//        double z;
//
//        Scanner input = new Scanner(System.in);
//
//        System.out.print("Enter side x: ");
//        x = input.nextDouble();
//        System.out.print("Enter side y: ");
//        y = input.nextDouble();
//
//        z = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
//
//        System.out.println("The hypotenuse is: " + z);
//
//        input.close();
//
//        // Generate some random values (psuedo random code)
//        Random random = new Random();
//
//        int x = random.nextInt(6)+1;
//        double y = random.nextDouble();
//        boolean z = random.nextBoolean();
//
//        System.out.println(z);
//
//        // If statements
//
//        int age = 76;
//
//        if(age >= 18 && age <= 75){
//            System.out.println("You are an adult!");
//        } else if (age > 75) {
//            System.out.println("You are a senior!");
//        } else {
//            System.out.println("You are not an adult!");
//        }
//        //Switches
//
//        String day = "Friday";
//
//        switch(day) {
//            case "Sunday": System.out.println("It is Sunday!");
//            break;
//            case "Monday": System.out.println("It is Monday!");
//            break;
//            case "Tuesday": System.out.println("It is Tuesday!");
//            break;
//            case "Wednesday": System.out.println("It is Wednesday!");
//            break;
//            default: System.out.println("That is not a day!");
//        }
//
//        //While Loops
//        Scanner scanner = new Scanner(System.in);
//        String name = "";
//
//        while(name.isBlank()){
//            System.out.print("Please provide your name: ");
//            name = scanner.nextLine();
//        }
//        // Do loop is useful is we need to check our condition after our code.
//        do{
//            System.out.print("What is your name? ");
//            name = scanner.nextLine();
//        }while(name.isBlank());
//
//        // For loops
//        int rows;
//        int columns;
//        String symbol = " ";
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("How many rows?");
//        rows = scanner.nextInt();
//        System.out.print("How many colums?");
//        columns = scanner.nextInt();
//        scanner.nextLine();
//        System.out.print("What character would you like to use?");
//        symbol = scanner.nextLine();
//
//        for(int i = 0; i < rows; i++) {
//            for(int j = 0; j < columns; j++){
//                System.out.print(symbol);
//            }
//            System.out.println();
//        }
//        // Arrays
//        String[] cars = {"Camaro", "BMW", "Mercedes"};
//        //Secodary way to initialize an array
//        String[] trucks = new String[3];
//
//        trucks[0] = "Ram";
//        trucks[1] = "Chevy";
//        trucks[2] = "Ford";
//
//        for(int i = 0; i < trucks.length; i++){
//            System.out.println(trucks[i]);
//        }
//
//        // 2D arrays rows then columns
//        String[][] cars = new String[3][3];
//        cars[0][0] = "Camaro";
//        cars[0][1] = "Silverado";
//        cars[0][2] = "Corvette";
//
//        cars[1][0] = "Ram";
//        cars[1][1] = "Challenger";
//        cars[1][2] = "Viper";
//
//        cars[2][0] = "mustang";
//        cars[2][1] = "GT";
//        cars[2][2] = "f150";
//
//        for(int i=0; i < cars.length; i++) {
//            System.out.println();
//            for(int j=0; j<cars[i].length; j++){
//                System.out.print(cars[i][j] + " ");
//            }
//        }
//
//        // String = a reference data type
//        // Using methods for reference data types
//        String name = "    Austin      ";
//
//        Boolean nameResult = name.equals("Austin");
//        System.out.println(nameResult);
//
//        int nameLength = name.length();
//        System.out.println(nameLength);
//
//        char nameChar = name.charAt(4);
//        System.out.println(nameChar);
//
//        int nameIndex = name.indexOf("u");
//        System.out.println(nameIndex);
//
//        boolean nameEmpty = name.isEmpty();
//        System.out.println(nameEmpty);
//
//        String nameTrim = name.trim();
//        System.out.println(nameTrim);

//        Wrapper class = provides a way to use primitive data types as reference data types
//                        reference data types contain useful methods
//                        can be used with collections (ex. arrayList)
//
//        Primitive        Wrapper
//        ---------        -------
//        boolean           Boolean
//        char              Character
//        int               Integer
//        double            Double

//        autoboxing = the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper class
//        unboxing = the reverse of autoboxing
//        Boolean a = true;
//        Character b = '@';
//        Integer c = 123;
//        Double d = 2.14;
//        String e = "Austin";
//
//        if(a==true){
//            System.out.println("This is true");
//        }
//
//        //ArrayList = a resizable array. Only stores reference data type. Need to use wrapper class if need to restore anything else
//
//        ArrayList<String> food = new ArrayList<String>();
//
//        food.add("pizza");
//        food.add("hamburger");
//        food.add("hotdog");
//
//        //Change string at index 0 to sushi
//        food.set(0, "sushi");
//        //Remove food at index 2
//        food.remove(2);
//        //Clear the arraylist
//        food.clear();
//
//        for(int i=0; i<food.size(); i++) {
//            System.out.println(food.get(i));
//        }
//
//        //2D ArrayList = a dynamic list of list
//        // Lists size can be changed during runtime
//
//        ArrayList<ArrayList<String>> groceryList = new ArrayList<>();
//
//        ArrayList<String> bakeryList = new ArrayList<>();
//        bakeryList.add("Cake");
//        bakeryList.add("Garlic Bread");
//        bakeryList.add("Pasta");
//
//        ArrayList<String> produceList = new ArrayList<>();
//        produceList.add("Chicken");
//        produceList.add("Bread");
//        produceList.add("Tomatoes");
//
//        ArrayList<String> drinkList = new ArrayList<>();
//        drinkList.add("Soda");
//        drinkList.add("Wine");
//
//        groceryList.add(bakeryList);
//        groceryList.add(produceList);
//        groceryList.add(drinkList);
//
//        System.out.println(groceryList.get(1).get(2));
//
//        //for-each loops = Iterate through elements in an array/collection. Less steps, more readable, less flexible
//        String[] animals = {"Cat", "Dog", "Bird", "Horse"};
//        for(String i : animals) {
//            System.out.println(i);
//        }
//
//        ArrayList<String> moreAnimals = new ArrayList<String>();
//        moreAnimals.add("Crow");
//        moreAnimals.add("Cow");
//        moreAnimals.add("Pig");
//
//        for(String i : moreAnimals) {
//            System.out.println(i);
//        }
//
//        // printf() = an optional method to control, format and display text
//        //two arguments = format string + (object/variable/value)
//        // % [flags] [precision] [width] [conversion-character]
//        System.out.printf("This is a format string %d", 123);
//        System.out.printf("%d This is a format string", 123);
//
//        boolean result = true;
//        char myChar = '@';
//        String myString = "Austin";
//        int myInt = 50;
//        double myDouble = 1000;
//
//        //Changing the conversion-character depending on the datatype
//        System.out.printf("%b", result);
//        System.out.printf("%c", myChar);
//        System.out.printf("%s", myString);
//        System.out.printf("%d", myInt);
//        System.out.printf("%f", myDouble);
//        System.out.println();
//
//        //Changing the width between the displayed value
//        System.out.printf("Hello %10s", myString);
//        System.out.println();
//
//
//        //Changing the precision
//        System.out.printf("You have %.2f dollars", myDouble);
//        System.out.println();
//
//        //Flags will add effects
//        // - : left-justify
//        // + : output a plus or minus sign for a numeric value
//        // 0 : numeric values are zero-padded
//        // , : comma grouping separator if numbers > 1000
//        System.out.printf("You have %+,.2f dollars", myDouble);


    }
}