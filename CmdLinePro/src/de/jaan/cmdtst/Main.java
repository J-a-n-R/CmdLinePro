package de.jaan.cmdtst;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

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
		String url = "https://stackoverflow.com/questions/2793150/how-to-use-java-net-urlconnection-to-fire-and-handle-http-requests";
		String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()
		HttpURLConnection connection = null;
		//Proxy instance, proxy ip = 10.0.0.1 with port 8080
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.1", 8080));
		
		try {
			connection = (HttpURLConnection) new URL(url).openConnection(proxy);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		connection.setDoOutput(true); // Triggers POST.
		connection.setRequestProperty("Accept-Charset", charset);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);

		try (OutputStream output = connection.getOutputStream()) {
		    //output.write(query.getBytes(charset));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// InputStream response = connection.getInputStream();
		try {
			int responseCode = connection.getResponseCode();
			if (responseCode != HttpURLConnection.HTTP_OK) {
				System.out.println("Response: " + responseCode);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* You can fire the HTTP request explicitly with URLConnection#connect(), 
		 * but the request will automatically be fired on demand when you want to get any information 
		 * about the HTTP response, such as the response body using URLConnection#getInputStream() and so on. 
		 * The above examples does exactly that, so the connect() call is in fact superfluous.
		 *
		 */
		

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
