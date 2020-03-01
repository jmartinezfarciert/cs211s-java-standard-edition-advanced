package m3JavaFX;

import java.text.DecimalFormat;
import java.util.Random;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.*;

public class ButtonCount extends Application 
{
	//Instance Data and Controls
	int clickCount;
	String clickCountString;
	String btnText;
	String colorText;
	Button btn;
	Scene scene;
	
	
	@Override
	public void start(Stage primaryStage)
	{
		clickCount = 0;
		btnText = "I've been clicked : " ;
		
		Pane pane = new FlowPane();
		// when a control is loaded it changes the default stylesheet that is loaded in
		// if you want to change the background styling sheet must first 
		//remove the background styling that is happening with the pane
		pane.setStyle("-fx-background-color: null");
		
		// click count to display
		clickCountString = String.valueOf(clickCount);
		
		//Button for clicking
		btn = new Button(btnText);
		btn.setFont(Font.font("Comic Sans", 20.0));
		btn.setText("I've been clicked " + clickCountString + " times");
		btn.setOnAction(this::countClick);
		
		// Add Views and controls to pane for display
		pane.getChildren().add(btn);
		
		scene = new Scene(pane, 400, 130, Color.ALICEBLUE);
		
		primaryStage.setTitle("Click Count");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void countClick(ActionEvent btnClick)
	{
		clickCount++;
		// Change background color to a random background
		double red = Math.random();
		double green = Math.random();
		double blue = Math.random();
		scene.setFill(Color.color(red, green, blue));
		
		//Display changes
		String rgbString = rgbString(red, green, blue);
		colorText = "Viewing Color : " + rgbString;
		clickCountString = String.valueOf(clickCount);
		if(clickCount == 1)
		{
			btn.setText(btnText + clickCountString + " time \n" + colorText);
		}
		else {
			btn.setText(btnText + clickCountString + " times \n" + colorText);
		}
		
	}
	
	private String rgbString(double r, double g, double b)
	{
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(r) + ", " + df.format(g) + ", " + df.format(b) ;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}
	

}
