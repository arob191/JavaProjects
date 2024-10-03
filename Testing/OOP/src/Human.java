public class Human {

    String name;
    int age;
    double weight;

    Human(String name, int age, double weight){ //Main constructor for our human class

        this.name = name; //It is important to use this. to initialize the object's attributes
        this.age = age;
        this.weight = weight;

    }

    void eat(){
        System.out.println(this.name+" is eating"); //Still using this. to access the specific objects attributes
    }

}
