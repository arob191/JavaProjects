/**
 Austin Robertson
 COSC 2336-01
 Programming Assignment 7
 Due: 11/22/2024
 Submitted: 11/22/2024
 Use a hash map that utilizes open addressing with linear probing to insert elements
 */

// Will use an array for the hash table and a LinkedList for the bucket
import java.util.Arrays;

//Create our MyMap interface
interface MyMap<K, V> {
    //Initialize our methods
    public void clear();
    public boolean containsKey(K key);
    public boolean containsValue(V value);
    public V get(K key);
    public boolean isEmpty();
    public V put(K key, V value);
    public void remove(K key);
    public int size();
}

class Entry<K, V> {
    /**
     * The Entry Class used to hold the key-value pairs
     *
     * Class Information:
     * - Name: Entry
     * - Dependencies:
     *   - None
     * - Package: Default or specify if part of a package
     * - Inheritance: None
     *
     * Constants and Variables:
     * - Constants: None
     * - Variables:
     *   - key: The key of the key-value pair.
     *   - value: The value of the key-value pair.
     *   - next: Reference to the next entry in the linked list.
     *
     * Constructors:
     * - Entry(K key, V value): Initializes a new entry with the specified key and value.
     */

    K key;
    V value;
    Entry<K, V> next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

// Define the MyHashMap class that implements the MyMap interface
class MyHashMap<K, V> implements MyMap<K, V> {
    /**
     * MyHashMap Class implement the hash table
     *
     * Class Information:
     * - Name: MyHashMap
     * - Dependencies:
     *   - Arrays class for utility methods.
     * - Package: Default or specify if part of a package.
     * - Inheritance: Implements the MyMap interface.
     *
     * Constants and Variables:
     * - Constants:
     *   - INITIAL_CAPACITY: The initial size of the hash table.
     *   - LOAD_FACTOR_THRESHOLD: The threshold for resizing the hash table.
     * - Variables:
     *   - table: Array of linked list buckets to store entries.
     *   - size: The number of elements in the hash table.
     *
     * Constructors:
     * - MyHashMap(): Initializes the hash table
     *
     * Methods:
     * - hash(K key): Computes the hash code for a key
     * - resize(): Resizes the hash table
     * - clear(): Clears the hash table
     * - containsKey(K key): Checks if a key is present in the hash table
     * - containsValue(V value): Checks if a value is present in the hash table
     * - get(K key): Gets the value of the key
     * - isEmpty(): Checks if the hash table is empty
     * - put(K key, V value): Adds a key-value pair to the hash table
     * - remove(K key): Removes the key-value pair
     * - size(): Returns size of hash table
     * - toString(): Returns a string representation of the hash table
     */

    //Initialize our constants
    private static final int INITIAL_CAPACITY = 4;
    private static final double LOAD_FACTOR_THRESHOLD = 0.5;
    //Initialize our Entry array
    private Entry<K, V>[] table;
    // The number of elements in the hash table
    private int size;

    // Default constructor for the MyHashMap class
    public MyHashMap() {
        table = (Entry<K, V>[]) new Entry[INITIAL_CAPACITY]; // Initialize the table
        size = 0;
    }

    // Function to calculate the bucket index
    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length); // Using Math.abs to make sure the result is not a negative int
    }

    // Resize the hash table
    private void resize() {
        if (size > LOAD_FACTOR_THRESHOLD * table.length) {
            Entry<K, V>[] oldTable = table; // Store the old table
            Entry<K, V>[] newTable = (Entry<K, V>[]) new Entry[table.length * 2]; // Create a new table with double the capacity
            table = newTable;
            size = 0; // Reset the size to 0
            for (Entry<K, V> entry : oldTable) { // Rehash all entries in the old table
                while (entry != null) {
                    put(entry.key, entry.value); // Reinsert each entry into the new table
                    entry = entry.next;
                }
            }
        }
    }

    // Clear the hash table
    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    // Check if a key is in the hash table
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    // Check if a value is in the hash table
    public boolean containsValue(V value) {
        for (Entry<K, V> entry : table) { // Iterate through the buckets
            while (entry != null) { // Iterate through the linked list
                if (entry.value.equals(value)) { // Return true if the value is found
                    return true;
                }
                entry = entry.next;
            }
        }
        return false; // Return false if the value is not found
    }

    // Get the value associated with a key
    public V get(K key) {
        int bucketIndex = hash(key); // Calculate the bucket index using the hash function
        Entry<K, V> entry = table[bucketIndex]; // Get the linked list for the bucket
        while (entry != null) { // Iterate through the linked list
            if (entry.key.equals(key)) { // Return the value
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    // Check if the hash table is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Put a key-value pair into the hash table
    public V put(K key, V value) {
        resize(); // Resize the hash table
        int bucketIndex = hash(key);
        Entry<K, V> entry = table[bucketIndex]; // Get the linked list for the bucket
        while (entry != null) { // Iterate through the linked list
            if (entry.key.equals(key)) { // Update the value if the key is found
                V oldValue = entry.value; // Store the old value
                entry.value = value;
                return oldValue;
            }
            entry = entry.next;
        }
        Entry<K, V> newEntry = new Entry<>(key, value); // Create a new entry
        newEntry.next = table[bucketIndex]; // Add the new entry
        table[bucketIndex] = newEntry; // Update the bucket
        size++;
        return null;
    }

    // Remove a key-value pair
    public void remove(K key) {
        int bucketIndex = hash(key);
        Entry<K, V> entry = table[bucketIndex]; // Get the linked list
        Entry<K, V> prev = null; // Set the previous entry
        while (entry != null) { // Iterate through the linked list
            if (entry.key.equals(key)) { // Remove the key-value pair if the key is found
                if (prev == null) { // If it's the first entry in the list
                    table[bucketIndex] = entry.next; // Update the bucket to the next entry
                } else {
                    prev.next = entry.next; // Skip over the removed entry
                }
                size--;
                break;
            }
        }
    }

    // Return the number of elements in the hash table
    public int size() {
        return size;
    }

    // Return a string representation of the hash table
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        for (Entry<K, V> entry : table) {
            while (entry != null) {
                builder.append("[").append(entry.key).append(", ").append(entry.value).append("]");
                entry = entry.next;
            }
        }

        builder.append("]");
        return builder.toString();
    }
}




// Used TestMyHashMap code from Live Example 27.3
public class TestMyHashMapAustinRobertson {
    public static void main(String[] args) {
        // Create a map
        MyMap<String, Integer> map = new MyHashMap<>();
        map.put("Smith", 30); // Add Smith with age 30 to map
        map.put("Anderson", 31);
        map.put("Lewis", 29);
        map.put("Cook", 29);
        map.put("Smith", 65); // Add Smith with age 65 to map

        System.out.println("Entries in map: " + map);

        System.out.println("The age for " + "Lewis is " + map.get("Lewis"));

        System.out.println("Is Smith in the map? " + map.containsKey("Smith"));
        System.out.println("Is age 33 in the map? " + map.containsValue(33));

        map.remove("Smith"); // Remove Smith from map
        System.out.println("Entries in map: " + map);

        map.clear();
        System.out.println("Entries in map: " + map);
    }
}
