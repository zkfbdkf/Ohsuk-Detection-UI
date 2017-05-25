package application.admin;

import java.io.*;
import java.sql.*;

import com.mysql.jdbc.Statement;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;

public class PresentContoller extends AdminController {

	@FXML
	private ImageView imageview1, imageview2;
	@FXML
	private TextField UPtime1, UPmin1, UPsec1, UPtime2, UPmin2, UPsec2, count;

	String sslastinfo, oslastinfo, countnum;

	@FXML
	private void initiallize(){
	}
	
	@FXML
	private void PresentRefreshSS() {
		File file = new File("C:/Users/Tim/Documents/Visual Studio 2013/Projects/OPENDB/ImageFile/save.jpg");
		Image image = new Image(file.toURI().toString());
		imageview1.setImage(image);
		getTime();
		UPtime1.setText(presentTi);
		UPmin1.setText(presentMi);
		UPsec1.setText(presentSec);
		try {
			ssArr = new int[6];
			sstables = new String[6];
			String myDriver = "com.mysql.jdbc.Driver";
			Class.forName(myDriver);
			conn = DriverManager.getConnection(url, id, password);

			String query = "SELECT * FROM inputdata;";
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				ssmapinfo = rs.getString("mapinfo");
				vec1.add(ssmapinfo);
			}
			sslastinfo = vec1.lastElement();

			for (int i = 0; i < 6; i++) {
				sstables[i] = sslastinfo.substring(i, i + 1);
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
		vec1.clear();
	}

	@FXML
	private void PresentRefreshOS() {
		File file = new File("C:/Users/Tim/Documents/Visual Studio 2013/Projects/OS/ImageFile/save.jpg");
		Image image = new Image(file.toURI().toString());
		imageview2.setImage(image);

		getTime();
		UPtime2.setText(presentTi);
		UPmin2.setText(presentMi);
		UPsec2.setText(presentSec);

		try {
			ostables = new String[13];
			osArr = new int[13];
			String myDriver = "com.mysql.jdbc.Driver";
			Class.forName(myDriver);
			conn = DriverManager.getConnection(url, id, password);

			String query = "SELECT * FROM osdata;";// 현재시간으로부터
													// 정보를
													// 받아온다.
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				osmapinfo = rs.getString("mapinfo");
				countnum = rs.getString("count");
				vec2.add(osmapinfo);
			}
			count.setText(countnum);
			oslastinfo = vec2.lastElement();
			for (int i = 0; i < 13; i++) {
				ostables[i] = oslastinfo.substring(i, i + 1);
				osArr[i] = Integer.parseInt(ostables[i]);
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
			vec2.clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}

	}
}
