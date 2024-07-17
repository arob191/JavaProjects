package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TicTacToe extends Application{
	private Cell[][] cell = new Cell[3][3];
	private Label lblStatus = new Label("X's turn to play");
	
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				pane.add(cell[i][i] = new Cell(), j, i);
			}
		}
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
	}
	public static void main(String[] args) {
		
	}

}
