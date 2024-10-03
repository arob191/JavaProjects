import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<A> set = new HashSet<A>();
        set.add(new A());
        set.add(new A());
        set.add(new A());
        set.add(new A());
        System.out.println(set);
    }
}

class A {
    int r = 1;

    public String toString() {
        return r + "";
    }

    public boolean equals(Object o) {
        return this.r == ((A)o).r;
    }

    public int hashCode() {
        return r;
    }
}