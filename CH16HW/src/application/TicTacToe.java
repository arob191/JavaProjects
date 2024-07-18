/**
 * Objective: Use JavaFX to recreate the TicTacToe game
 * Algorithm: We will use token to keep track of which users turn it is in the game. The game ends if either the 'X' or 'O' token gets 3 in a row or all the cells are filled
 *Input and Output: User input clicks. Output will be the cell being populated by the user token
 * Created by: Austin Robertson
 * Date: 07/16/2024
 * Version: 1
 */

package application;

//Import our classes
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;


public class TicTacToe extends Application{
	private Cell[][] cell = new Cell[3][3];
	private Label lblStatus = new Label("X's turn to play");
	private char whoseTurn = 'X'; // Create an instance to hold whose turn it is
	
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane(); //Create our 9 x 9 grid for the game
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				pane.add(cell[i][j] = new Cell(), j, i);
			}
		}

		BorderPane borderPane = new BorderPane(); // Create our borderpane
		borderPane.setCenter(pane); // Add our pane to the borderpane
		borderPane.setBottom(lblStatus);
		Scene scene = new Scene(borderPane, 450, 170); // Create our scene and add our borderpane
		primaryStage.setTitle("TicTacToe");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public class Cell extends Pane {//Cell class created to handle mouse click events
		private char token = ' ';
		public Cell() {
			setStyle("-fx-border-color:black");
			this.setPrefSize(800, 800);
			this.setOnMouseClicked(e->handleMouseClick());
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
			else if (token == 'O') {
				//The following sets the parameters for the O token and binds it to the center of the cell
				Ellipse ellipse = new Ellipse(this.getWidth()/2-10, this.getHeight()/2, this.getWidth()/2-10, this.getHeight()/2-10);
				ellipse.centerXProperty().bind(this.widthProperty().divide(2));
				ellipse.centerYProperty().bind(this.heightProperty().divide(2));
				ellipse.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));
				ellipse.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));
				ellipse.setStroke(Color.BLACK);
				ellipse.setFill(Color.WHITE);
				this.getChildren().add(ellipse);
				
			}
		}
		
		public boolean isFull() { //Method to check if all cells are full in case of scratched game
			for (int i =0; i < 3; i++)
				for (int j = 0; j < 3; j++)
					if (cell[i][j].getToken() == ' ')
						return false;
			return true;
		}
		
		public boolean isWon(char token) { //Method to set the game condition. 
			for (int i = 0; i < 3; i++) //Checking if there is 3 in a row
				if (cell[i][0].getToken() == token
				&& cell[i][1].getToken() == token
				&& cell[i][2].getToken() == token)
				{
					return true;
				}
			for (int j = 0; j < 3; j++) //Checking if there is 3 in a column
				if (cell[0][j].getToken() == token
				&& cell[1][j].getToken() == token
				&& cell[2][j].getToken() == token)
				{
					return true;
				}
			if (cell[0][0].getToken() == token //Checking if there is 3 in a diagonal
					&& cell[1][1].getToken() == token
					&& cell[2][2].getToken() == token) {
				return true;
			}
			if (cell[0][2].getToken() == token //Checking if there is 3 in a diagonal
					&& cell[1][1].getToken() == token
					&& cell[2][0].getToken() == token) {
				return true;
			}
			return false; //Return false is no one has won yet
		}
		private void handleMouseClick() { //handMouseClick method to check if the cell is empty. If the cell is empty we check whose turn it is and then add the token
			if (token == ' ' && whoseTurn != ' ') {
				setToken(whoseTurn); 
				if (isWon(whoseTurn)) { //Checking our is won flag
					lblStatus.setText(whoseTurn + " won! The game is over!");
					whoseTurn = ' ';
				}
				else if (isFull()) {
					lblStatus.setText("Draw! The game is over");//End game if all cells are full
					whoseTurn = ' ';
				}
				else {
					whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';	
					lblStatus.setText(whoseTurn + "'s turn"); //If game has not ended let the player's know who's turn it is
				}
			}
			
		}
	}
	public static void main(String[] args) {
		launch(args);
	}

}
