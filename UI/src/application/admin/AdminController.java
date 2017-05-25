package application.admin;

import java.io.*;
import java.util.*;

import application.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class AdminController extends Main {
	ObservableList<String> time_comboList = FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06",
			"07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23");
	ObservableList<String> min_comboList = FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06",
			"07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
			"25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42",
			"43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59");
	ObservableList<String> sec_comboList = FXCollections.observableArrayList("00", "01", "02", "03", "04", "05", "06",
			"07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
			"25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42",
			"43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59");
	ObservableList<String> cam_choiceList = FXCollections.observableArrayList("상상랩 7번방", "4열람실");

	@FXML
	private ComboBox<String> time_combo, min_combo, sec_combo;
	@FXML
	private TextField  currentCamt2, FreqText;
	@FXML
	private ChoiceBox<String> CB1;

	private boolean SET;

	Vector<String> vec = new Vector<String>();
	String presentTi, presentMi, presentSec, currentCam;
	long Ti, Mi, Si;

	@FXML
	private void goPresent() throws IOException {// 현재 정보 조회
		First = false;
		Pre = true;
		if (currentCam.equals("상상랩 7번방"))
			Main.showPresentss();
		else if (currentCam.equals("4열람실"))
			Main.showPresentos();
	}

	@FXML
	private void goSelect() throws IOException {// 선택 시간
		Pre = false;
		if (SET == true) {
			First = false;
			if (currentCam.equals("상상랩 7번방"))
				Main.showSelectss();
			else if (currentCam.equals("4열람실"))
				Main.showSelectos();
		}
		SET = false;
	}

	
	@FXML
	private void initialize() {// 초기화 combobox data/textfield
		
		if (First == true) {
			CB1.valueProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String prevArg, String currentArg) {
					// TODO Auto-generated method stub
					currentCam = currentArg;
					
					currentCamt2.setText(currentCam);
				}
			});
			CB1.setItems(cam_choiceList);
			CB1.getSelectionModel().selectFirst();// 초기상태 첫번째 선택
			time_combo.setItems(time_comboList);
			min_combo.setItems(min_comboList);
			sec_combo.setItems(sec_comboList);
			time_combo.getSelectionModel().selectFirst();
			min_combo.getSelectionModel().selectFirst();
			sec_combo.getSelectionModel().selectFirst();
		}
	}

	@FXML
	private void SetTime() {// combo box로 보고자 하는 시간 세팅
		SET = true;
		T = (String) time_combo.getValue();
		M = (String) min_combo.getValue();
		S = (String) sec_combo.getValue();
	}

	@SuppressWarnings("deprecation")
	public void getTime() {
		Date now = new Date();
		Ti = now.getHours();
		Mi = now.getMinutes();
		Si = now.getSeconds();

		if (Ti < 10) {
			if (Mi < 10) {
				if (Si < 10) {
					presentTi = "0" + String.valueOf(Ti);
					presentMi = "0" + String.valueOf(Mi);
					presentSec = "0" + String.valueOf(Si);
				} else {
					presentTi = "0" + String.valueOf(Ti);
					presentMi = "0" + String.valueOf(Mi);
					presentSec = String.valueOf(Si);
				}
			} else {
				if (Si < 10) {
					presentTi = "0" + String.valueOf(Ti);
					presentMi = String.valueOf(Mi);
					presentSec = "0" + String.valueOf(Si);
				} else {
					presentTi = "0" + String.valueOf(Ti);
					presentMi = String.valueOf(Mi);
					presentSec = String.valueOf(Si);
				}
			}
		} else {
			if (Mi < 10) {
				if (Si < 10) {
					presentTi = String.valueOf(Ti);
					presentMi = "0" + String.valueOf(Mi);
					presentSec = "0" + String.valueOf(Si);
				} else {
					presentTi = String.valueOf(Ti);
					presentMi = "0" + String.valueOf(Mi);
					presentSec = String.valueOf(Si);
				}
			} else {
				if (Si < 10) {
					presentTi = String.valueOf(Ti);
					presentMi = String.valueOf(Mi);
					presentSec = "0" + String.valueOf(Si);
				} else {
					presentTi = String.valueOf(Ti);
					presentMi = String.valueOf(Mi);
					presentSec = String.valueOf(Si);
				}
			}
		}
	}
}