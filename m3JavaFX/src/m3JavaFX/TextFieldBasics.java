package m3JavaFX;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.stage.*;


public class FXShell extends Application {
	// instance data variable (including controls)
	
	@Override
	public void start(Stage primaryStage)
	{
		Group root = new Group();
		
		Scene scene = new Scene(root, 300, 300, Color.BEIGE);
		
		primaryStage.setTitle("TITLE");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
