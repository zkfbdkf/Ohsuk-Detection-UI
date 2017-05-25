package application.main;

import java.io.*;

import application.Main;
import javafx.fxml.*;

public class MainItemsController {
	@FXML
	private void goAdmin() throws IOException{
		Main.showAdmin();
	}
	
	@FXML
	private void goUser() throws IOException{
		Main.showUser();
	}
}
