import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Number[] list = {4, 5, 1, 7};

        Heap<Number> myHeap = new Heap<>(list);

        System.out.println(myHeap.getSize());

        System.out.println(myHeap);

        myHeap.add(55);

        System.out.println(myHeap);

    }
}