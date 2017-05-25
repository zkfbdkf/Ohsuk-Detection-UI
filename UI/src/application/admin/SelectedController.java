package application.admin;

import java.io.*;
import java.sql.*;

import com.mysql.jdbc.Statement;

import javafx.fxml.*;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;

public class SelectedController extends AdminController {

	@FXML
	private TextField Time1, Min1, Sec1;
	@FXML
	private TextField Time2, Min2, Sec2, count,Occupation;
	@FXML
	private ImageView imageview1, imageview2;
	@FXML
	private LineChart<String, Float> line1, line2;
	@FXML
	private StackedBarChart<String, Float> stack1, stack2;

	float r;
	int fill;
	String timeinfo, timetag, countnum, strokeStyle = "-fx-stroke: RED;";
	boolean flag = true;

	@FXML
	private void initiallize() {
	}

	@FXML
	private void SelectRefreshSS() {
		Time1.setText(T);
		Min1.setText(M);
		Sec1.setText(S);
		timetag = T + M + S;
		File file = new File("C:/Users/Tim/Documents/Visual Studio 2013/Projects/OPENDB/ImageFile/" + timetag + ".jpg");
		Image image = new Image(file.toURI().toString());
		imageview1.setImage(image);

		try {
			ssArr = new int[6];
			sstables = new String[6];

			String myDriver = "com.mysql.jdbc.Driver";
			Class.forName(myDriver);
			conn = DriverManager.getConnection(url, id, password);

			String query = "SELECT * FROM inputdata where time ='" + T + M + S + "';";
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				ssmapinfo = rs.getString("mapinfo");
			}
			for (int i = 0; i < 6; i++) {
				sstables[i] = ssmapinfo.substring(i, i + 1);
				ssArr[i] = Integer.parseInt(sstables[i]);
			}
		} catch (Exception a) {
		}

		if (ssArr[0] == 1)
			ssRec1.setFill(Color.RED);
		else
			ssRec1.setFill(Color.GREEN);
		if (ssArr[1] == 1)
			ssRec2.setFill(Color.RED);
		else
			ssRec2.setFill(Color.GREEN);
		if (ssArr[2] == 1)
			ssRec3.setFill(Color.RED);
		else
			ssRec3.setFill(Color.GREEN);
		if (ssArr[3] == 1)
			ssRec4.setFill(Color.RED);
		else
			ssRec4.setFill(Color.GREEN);
		if (ssArr[4] == 1)
			ssRec5.setFill(Color.RED);
		else
			ssRec5.setFill(Color.GREEN);
		if (ssArr[5] == 1)
			ssRec6.setFill(Color.RED);
		else
			ssRec6.setFill(Color.GREEN);

