package de.jaan.cmdtst;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class FXlibProjController {

	@FXML TextField nameField;
	@FXML PasswordField passwordField;
	@FXML Text ausgabe;

	public FXlibProjController() {
		
	}

	@FXML public void handleSubmitButtonAction(ActionEvent event) {
		// jetzt werden die Parametervariablen belegt
		Main.text = nameField.getText();
		Main.anz = passwordField.getText().length();
		ausgabe.setText( Main.anz + " * " + Main.text);
	}

}
