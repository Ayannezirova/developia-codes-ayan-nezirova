package az.developia.student;

import java.awt.TextField;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class BooksController implements Initializable {

	@FXML
	private TextField nameText;

	@FXML
	private TextField priceText;
	
	@FXML
	private TextField descriptionText;

	@FXML
	private void Button(ActionEvent event) {
		System.out.println(nameText.getText());
		System.out.println(priceText.getText());
		System.out.println(descriptionText.getText());
	}
	

	
	@Override
	public void initialize(URL c, ResourceBundle b) {

	}

}
