import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input a temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = conversion(celsius);
        System.out.println(celsius + " degrees Celsius is equal to " + fahrenheit + " degrees Fahrenheit");


    }

    public static double conversion(double celsius){
        return ((double) 9 /5) * celsius + 32;
    }

}