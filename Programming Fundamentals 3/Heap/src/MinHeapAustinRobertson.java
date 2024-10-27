/**
 Austin Robertson
 COSC 2336-01
 Programming Assignment 6
 Due: 10/23/2024
 Submitted: 10/23/2024
Use a min-heap structure to sort int arrays and string arrays
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The MinHeap class is used to maintain a min-heap structure to sort our arrays.
 *
 * Class Information:
 * - Name: MinHeap
 * - Dependencies:
 *   - java.util.ArrayList
 *   - java.util.Arrays
 * - Package: None
 * - Inheritance: None
 *
 * Purpose:
 * - To build and maintain a min-heap structure for efficient sorting and element removal.
 *
 * Constants and Variables:
 * - Constants: None
 * - Variables:
 *   - ArrayList<T> heap: Holds the elements of the heap.
 *
 * Constructors:
 * - MinHeap(T[] array):
 *   - Initializes the heap using an array and builds the min-heap.
 */

class MinHeap<T extends Comparable<T>> {
    private ArrayList<T> heap; //Declare our array list

    //Constructor to initialize the heap with the array
    public MinHeap(T[] array) {
        heap = new ArrayList<>(Arrays.asList(array)); //cast our array to arraylist
        buildMinHeap(); //Call our build mini heap method
    }

    //Method to get the size of the heap
    public int getSize() {
        return heap.size();
    }

    //Method to remove and then return the min element
    public T remove() {
        T min = heap.get(0); //Get the min element
        T lastItem = heap.remove(heap.size() - 1); //Remove the last element
        //Replace the min element with the last element then call our restore heap method
        if (heap.size() > 0) {
            heap.set(0, lastItem);
            minHeapify(0);
        }
        return min; //Return the min method
    }

    //Method to build our min-heap
    private void buildMinHeap() {
        //Call our restore heap method for all non-leaf nodes.
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            minHeapify(i);
        }
    }

    //This is our restore heap method
    private void minHeapify(int i) {
        int left = 2 * i + 1; //Initialize the index of the left child
        int right = 2 * i + 2; //Initialize the index of the right child
        int smallest = i; //Initialize the smallest as the root

        //Set the smallest element as the root
        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left; //Check left
        }

        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right; //Check right
        }

        //Recursive call our method if the smallest is not the root.
        if (smallest != i) {
            T temp = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, temp);
            minHeapify(smallest);
        }
    }
}

/**
 * The Main class is used for passing our arrays to our Heap structure and testing its functionality
 *
 * Class Information:
 * - Name: Main
 * - Dependencies:
 *   - java.util.Arrays
 * - Package:
 *   - None
 * - Inheritance:
 *   - None
 *
 * Purpose:
 * - Run the main code
 *
 * Constants and Variables:
 * - Constants: None
 * - Variables: None
 *
 * Constructors:
 * - None
 */

public class MinHeapAustinRobertson {

    public static void main(String[] args) {
        /** test with Integers */
        Integer[] myIntegers = {8, 9, 2, 3, 4, 1, 5, 6, 7};
        System.out.println("Unsorted Integers in the array: ");
        for (int i = 0; i < myIntegers.length; i++)
            System.out.print(myIntegers[i] + " ");
        System.out.println();
        MinHeap<Integer> heap = new MinHeap<Integer>(myIntegers);
        System.out.println("Sorted Integers: ");
        while (heap.getSize() > 0)
            System.out.print(heap.remove() + " ");
        System.out.println();

        /** test with Strings */
        String[] myStrings = {"Computer ", "Science ", "Rocks "};
        System.out.println("Unsorted Strings in the array: ");
        for (int i = 0; i < myStrings.length; i++)
            System.out.print(myStrings[i]);
        System.out.println();
        System.out.println("Sorted Strings: ");
        MinHeap<String> stringHeap = new MinHeap<String>(myStrings);
        while (stringHeap.getSize() > 0)
            System.out.print(stringHeap.remove());
    }

}