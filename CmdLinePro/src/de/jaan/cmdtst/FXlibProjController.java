package de.jaan.cmdtst;


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;

public class FXlibProjController implements Initializable {

	@FXML TextField nameField;
	@FXML PasswordField passwordField;
	@FXML Text ausgabe;
	@FXML TextArea console;
	private PrintStream ps = new PrintStream(new Console(console));
	Stack<ObjectString> stack;
	
	public FXlibProjController() {
		this.stack= new Stack<ObjectString>();
	}

	@FXML public void handleSubmitButtonAction(ActionEvent event) {
		// jetzt werden die Parametervariablen belegt
		Main.text = nameField.getText();
		Main.anz = passwordField.getText().length();
		ausgabe.setText( Main.anz + " * " + Main.text);
		Main.dothomething();
	}

  public class Console extends OutputStream {
    private TextArea console;

    public Console(TextArea console) {
        this.console = console;
    }

    public void appendText(String valueOf) {
        Platform.runLater(() -> console.appendText(valueOf));
    }

    public void write(int b) throws IOException {
        appendText(String.valueOf((char)b));
    }
  }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ps = new PrintStream(new Console(console)) ;
    System.setOut(ps);
    System.setErr(ps);
		nameField.textProperty().addListener(new ChangeListener<String>() {
            @Override
    		public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
    	        // this will run whenever text is changed
    			ausgabe.setText(oldValue + "-->" + newValue);
    			stack.push(new ObjectString(nameField,oldValue));
    	    }
        });
		passwordField.textProperty().addListener(new ChangeListener<String>() {
            @Override
    		public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
    	        // this will run whenever text is changed
    			ausgabe.setText(oldValue + "-->" + newValue);
    			System.out.println(newValue);
    			stack.push(new ObjectString(passwordField,oldValue));
    	    }
        });
		
	}

	@FXML public void handleUndoButtonAction(ActionEvent event) {
		ObjectString feldStr;
		if(stack.isEmpty()) {
			ausgabe.setText("�nderungsspeicher leer");
		} else {
			feldStr= stack.pop();
			feldStr.obj.setText(feldStr.str);
			stack.pop();
		}
	}
}
