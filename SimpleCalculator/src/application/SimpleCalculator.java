/**
 * Objective: Use JavaFX event source objects and event handlers to allow a user to make basic calculations
 * Algorithm: We first create our event sources objects. When then add the source objects to our scene. Next we create the event handlers that dictate the operation that is performed once an action is initiated.
 *Input and Output: User input will be integers and actions. Output will the result of the desired operation
 * Created by: Austin Robertson
 * Date: 07/10/2024
 * Version: 1
 */


package application;

import javafx.application.Application; //Importing needed packages
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

//Create our main class that will extend the Application superclass
public class SimpleCalculator extends Application {
	
	//Create our start method needed for classes that extend Application
	public void start(Stage primaryStage) {
		FlowPane pane = new FlowPane(); //Created our flowpane object
		pane.setHgap(2);
		
		//Create our text fields for user input and the result output
		TextField tfNumber1 = new TextField();
		TextField tfNumber2 = new TextField();
		TextField tfResult = new TextField();
		TextField tfSqrt = new TextField();
		
		//Set the column for each of our event source objects
		tfNumber1.setPrefColumnCount(4);
		tfNumber2.setPrefColumnCount(4);
		tfResult.setPrefColumnCount(4);
		tfSqrt.setPrefColumnCount(4);
		
		//Grabbed the children list from the flowpane and added the event source objects
		pane.getChildren().addAll(new Label("Number 1:"), tfNumber1,
				new Label("Number 2:"), tfNumber2,
				new Label("Result:"), tfResult, 
				new Label("Square Root:"), tfSqrt);
		
		HBox hBox1 = new HBox(5); //Created an HBox to add our buttons to
		
		//Created more event source objects for the user to select the math operation
		Button btAdd = new Button("Add");
		Button btSubtract = new Button("Subtract");
		Button btMultiply = new Button("Multiply");
		Button btDivide = new Button("Divide");
		Button btSqrt = new Button("Sqrt");
		
		//Align the HBox and grab the children list and add our buttons
		hBox1.setAlignment(Pos.CENTER);
		hBox1.getChildren().addAll(btAdd, btSubtract, btMultiply, btDivide, btSqrt);
		
		//Create a border pane and add our flowpane and Hbox
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(pane);
		borderPane.setBottom(hBox1);
		
		//Created a scene and added our boarder pane.
		Scene scene = new Scene(borderPane, 500, 250);
		primaryStage.setTitle("Simple Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		//Created our event handlers for each math operations and add the results to the results text event source object
		btAdd.setOnAction(e -> {
			tfResult.setText(Double.parseDouble(tfNumber1.getText()) + Double.parseDouble(tfNumber2.getText()) + "");
		}); //We first get the string from both number inputs then parse the string to doubles then set the text for the result text box
		btSubtract.setOnAction(e -> {
			tfResult.setText(Double.parseDouble(tfNumber1.getText()) - Double.parseDouble(tfNumber2.getText()) + "");
		});
		btMultiply.setOnAction(e -> {
			tfResult.setText(Double.parseDouble(tfNumber1.getText()) * Double.parseDouble(tfNumber2.getText()) + "");
		});
		btDivide.setOnAction(e -> {
			tfResult.setText(Double.parseDouble(tfNumber1.getText()) / Double.parseDouble(tfNumber2.getText()) + "");
		});
		btSqrt.setOnAction(e -> {
			try { //First we will text to see if the input is greater than 0
				double number = Double.parseDouble(tfSqrt.getText()); //Parsed the input from string to a double
				if (number >= 0) {
					double squareRoot = Math.sqrt(number); //Used the sqrt function to find the square root of the input
					tfResult.setText(squareRoot + ""); //Set the result text box to the squareRoot
				} else {
					tfResult.setText("Cannot be negative"); //Set the text in case the user put in a negative number
				}
			} catch (NumberFormatException ex) {
				tfResult.setText("Invalid Input"); //Throw invalid input exception in case user input is invalid
			}
		});
		
		

	}
	
	//Main method to launch application
	public static void main(String[] args) {
		launch(args);
	}

}

