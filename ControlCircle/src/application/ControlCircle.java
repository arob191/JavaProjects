package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application{
	
	CirclePane circlePane = new CirclePane();
	
	
	public void start(Stage primaryStage) {
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		Button btEnlarge = new Button("Enlarge");
		Button btShrink = new Button("Shrink");
		hBox.getChildren().add(btEnlarge);
		hBox.getChildren().add(btShrink);
		
		btEnlarge.setOnAction(new EnlargeHandler());
		btShrink.setOnAction(new ShrinkHandler());
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(circlePane);
		borderPane.setBottom(hBox);
		borderPane.setAlignment(hBox, Pos.CENTER);
		
		Scene scene = new Scene(borderPane, 200, 150);
		primaryStage.setTitle("ControlCircle");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	class EnlargeHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			circlePane.enlarge();
		}
	}
	
	class ShrinkHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			circlePane.shrink();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}




class CirclePane extends StackPane {
	private Circle circle = new Circle(50);
	
	public CirclePane() {
		getChildren().add(circle);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
	}
	
	public void enlarge() {
		circle.setRadius(circle.getRadius() +2);
	}
	
	public void shrink() {
		circle.setRadius(circle.getRadius() > 2 ? circle.getRadius() -2 : circle.getRadius()); //This first gets the radius, then checks if it is greater than 2. If it is greater than 2 it will subtract 2. If it is not greater than 2 it will leave the radius alone
	}
	
}