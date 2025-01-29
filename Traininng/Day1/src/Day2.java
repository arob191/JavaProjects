import java.util.*;

public class Day2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please provide one word: ");
        String userWord = scanner.nextLine();)

        System.out.println("You typed in: " + userWord);

        String reversedWord = " ";
        for(int i = userWord.length() - 1; i >=0; i--) {
            reversedWord += userWord.charAt(i);
        }

        System.out.println("Your word reversed is:" + reversedWord);
    }
}
