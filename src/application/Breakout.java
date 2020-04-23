/**
 * 
 */
package application;

import java.util.Random;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
		this.window= window;
		Font font = new Font("Comic Sans MS", 50);
		Text text = new Text("Breakout");
		text.setFont(font);
		text.setFill(Color.BLACK);
		
		Button start = new Button("Start");
		start.setFont(font);
		start.setPrefWidth(250);
		start.setPrefHeight(70);
		start.setTooltip(new Tooltip("Starts the game!"));
		start.setOnAction(this::processStartRetry);
		
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
		
		Font scoreFont = Font.font("Comic Sans MS",FontWeight.BOLD,35);
		
		FlowPane game = new FlowPane();
		game.setAlignment(Pos.CENTER);
		game.setStyle("-fx-background-color: Black");
		
		Text scoreTxt = new Text(200,200,"Score: ");
		scoreTxt.setFont(scoreFont);
		scoreTxt.setFill(Color.WHITE);
		Text ballCnt = new Text(200,200,"Balls: ");
		ballCnt.setFont(scoreFont);
		ballCnt.setFill(Color.WHITE);
		
		StackPane topPane = new StackPane();
		topPane.setStyle("-fx-background-color: Grey");
		topPane.setPadding(new Insets(0,1650,100,0));
		topPane.getChildren().addAll(scoreTxt,ballCnt);
		scoreTxt.setTranslateX(150);
		scoreTxt.setTranslateY(90);
		ballCnt.setTranslateX(1200);
		ballCnt.setTranslateY(90);
		VBox top = new VBox(topPane);
		
		FlowPane leftPane = new FlowPane();
		leftPane.setStyle("-fx-background-color: Grey");
		leftPane.setPadding(new Insets(0,-250,950,0));
		VBox left = new VBox(leftPane);
		
		FlowPane rightPane = new FlowPane();
		rightPane.setStyle("-fx-background-color: Grey");
		rightPane.setPadding(new Insets(0,-250,950,0));
		rightPane.setTranslateX(1500);
		VBox right = new VBox(rightPane);
		
		Group panes = new Group(top,left,right,game);
		inGameScene = new Scene(panes,1650,950,Color.BLACK);
		inGameScene.getWindow();
		window.setScene(inGameScene);
		window.setX(125);
		window.setY(50);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);

	}

}
