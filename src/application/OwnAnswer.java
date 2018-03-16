package application;

import java.util.Observable;

import guessingGame.VaritGame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OwnAnswer implements java.util.Observer{
	private Stage stage;
	private VaritGame varit;
	private Label label;
	private int lastGuess;
	
	public OwnAnswer(VaritGame varit) {
		this.varit = varit;
		initComponent();
	}
	
	public void initComponent() {
		stage = new Stage();
		// components and containers for our window
		HBox root = new HBox();
		//TODO Set some padding around the HBox
		root.setPadding(new Insets(10));
		//TODO Align components in center of the HBox
		root.setAlignment(Pos.CENTER);
		// The label that will show the counter value.
		label = new Label("Count");
		// make the label big enough
		label.setPrefWidth(144);
		//TODO Make the text BIG. Use setFont to create a font.
		//TODO Be careful to import the correct Font class (not java.awt.Font).
		label.setFont(new Font("Arial", 80.0));
		//TODO Set the text alignment to CENTER
		label.setAlignment(Pos.CENTER);
		// Add the label to the HBox.  You can all more components, too.
		root.getChildren().add(label);
		// Create a Scene using HBox as the root element
		Scene scene = new Scene(root);
		// show the scene on the stage
		stage.setScene(scene);
		stage.setTitle("Own Answer");
		stage.sizeToScene();
	}
	
	public void run() {
		stage.show();
		displayResult();
	}
	
	public void displayResult() {
		label.setText( String.format("%d", lastGuess) );
	}
	
	@Override
	public void update(Observable o, Object arg) {
		lastGuess = (int) arg;
		displayResult();
		
	}
}
