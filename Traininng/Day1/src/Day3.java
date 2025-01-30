public class Day3 {
    // Going to be doing a variable swap
    public static void main(String[] args){
        // Our precondition will be P(a, b)
        // Our postcondition will be P(b, a)
        String x = "a";
        String y = "b";
        System.out.println("y equals: " + y + " x equals: " + x);

        String temp = " ";
        temp = y;
        y = x;
        x = temp;
        System.out.print("y equals: " + y + " x equals: " + x);
    }
}
