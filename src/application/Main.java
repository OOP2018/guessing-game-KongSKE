package application;
	
import java.net.URL;

import guessingGame.VaritGame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		VaritGame varit = new VaritGame(100);
		try {
			URL url = getClass().getResource("GameUI.fxml");
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.load();
			GuessingController controller = loader.getController();
			controller.setGuessingGame(varit);
			
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.setTitle("Result");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		ResultView rv = new ResultView(varit);
		varit.addObserver(rv);
		OwnAnswer ow = new OwnAnswer(varit);
		varit.addObserver(ow);
		ow.run();
		rv.run();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
