package m3JavaFX;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class InspirationalQuoteButton extends Application 
{
	//Instance data and controls
	private Button button;
	private Text text;
	private String quote;
	
	String quote1 = "If work causes one to tire inactivity causes one to decay";
	String quote2 = "withdrawing into solitude, our idenity is significantly decontexualized";
	String quote3 = "when you realize there is nothing lacking the whole world belongs to you";
	String quote4 = "the heart that gives gathers";
	
	String[] quoteBank = {quote1, quote2, quote3, quote4};
	private int currentIndex = 0;
	

	@Override
	public void start(Stage primaryStage)
	{
		Pane pane = new FlowPane();
		text = new Text();
		quote = quoteBank[currentIndex];
		text.setText(quoteBank[currentIndex]);
		text.setFont(Font.font("Helvetica", 24.0));
		text.setFill(Color.BLACK);
		pane.getChildren().add(text);
		
		button = new Button("Click me to change quote");
		pane.getChildren().add(button);
		button.setOnAction(this::handleButton);
		
		Scene scene = new Scene(pane , 800, 80);
		scene.setFill(Color.CADETBLUE);
		
		primaryStage.setTitle("Motivational Quote");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	// code here should be executed when user clicks the button
	private void handleButton(ActionEvent event)
	{
		currentIndex = (currentIndex + 1) % quoteBank.length;
		quote = quoteBank[currentIndex];
		text.setText(quote);
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
