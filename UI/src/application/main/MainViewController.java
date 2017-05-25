package application.main;

import java.io.*;

import application.Main;
import javafx.fxml.*;

public class MainViewController {
	@FXML
	private void goHome() throws IOException{
		Main.showMainItems();
	}
}