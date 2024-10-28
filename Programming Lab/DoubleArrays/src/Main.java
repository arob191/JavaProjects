public class Main {
    public static void main(String[] args) {
        // 2D arrays, or multidimensional arrays.

        String[][] cars = new String[3][3];

        cars[0][0] = "Camero";
        cars[0][1] = "Corvette";
        cars[0][2] = "Silverado";
        cars[1][0] = "Mustang";
        cars[1][1] = "Ford GT";
        cars[1][2] = "F150";
        cars[2][0] = "Charger";
        cars[2][1] = "Hellcat";
        cars[2][2] = "RAM";

        for(int i = 0; i < cars.length; i++) {
            for(int j = 0; j < cars[i].length; j++) {
                System.out.print(cars[i][j]+ " ");
            }
            System.out.println();
        }
    }
}