public class Main {
    public static void main(String[] args) {

        Car car = new Car("Chevrolet", "Silverado", 1995);

        System.out.println(car.getMake());
        System.out.println(car.getModel());
        System.out.println(car.getYear());

        car.setYear(2025);
        System.out.println(car.getYear());

    }
}
