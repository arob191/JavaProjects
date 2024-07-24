/**
 * Objective: Create a bar chart using JavaFX
 * Algorithm: Creat rectangle objects to visual data, add the rectangles to the pane that will be displayed in the scene
 *Input and Output: Input will be data, output will be the visualization of the data
 * Created by: Austin Robertson
 * Date: 07/04/2024
 * Version: 1
 */


package application;

// Importing needed classes
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


//We will be using the Application parent class
public class BarChart extends Application{

	public void start(Stage primaryStage) { //Need to add the start method which also creates our primary stage
		
		Pane pane = new Pane(); // Create our pane object that will hold our rectangles
		
		// Create variables to be used to define our rectangles height and our pane's height
		double height = 300;
		double paneHeight = 150;
		
		// Create 4 rectangles. Each of them vary in height, and they are evenly spaced horizontally
		Rectangle r1 = new Rectangle(10, paneHeight - height * 0.2, 100, height * 0.2); //Create the rectangle object and set the height and position
		r1.setFill(Color.RED); //Set the color of the rectangle
		Text text1 = new Text(10, paneHeight - height * 0.2 - 10, "Project -- 20%"); //Create a label for the rectangle and position it directly over the rectanlge
		
		Rectangle r2 = new Rectangle(10 + 110, paneHeight - height * 0.1, 100, height * 0.1);
		r2.setFill(Color.BLUE);
		Text text2 = new Text(10 + 110, paneHeight - height * 0.1 - 10, "Quiz -- 10%");
		
		Rectangle r3 = new Rectangle(10 + 220, paneHeight - height * 0.3, 100, height * 0.3);
		r3.setFill(Color.GREEN);
		Text text3 = new Text(10 + 220, paneHeight - height * 0.3 - 10, "Midterm -- 30%");
		
		Rectangle r4 = new Rectangle(10 + 330, paneHeight - height * 0.4, 100, height * 0.4);
		r4.setFill(Color.ORANGE);
		Text text4 = new Text(10 + 330, paneHeight - height * 0.4 - 10, "Final -- 40%");
		
		pane.getChildren().addAll(r1, text1, r2, text2, r3, text3, r4, text4); //Grab the children list for the pane object and add the rectangles to the pane
		
		Scene scene = new Scene(pane, 500, paneHeight); //Create our scene object and pass our pane object
		primaryStage.setTitle("Bar Chart"); //Set the title for our scene
		primaryStage.setScene(scene); //Set the scene for our stage
		primaryStage.show(); //Display our stage
		
	}
	
	//Method to launch our stage
	public static void main(String[] args) {
		launch(args);
	}
	
}
