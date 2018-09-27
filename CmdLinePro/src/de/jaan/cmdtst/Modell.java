package de.jaan.cmdtst;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class Modell {

	// Main extends Application gemacht
	private String text;
	private  int anz;
	private FileInfo fi;
	public String getFilename() {
		return this.fi.getFilename();
	}
	public void setFilename(String filename) {
		this.fi.setFilename(filename);
	}
	public Modell() {
		// TODO Auto-generated constructor stub
	}

	public void dothomething() {
		String url = "https://stackoverflow.com/questions/2793150/how-to-use-java-net-urlconnection-to-fire-and-handle-http-requests";
		String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()
		HttpURLConnection connection = null;
		//Proxy instance, proxy ip = 10.0.0.1 with port 8080
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("206.189.144.21", 8080));
		
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
		
	
		for (int i=0; i< getAnz(); i++)
			System.out.println(getText());		
	}

	public  void processargs(String[] args) {
		if (args.length>0) setText(args[0]);
		if (args.length>1) setAnz(args[1].length());
	}

	/**
	 * @return the text
	 */
	 String getText() {
		return this.text;
	}

	/**
	 * @param text the text to set
	 */
	 void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the anz
	 */
	 int getAnz() {
		return this.anz;
	}

	/**
	 * @param anz the anz to set
	 */
	 void setAnz(int anz) {
		this.anz = anz;
	}

}
