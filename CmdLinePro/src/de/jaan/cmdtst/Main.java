package de.jaan.cmdtst;

import java.io.InputStream;
import java.net.URLConnection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main  extends Application  {
	
	public Main() {
		/* 	das Programm ben�tigt mindestens 
		 * zwei Parameter
		 * der erste wird als Text ausgegeben
		 * die l�nge des zweiten bestimmt wie oft
		*/
	}
	
  static Modell m;
  
	public static void main(String[] args) {
		// auswerten der Argumente
		m = new Modell();

		//m.processargs(args);
		launch(args);
		// die eigentliche Programmaktion in Abh�ngigkeit von den Argumenten
		//dothomething();
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
