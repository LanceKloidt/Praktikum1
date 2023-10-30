package main;

import gui.BuergeraemterAnwendersystem;
import javafx.application.Application;
import javafx.stage.Stage;
import ownUtil.BuergeraemterControl;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new BuergeraemterControl(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
