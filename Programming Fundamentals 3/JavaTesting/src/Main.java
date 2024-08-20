//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] myArray = {1, 5 , 10, 7, 13, 20};

        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == 13) {
                System.out.println("Found a " + myArray[i] + "!");
            }
        }


    }
}