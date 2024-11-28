import java.util.ArrayList;
import java.util.Collection;

public class TestCollections {
    public static void main(String[] args) {
        ArrayList<String> collection1 = new ArrayList<>();
        collection1.add("Austin");
        collection1.add("Lilly");
        collection1.add("Casey");
        collection1.add("Saturn");
        collection1.add("Hilda");

        System.out.println("A list of names: ");
        System.out.println(collection1);

        Collection<String> collection2 = new ArrayList<>();
        collection2.addAll(collection1);

        System.out.println(collection2);

    }
}