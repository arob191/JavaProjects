// Going over Methods

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String name = "Austin";
        int age = 25;
        hello(name, age);
        int x = 4;
        int y = 10;
        int z = 22;
        System.out.println(add(x, y));
        System.out.println(add(x, y, z));
    }

    //Method that does not return anything
    static void hello(String name, int age) {
        System.out.println("Hello again " + name);
         System.out.println("You are " + age + " years old");
    }

    //Method that returns a value
    static int add(int x, int y) {
        int result = x + y;
        return result;
    }

    //Overloaded method = methods that share the same name but have different parameters
    // method name + parameters = method signature
    static int add(int x, int y, int z){
        int result = x + y + z;
        return result;
    }

}