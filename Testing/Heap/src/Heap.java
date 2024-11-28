import java.util.Comparator;
import java.util.ArrayList;

public class Heap<E> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();
    private Comparator<? super E> comparator;

    // Create a default heap using a natural order for comparison
    public Heap() {
        this.comparator = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2); ;
    }

    // Constructor with a comparator
    public Heap(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    // Third constructor to create a heap from an array of object
    public Heap(E[] objects) {
        this.comparator = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    public void add(E newObject){
        list.add(newObject); // insert our object
        int currentIndex = list.size() - 1; // The index of the previous node

        while(currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            // Swap the current node with the parent node if the current node is larger
            // Will use the comparator to compare the objects
            if (comparator.compare(list.get(currentIndex), list.get(parentIndex)) > 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            }
            else {
                break; // break if the current index is already smaller than its parent
            }

            currentIndex = parentIndex;
        }
    }

    // remove the root from the heap
    public E remove() {
        if (list.size() == 0) return null;

        E removedObject = list.get(0); // Setting removedObject as the root
        list.set(0, list.get(list.size()-1)); // Set the root as the last element in the heap
        list.remove(list.size() - 1); // Remove the last element from the heap

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex +1; // Set our left child
            int rightChildIndex = 2 * currentIndex +2; // Set our right child

            // Find the max between two children
            if (leftChildIndex < list.size()) break; // The child is in the correct position
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (comparator.compare(list.get(maxIndex), list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex; // The new maxIndex is now the right child
                }
            }

            // now compare the maxIndex to the current index
            if (comparator.compare(list.get(currentIndex), list.get(maxIndex)) < 0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, list.get(maxIndex));
                currentIndex = maxIndex;
            }
            else {
                break;
            }
        }
        return removedObject;
    }

    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size()==0;
    }


    public String toString() {
        return list.toString();
    }
}
