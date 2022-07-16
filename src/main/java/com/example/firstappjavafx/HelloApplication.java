package com.example.interapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
		VBox rootNode = fxmlLoader.load();
        MenuBar menuBar = createBar();
		rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode);
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.show();
	}

	private MenuBar createBar() {
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");

		// when anyone click this button

		newMenuItem.setOnAction((actionEvent -> System.out.println("New menu clicked")));



		// add a sperator in between menuItem
		SeparatorMenuItem sp =  new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");
        fileMenu.getItems().addAll(newMenuItem , sp , quitMenuItem);
		Menu helpMenu = new Menu("Help");

		MenuItem heplMenuItem = new MenuItem("About");
		heplMenuItem.setOnAction((actionEvent -> {aboutApp();}));
		helpMenu.getItems().addAll(heplMenuItem);

		// create the menuBar
		MenuBar menuBar = new MenuBar();
		 menuBar.getMenus().addAll(fileMenu  , helpMenu);
    return menuBar;
	}
    public static  void aboutApp(){
	    Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
			    alertDialog.setTitle("Helping window");
				alertDialog.setHeaderText("Learing JavaFX");
				alertDialog.setContentText("I am just a beginner and i am also a pro");
				ButtonType yesButton = new ButtonType("YES");
				ButtonType noButton = new ButtonType("NO");
				alertDialog.getButtonTypes().setAll(yesButton , noButton);



				// it returns which button is actually clicked
               Optional<ButtonType> clickedButton = alertDialog.showAndWait();
			   if( clickedButton.isPresent() &&  clickedButton.get() == yesButton){
				   System.out.println("Yes Button Clicked");
			   }

			   if( clickedButton.isPresent() && clickedButton.get() == noButton){
				   System.out.println("No Button Clicked");
			   }


    }

	public static void main(String[] args) {
		launch();
	}
}
