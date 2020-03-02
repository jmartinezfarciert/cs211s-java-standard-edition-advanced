package m3JavaFX;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/* Author : Johnny Martinez
 * JavaFX high or low number guessing game
 * 
 */
public class HiLoGuessingGame extends Application {
	// instance data variable including controls
	TextField answerTextField;
	int answer;
	int randomNumber;
	Text message;
	Button submit;
	//Thinking of a random number..

	@Override
	public void start(Stage primaryStage)
	{
		//container box
		VBox boxPane = new VBox();
		boxPane.setStyle("-fx-background-color: pink");
		boxPane.setAlignment(Pos.CENTER);
		boxPane.setSpacing(10);
		
		//answer box
		HBox answerBox = new HBox();
		answerBox.setAlignment(Pos.CENTER);
		answerBox.setSpacing(10);
		boxPane.getChildren().add(answerBox);
		
		// Display Text
		message = new Text();
		message.setFont(Font.font("comic sans", 20));
		boxPane.getChildren().add(message);
		
		// TextField for user's answer
		answerTextField = new TextField();
		answerTextField.setMaxWidth(100);
//		answerTextField.setOnAction(this::processAnswer);
		answerBox.getChildren().add(answerTextField);

		
		//Submit Button
		submit = new Button(" Submit ");
		submit.setFont(Font.font("impact", 14));
//		submit.setOnAction(this::processAnswer);
		answerBox.getChildren().add(submit);
		
		// Guessing Game !
		playGame();
		
		
		Scene scene = new Scene(boxPane, 420, 280);
		
		primaryStage.setTitle("Hi-Lo Guessing Game d:^)-/-<|:");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void processAnswer(ActionEvent e)
	{
		String answerString = answerTextField.getText();
		answer = Integer.parseInt(answerString);
		if(answer == randomNumber)
		{
			message.setText("You Guessed it !! press enter to play again");
			submit.setText("Click Here To Play Again :^)");
			submit.setOnAction(this::playAgain);
			answerTextField.setOnAction(this::playAgain);
			answerTextField.clear();
		}
		else if(answer < randomNumber)
		{
			message.setText("not quite... quess a little higher");
			answerTextField.clear();
		}
		else if (answer > randomNumber)
		{
			message.setText("not quite... guess a little lower");
			answerTextField.clear();
		}
	}
	
	private void playAgain(ActionEvent e)
	{
		playGame();
	}
	
	//Controls : The Guessing Game ^_^
	private void playGame()
	{
		randomNumber = (int)Math.round(Math.random()*100);
		submit.setText(" Submit ");
		submit.setOnAction(this::processAnswer);
		answerTextField.setOnAction(this::processAnswer);
		answerTextField.clear();
		message.setText("I'm thinking of a number between 1 and 100."
				+ "\nCan you guess what it is? ");
	}
	public static void main(String[] args) {
		launch(args);
	}

}
