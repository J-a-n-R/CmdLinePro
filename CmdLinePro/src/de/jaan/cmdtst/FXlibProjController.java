package de.jaan.cmdtst;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.InputMethodEvent;

public class FXlibProjController implements Initializable {

	@FXML TextField nameField;
	@FXML PasswordField passwordField;
	@FXML Text ausgabe;
	Stack<ObjectString> stack;

	public FXlibProjController() {
		this.stack= new Stack<ObjectString>();
	}

	@FXML public void handleSubmitButtonAction(ActionEvent event) {
		// jetzt werden die Parametervariablen belegt
		Main.text = nameField.getText();
		Main.anz = passwordField.getText().length();
		ausgabe.setText( Main.anz + " * " + Main.text);
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
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
    			stack.push(new ObjectString(passwordField,oldValue));
    	    }
        });
	}

	@FXML public void handleUndoButtonAction(ActionEvent event) {
		ObjectString feldStr;
		if(! stack.isEmpty()) {
			feldStr= stack.pop();
			feldStr.obj.setText(feldStr.str);
			stack.pop();
		}
	}
}
