package m3javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IncDecButton extends Application 
{
	//instance data and controllers
	private Text counterText;
	private Button incButton, decButton;
	private int counter;
	
	public void start(Stage primaryStage)
	{
		// intializing instance data
		counter = 0;
		
		// Vbox for program
		VBox mainVBox = new VBox();
		mainVBox.setStyle("-fx-background-color: aquamarine ");
		mainVBox.setAlignment(Pos.CENTER);
		mainVBox.setSpacing(10);
		
		counterText = new Text("0");
		counterText.setFont(Font.font("Helvetica", 26));
		counterText.setFill(Color.BLACK);
		mainVBox.getChildren().add(counterText);
		
		incButton = new Button(" + ");
		incButton.setOnAction(this::processButtons);
		
		decButton = new Button(" - ");
		decButton.setOnAction(this::processButtons);
		
		//Hbox for buttons
		HBox buttonHBox = new HBox(decButton, incButton); 
		buttonHBox.setStyle("-fx-background-color: cadetBlue");
		buttonHBox.setAlignment(Pos.CENTER);
		buttonHBox.setSpacing(10);
		mainVBox.getChildren().add(buttonHBox);
		
		Scene scene = new Scene(mainVBox, 200, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void processButtons(ActionEvent e)
	{
		// info contained inside ActionEvent object
		if( e.getSource() == incButton)
		{
			counter ++;
		} else 
		{
			counter --;
		}
		counterText.setText(String.valueOf(counter));
	}
	
	public static void main(String args[])
	{
		launch(args);
	}
}
