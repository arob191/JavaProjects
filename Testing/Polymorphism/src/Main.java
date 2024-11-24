import Colors.Test;

public class Main {

    public static void main(String[] args) {
        displayObject(new Circle(1, "red", false));
        displayObject(new Rectangle(1, 1, "back", true));

        Test test = new Test();
    }


    public static void displayObject(GeometricObject object){
        System.out.println("Created on " + object.getDateCreated() + ". Color is " +
                object.getColor());
    }


}