		// graph
		try {
			String myDriver = "com.mysql.jdbc.Driver";
			Class.forName(myDriver);
			conn = DriverManager.getConnection(url, id, password);

			String query = "SELECT * FROM inputdata;";
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				fill = 0;
				r = 0;
				timeinfo = rs.getString("time");
				graphvec.add(timeinfo);
				ssmapinfo = rs.getString("mapinfo");
				for (int i = 0; i < 6; i++) {
					sstables[i] = ssmapinfo.substring(i, i + 1);
					ssArr[i] = Integer.parseInt(sstables[i]);
					if (ssArr[i] == 1)
						fill++;
				}
				r = (float) fill / (float) sstotal * 100;
				charinfo.add(r);
			}
		} catch (Exception a) {
		}
		if (flag == true) {
			XYChart.Series<String, Float> series = new XYChart.Series<String, Float>();
			XYChart.Series<String, Float> series1 = new XYChart.Series<String, Float>();
			line1.getData().add(series);
			stack1.getData().add(series1);

			for (int j = 0; j < graphvec.size(); j += 15) {
				series.getData().add(new XYChart.Data<String, Float>(graphvec.get(j), charinfo.get(j)));
				series1.getData().add(new XYChart.Data<String, Float>(graphvec.get(j), charinfo.get(j)));
				series.getNode().setStyle(strokeStyle);
			}

		}
		flag = false;
		graphvec.clear();
		charinfo.clear();
	}

	@FXML
	private void SelectRefreshOS() {
		Time2.setText(T);
		Min2.setText(M);
		Sec2.setText(S);
		timetag = T + M + S;
		File file = new File("C:/Users/Tim/Documents/Visual Studio 2013/Projects/OS/ImageFile/" + timetag + ".jpg");
		Image image = new Image(file.toURI().toString());
		imageview2.setImage(image);

		ostables = new String[13];
		osArr = new int[13];

		try {
			Class.forName(myDriver);
			conn = DriverManager.getConnection(url, id, password);

			String query1 = "SELECT * FROM osdata where time ='" + T + M + S + "';";
			Statement st1 = (Statement) conn.createStatement();
			ResultSet rs1 = st1.executeQuery(query1);

			while (rs1.next()) {
				osmapinfo = rs1.getString("mapinfo");
				countnum = rs1.getString("count");
			}
			count.setText(countnum);
			for (int i = 0; i < 13; i++) {
				ostables[i] = osmapinfo.substring(i, i + 1);
				osArr[i] = Integer.parseInt(ostables[i]);
			}
			
		} catch (Exception e) {
		}
		if (osArr[0] == 1)
			osRec1.setFill(Color.RED);
		else
			osRec1.setFill(Color.GREEN);
		if (osArr[1] == 1)
			osRec2.setFill(Color.RED);
		else
			osRec2.setFill(Color.GREEN);
		if (osArr[2] == 1)
			osRec3.setFill(Color.RED);
		else
			osRec3.setFill(Color.GREEN);
		if (osArr[3] == 1)
			osRec4.setFill(Color.RED);
		else
			osRec4.setFill(Color.GREEN);
		if (osArr[4] == 1)
			osRec5.setFill(Color.RED);
		else
			osRec5.setFill(Color.GREEN);
		if (osArr[5] == 1)
			osRec6.setFill(Color.RED);
		else
			osRec6.setFill(Color.GREEN);
		if (osArr[6] == 1)
			osRec7.setFill(Color.RED);
		else
			osRec7.setFill(Color.GREEN);
		if (osArr[7] == 1)
			osRec8.setFill(Color.RED);
		else
			osRec8.setFill(Color.GREEN);
		if (osArr[8] == 1)
			osRec9.setFill(Color.RED);
		else
			osRec9.setFill(Color.GREEN);
		if (osArr[9] == 1)
			osRec10.setFill(Color.RED);
		else
			osRec10.setFill(Color.GREEN);
		if (osArr[10] == 1)
			osRec11.setFill(Color.RED);
		else
			osRec11.setFill(Color.GREEN);
		if (osArr[11] == 1)
			osRec12.setFill(Color.RED);
		else
			osRec12.setFill(Color.GREEN);
		if (osArr[12] == 1)
			osRec13.setFill(Color.RED);
		else
			osRec13.setFill(Color.GREEN);

		for(int i=0; i<13;i++){
			if(osArr[i]==1)
				fill++;
		}
		float r = (float) fill / (float) ostotal * 100;
		String result = String.format("%.2f", r);
		Occupation.setText(result);
		
		// graph
		try {
			String myDriver = "com.mysql.jdbc.Driver";
			Class.forName(myDriver);
			conn = DriverManager.getConnection(url, id, password);

			String query = "SELECT * FROM osdata;";
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				fill = 0;
				r = 0;
				timeinfo = rs.getString("time");
				graphvec.add(timeinfo);
				osmapinfo = rs.getString("mapinfo");
				for (int i = 0; i < 13; i++) {
					ostables[i] = osmapinfo.substring(i, i + 1);
					osArr[i] = Integer.parseInt(ostables[i]);
					if (osArr[i] == 1)
						fill++;
				}
				r = (float) fill / (float) ostotal * 100;
				charinfo.add(r);
			}
			
		} catch (Exception a) {
		}
		if (flag == true) {
			XYChart.Series<String, Float> series = new XYChart.Series<String, Float>();
			XYChart.Series<String, Float> series1 = new XYChart.Series<String, Float>();
			line2.getData().add(series);
			stack2.getData().add(series1);
			for (int j = 0; j < graphvec.size(); j += 15) {
				series.getData().add(new XYChart.Data<String, Float>(graphvec.get(j), charinfo.get(j)));
				series1.getData().add(new XYChart.Data<String, Float>(graphvec.get(j), charinfo.get(j)));
				series.getNode().setStyle(strokeStyle);
			}
		}
		flag = false;
		graphvec.clear();
		charinfo.clear();
	}
}
