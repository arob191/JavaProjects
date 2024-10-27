import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);

            // Read the number of entries
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline

            // Create a map to store the name and phone number pairs
            Map<String, String> phoneBook = new HashMap<>();

            // Read the entries into the phone book
            for (int i = 0; i < n; i++) {
                String name = scanner.nextLine();
                String phone = scanner.nextLine();
                phoneBook.put(name, phone);
            }

            // Read the query names and produce output
            while (scanner.hasNext()) {
                String query = scanner.nextLine();
                if (phoneBook.containsKey(query)) {
                    System.out.println(query + "=" + phoneBook.get(query));
                } else {
                    System.out.println("Not found");
                }
            }

            scanner.close();
        }
}