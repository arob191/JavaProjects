package application;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.application.Application;

public class ShowCircleCentered extends Application{
		
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		
		Circle circle  = new Circle();
		
//		The following will center the circle, but if the users adjusts the stage then the circle will not adjust to the center
		circle.setCenterX(100);
		circle.setCenterY(100);

// 		The following code will automatically adjust the circles x,y coordinates to allways be in the center of the pane
		circle.centerXProperty().bind(pane.widthProperty().divide(2));
		circle.centerYProperty().bind(pane.widthProperty().divide(2));
		
		circle.setRadius(50);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		
		pane.getChildren().add(circle);
		
		Scene scene = new Scene(pane, 200,200);
		primaryStage.setTitle("ShowCircleCentered");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}
