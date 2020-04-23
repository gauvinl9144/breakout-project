/**
 * 
 */
package application;

import java.util.Random;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author RaffelNicholas
 *
 */
public class Breakout extends Application {

	private Stage window;
	
	private Scene startScene;
	private Scene inGameScene;
	private Scene endGameScene;
	private int score;
	private int ballCount;
	private int blockCount;
	private Random randomizer;
	
	@Override
	public void start(Stage window) throws Exception {
		this.window = window;
		Font font = new Font("Comic Sans MS", 50);
		Text text = new Text("Breakout");
		text.setFont(font);
		text.setFill(Color.BLACK);
		
		Button start = new Button("Start");
		start.setFont(font);
		start.setPrefWidth(250);
		start.setPrefHeight(70);
		start.setTooltip(new Tooltip("Starts the game!"));
		//start.setOnAction(this::processStartRetry);
		
		VBox startPane = new VBox(text, start);
		startPane.setAlignment(Pos.CENTER);
		startPane.setSpacing(50);
		startPane.setStyle("-fx-background-color: Red");
		
		startScene = new Scene(startPane, 500,500, Color.BLUE);
		window.setScene(startScene);
		window.setTitle("Breakout!");
		window.show();
	}
	
	public void processStartRetry(Event e)
	{
		
	}
	
	public void processEndOfGame(ObservableValue<? extends Number> property, Object oldValue, Object newValue)
	{
		
		
		Button retryTrue = new Button("Yes");
		Font comicSans = new Font("Comic Sans MS", 50);
		retryTrue.setTextFill(Color.BLACK);
		retryTrue.setFont(comicSans);
		Button retryFalse = new Button("No");
		retryFalse.setTextFill(Color.BLACK);
		retryFalse.setFont(comicSans);
		
		Text endScore1 = new Text("Total Score:");
		endScore1.setFont(comicSans);
		endScore1.setFill(Color.WHITE);
		
		Text endScore2 = new Text(Integer.toString(score));
		endScore2.setFont(comicSans);
		endScore2.setFill(Color.WHITE);
		
		Text endScore3 = new Text("Play Again");
		endScore3.setFont(comicSans);
		endScore3.setFill(Color.WHITE);
		
		Text thankYou = new Text("Thanks for playing!");
		thankYou.setFont(comicSans);
		thankYou.setFill(Color.WHITE);
		
		HBox retry = new HBox(retryTrue, retryFalse);
		retry.setAlignment(Pos.CENTER);
		retry.setSpacing(40);
		
		VBox root = new VBox(endScore1, endScore2, endScore3, retry, thankYou);
		root.setAlignment(Pos.CENTER);
		root.setStyle("-fx-background-color: Blue");
		
		Scene endGameScene = new Scene(root, 500, 500, Color.BLUE);
		
		window.setScene(endGameScene);
		
		
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);

	}

}
