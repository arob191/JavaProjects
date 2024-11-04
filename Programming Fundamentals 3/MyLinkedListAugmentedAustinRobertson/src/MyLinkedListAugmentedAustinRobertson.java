import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MyLinkedListAugmentedAustinRobertson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Initialize our stack
        MyLinkedListExtra<String> stack = new MyLinkedListExtra<>();

        //Create a string array with our elements
        String[] names = {"Jane","Kathy","Jenny","Ella","Jane","George",
                          "Cheryl","Stevie","George","Alice","Jim","Mike"};

        //Add the elements in our string array to our stack
        stack.addAll(names);

        //Print the elements in our stack
        System.out.println(stack);

        //Ask the user for a name to add to the stack
        System.out.print("Enter a name: ");
        String name = scanner.nextLine();
        System.out.print("Enter an index at which to store the name: ");
        int index = scanner.nextInt();
        stack.set(index, name);

        //Print revised list:
        System.out.println(stack);

        //Call our contains method for the user inputted name
        System.out.println("List contains " + name + ": " + stack.contains(name));

        //Call our index of method
        System.out.println("Item at index " + index + ": " + stack.getElement(index));

        //Call our index and last index of for George
        System.out.println("Index of George: " + stack.getIndex("George"));
        System.out.println("Last Index of George: " + stack.lastIndex("George"));
    }
}

class GenericStack<E> {
    private LinkedList<E> list = new LinkedList<>();

    public void push(E item) {
        list.addFirst(item);
    }

    public E pop() {
        return list.removeFirst();
    }

    public int getSize() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    //Additional Methods

    //Contains method returns true or false
    public boolean contains(E item) {
        return list.contains(item);
    }

    //Get method returns the index of the element
    public int getIndex(E item) {
        return list.indexOf(item);
    }

    //Method that gets the element at the specified index
    public E getElement(int index){
        return list.get(index);
    }

    //Method returns the last occurrence index of the specified element
    public int lastIndex(E item) {
        return list.lastIndexOf(item);
    }

    //Set method inserts the element into the desired index and shifts the rest of the elements down
    public void set(int index, E item) {
        list.add(index, item);
    }

    //Method to push all of our items in our string array to our stack
    public void addAll(E[] items){
        Arrays.asList(items).forEach(this::push); //Now we don't have to manually add each element
    }
}

//MyLinkedListExtra class that extends our GenericStack class
class MyLinkedListExtra<E> extends GenericStack<E> {
    @Override
    public void push(E item) {
        super.push(item);
    }

    @Override
    public E pop() {
        E item = super.pop();
        return item;
    }

    @Override
    public boolean contains(E item) {
        return super.contains(item);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
