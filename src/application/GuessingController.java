package application;

import guessingGame.VaritGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GuessingController {
	
	private VaritGame varit;
	
	@FXML
	TextField answer;
	@FXML
	Label status;
	@FXML
	Button check;
	@FXML
	Button giveup;
	@FXML
	Button clear;
	
	
	public void handleCheck(ActionEvent event) {
		
		int myguess = Integer.parseInt(answer.getText());
		if(varit.guess(myguess)) {
			status.setText("Correct the secret number is" + varit.getSecret());
		}else if(myguess < varit.getSecret()) {
			status.setText("Sorry, too small.");
		}else {
			status.setText("Sorry, too large.");
		}
	}
	
	public void handleGiveUp(ActionEvent event) {
		status.setStyle("-fx-text-inner-color: red;");
		status.setText(String.format("The secret number is %d.",varit.getSecret()));
		answer.setDisable(true);
		check.setDisable(true);
		clear.setDisable(true);
	}
	
	public void handleClear(ActionEvent event) {
		answer.setText("");
	}
	
	public void setGuessingGame(VaritGame varit) {
		this.varit = varit;
	}
}
