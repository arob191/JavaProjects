/**
 * Objective: Explore the concept of interfaces
 * Algorithm: Using the Edible interface we will define how classes are supposed to function
 *Input and Output: Input is objects that implement the Edible interface and output will be utilization of the interface method
 * Created by: Austin Robertson
 * Date: 06/26/2024
 * Version: 1
 */


package mod4Lab4;

// Main code to test our interface and classes
public class TestEdible {
	
	public static void main(String[] args) {
		Object[] objects = {new Tiger(), new Chicken(), new Apple()}; // Create an array with our class objects
		for (int i=0; i < objects.length; i++) { // Loop through each object in the array
			if (objects[i] instanceof Edible) { // Test if the object implements the Edible interface
				System.out.println(((Edible)objects[i]).howToEat()); //Print to screen if the object does
			}
		}
	}
}

// Superclass Animals
class Animal {
	
}

// Subclass of Animals and implements the Edible interface
class Chicken extends Animal implements Edible {
	public String howToEat() {
		return "Chicken: Fry it";
	}
}

// Subclass of Animals, does not implement the Edible interface
class Tiger extends Animal {
	
}

// Superclass Fruits that implements the Edible interface so we do not have to specify for subclasses
abstract class Fruit implements Edible {
	
}

// Subclass of the Fruits superclass. Does not need to implement the Edible interface since it is already implied
class Apple extends Fruit {
	public String howToEat() {
		return "Apple: Slice it";
	}
}