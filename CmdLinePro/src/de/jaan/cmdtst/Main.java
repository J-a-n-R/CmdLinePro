package de.jaan.cmdtst;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main  extends Application  {
	// Main extends Application gemacht
	static String text;
	static int anz;

	public Main() {
		/* 	das Programm benötigt mindestens 
		 * zwei Parameter
		 * der erste wird als Text ausgegeben
		 * die länge des zweiten bestimmt wie oft
		*/
	}

	public static void main(String[] args) {
		// auswerten der Argumente
		// processargs(args);
		launch(args);
		// die eigentliche Programmaktion in Abhängigkeit von den Argumenten
		//dothomething();
	}

	static void dothomething() {
		for (int i=0; i<anz; i++)
			System.out.println(text);		
	}

	private static void processargs(String[] args) {
		text = args[0];
		anz = args[1].length();
	}

	@Override
	public void start(Stage stage) throws Exception {
		// aus dem FX-Projekt hierher kopiert
	       Parent root = FXMLLoader.load(getClass().getResource("FXlibProj.fxml"));	       
	        Scene scene = new Scene(root, 300, 275);	    
	        stage.setTitle("FX Library Project");
	        stage.setScene(scene);
	        stage.show();
	}

}
