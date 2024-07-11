/**
 * Objective: Use JavaFX event source objects and event handlers to allow a user to make basic calculations
 * Algorithm: We first create our event sources objects. When then add the source objects to our scene. Next we create the event handlers that dictate the operation that is performed once an action is initiated.
 *Input and Output: User input will be integers and actions. Output will the result of the desired operation
 * Created by: Austin Robertson
 * Date: 07/10/2024
 * Version: 1
 */


package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {
	
	public void start(Stage primaryStage) {
		FlowPane pane = new FlowPane();
		pane.setHgap(2);
		
		TextField tfNumber1 = new TextField();
		TextField tfNumber2 = new TextField();
		TextField tfResult = new TextField();
		TextField tfSqrt = new TextField();
		
		tfNumber1.setPrefColumnCount(4);
		tfNumber2.setPrefColumnCount(4);
		tfResult.setPrefColumnCount(4);
		tfSqrt.setPrefColumnCount(4);
		
		
		pane.getChildren().addAll(new Label("Number 1:"), tfNumber1,
				new Label("Number 2:"), tfNumber2,
				new Label("Result:"), tfResult, 
				new Label("Square Root:"), tfSqrt);
		
		HBox hBox1 = new HBox(5);
		Button btAdd = new Button("Add");
		Button btSubtract = new Button("Subtract");
		Button btMultiply = new Button("Multiply");
		Button btDivide = new Button("Divide");
		Button btSqrt = new Button("Sqrt");
		
		hBox1.setAlignment(Pos.CENTER);
		hBox1.getChildren().addAll(btAdd, btSubtract, btMultiply, btDivide, btSqrt);
		
		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(pane);
		borderPane.setBottom(hBox1);
		
		Scene scene = new Scene(borderPane, 500, 250);
		primaryStage.setTitle("Simple Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		btAdd.setOnAction(e -> {
			tfResult.setText(Double.parseDouble(tfNumber1.getText()) + Double.parseDouble(tfNumber2.getText()) + "");
		});
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
			try {
				double number = Double.parseDouble(tfSqrt.getText());
				if (number >= 0) {
					double squareRoot = Math.sqrt(number);
					tfResult.setText(squareRoot + "");
				} else {
					tfResult.setText("Cannot be negative");
				}
			} catch (NumberFormatException ex) {
				tfResult.setText("Invalid Input");
			}
		});
		
		

	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}

