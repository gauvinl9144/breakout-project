/**
 * 
 */
package application;

import java.util.Random;

import javafx.application.Application;

import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
	
	private Image bar;
	private ImageView imview;
	
	@Override
	public void start(Stage window) throws Exception {
		this.window = window;
		Font font = new Font("Comic Sans MS", 50);
		Font font2 = new Font("Comic Sans MS", 20);
		Text text = new Text("Breakout");
		Text text2 = new Text("Use Left/Right Arrow keys or A/D to move");
		text.setFont(font);
		text.setFill(Color.BLACK);
		text2.setFont(font2);
		text2.setFill(Color.BLACK);
		
		Button start = new Button("Start");
		start.setFont(font);
		start.setPrefWidth(250);
		start.setPrefHeight(70);
		start.setTooltip(new Tooltip("Starts the game!"));
		start.setOnAction(this::processStartRetry);
		
		VBox startPane = new VBox(text, text2, start);
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
		
		bar = new Image("red.png");
		imview = new ImageView(bar);
		imview.setViewport(new Rectangle2D(0,0,275,25));
		imview.setX(690);
		imview.setY(825);
		imview.setOnKeyPressed(this::processBarMovement);
		
		Group panes = new Group(top,left,right,game,imview);
		inGameScene = new Scene(panes,1650,950,Color.BLACK);
		inGameScene.getWindow();
		window.setScene(inGameScene);
		window.setX(125);
		window.setY(50);
	}
	
	/**
	 * @author RaffelNicholas
	 * This is the start of the Bar movement
	 * @param e
	 */
	public void processBarMovement(KeyEvent e)
	{
		
		if((e.getCode() == KeyCode.ENTER))
		{
			try
			{
				System.out.println("Move left");
			}
			catch(Exception ex)
			{
				System.out.println("Couldnt process scene change");
			}
		}
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
