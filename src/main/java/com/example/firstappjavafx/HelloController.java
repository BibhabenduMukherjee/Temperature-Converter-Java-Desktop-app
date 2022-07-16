package com.example.interapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller  implements Initializable {

	@FXML
	public Label welcomeLabel;

	@FXML
	public ChoiceBox<String> choiceBox;

	@FXML
	public TextField userInputField;

	@FXML
	public Button convertButton;

	private static  final String C_TO_F_TEXT = "Celsius to Fahrenheit";
	private static   String str = C_TO_F_TEXT;
	private static  final String F_TO_C_TEXT = "Fahrenheit to Celsius ";

	@Override
	// main function to control logic
	public void initialize(URL url, ResourceBundle resourceBundle) {


		// our app first has the choice-box add the list of action in choiceBox
		choiceBox.getItems().add(C_TO_F_TEXT);
		choiceBox.getItems().add(F_TO_C_TEXT);
		choiceBox.setValue(C_TO_F_TEXT);

		// action by clicking items shows in choiceBox

		choiceBox.getSelectionModel().selectedIndexProperty().addListener((observableValue, number, t1) -> {
		//	System.out.println(choiceBox.getItems().get((Integer) number));
			str = choiceBox.getItems().get((Integer) t1);

		});


		// setOnAction when click to the convert button
    convertButton.setOnAction((actionEvent -> {
	   convert();
    }));
	}

	private void convert() {
		String input = userInputField.getText();
		float enteredTemperature = 0.0f;
		try{
			enteredTemperature =  Float.parseFloat(input);
		}catch (Exception exp){
			warnuser();
			return;
		}
		
	
		float newTemp = 0.0f;
		String unit = "C";
		if(str.equals(C_TO_F_TEXT)){
			newTemp = (enteredTemperature * 9 / 5)+32;
			unit = "F";
		//	System.out.println(C_TO_F_TEXT);
		}else{
			newTemp = (enteredTemperature-32) * 5 /9;

			//System.out.println(F_TO_C_TEXT);
		}
   display(newTemp , unit);
	}

	private void warnuser() {
		Alert warn = new Alert(Alert.AlertType.ERROR);
		warn.setTitle("Error Occurred");
		warn.setHeaderText("Invalid Temperature Entered");
		warn.setContentText("Please Enter a Valid Temperature");
		warn.show();

	}

	private void display(float newTemp , String unit) {
		System.out.println("The temperature is " + newTemp +  " " + unit);
		Alert alert =  new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The temperature is " + newTemp +  " " + unit);
		alert.show();
	}
}
