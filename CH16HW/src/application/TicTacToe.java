package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class TicTacToe extends Application{
	private Cell[][] cell = new Cell[3][3];
	private Label lblStatus = new Label("X's turn to play");
	private char whoseTurn = 'X'; // Create an instance to hold whose turn it is
	
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				pane.add(cell[i][i] = new Cell(), j, i);
			}
		}
		cell[0][0].setToken('X'); //Set token
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(lblStatus);
		Scene scene = new Scene(borderPane, 450, 170);
		primaryStage.setTitle("TicTacToe");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public class Cell extends Pane {
		private char token = ' ';
		public Cell() {
			setStyle("-fx-border-color:black");
			this.setPrefSize(800, 800);
		}

		public char getToken() { //Get token method
			return token;
		}
		
		public void setToken(char c) { //Set token method
			token = c;
			
			if (token == 'X') {
				//The following sets the parameters for the X token and binds it to the center of the cell
				Line line1 = new Line(10,10,this.getWidth()-10, this.getHeight()-10);
				line1.endXProperty().bind(this.widthProperty().subtract(10));
				line1.endYProperty().bind(this.heightProperty().subtract(10));
				Line line2 = new Line(10,this.getHeight()-10, this.getWidth()-10, 10);
				line2.startYProperty().bind(this.heightProperty().subtract(10));
				line2.endXProperty().bind(this.widthProperty().subtract(10));
				this.getChildren().addAll(line1,line2);
			}
			else if (token == 'o') {
				
			}
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
