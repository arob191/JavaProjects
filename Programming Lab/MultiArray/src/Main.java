import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] myArray = new int[3][4];

        for (int i = 0; i < myArray.length; i++){
            System.out.println("Enter 4 integers: ");
            String input = scanner.nextLine();
            String[] myStringArray = input.split(" ");
            for (int j = 0; j < 4; j++){
                myArray[i][j] = Integer.parseInt(myStringArray[j]);
            }
        }

        for (int i = 0; i < myArray.length; i++){
            for (int j = 0; j < 4; j++){
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println(" ");
        }

    }
}