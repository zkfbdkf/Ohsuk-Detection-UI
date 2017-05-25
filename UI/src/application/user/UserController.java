package application.user;

import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

import com.mysql.jdbc.Statement;

import application.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;

public class UserController extends Main {
	@FXML
	private TextField updateTime, updateMin, updateSec, updateTime1, updateMin1, updateSec1;
	@FXML
	private TextField Div1, Result1, savedTime1, Div2, Result2, savedTime2;
	@FXML
	private TextField TF1, TF2, TF3, TF4, TF5, TF6;
	@FXML
	private TextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13;

	boolean flag;
	Vector<String> vec = new Vector<String>();
	int ssfill, osfill, Ti, Mi, Si, hour, min, sec;
	String presentTime, presentMin, presentSec, sstempdata, ostempdata, savetime, current, sslastinfo, oslastinfo;
	String[] ST;
	long difference;
	Date time1, time2;
	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

	@FXML
	private void initialize() {// 초기화
		SavedssRecTime = new String[6];
		SavedosRecTime = new String[13];
	}

	@FXML
	private void getDetailss() throws ParseException {
		if (flag == true) {
			ST = new String[13];
			getTime();
			current = presentTime + ":" + presentMin + ":" + presentSec;
			if (ssArr[0] == 1) {
				savetime = SavedssRecTime[0].substring(0, 2) + ":" + SavedssRecTime[0].substring(2, 4) + ":"
						+ SavedssRecTime[0].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				TF1.setText(hour + " : " + min + " : " + sec);
			} else
				TF1.setText("");
			if (ssArr[1] == 1) {
				savetime = SavedssRecTime[1].substring(0, 2) + ":" + SavedssRecTime[1].substring(2, 4) + ":"
						+ SavedssRecTime[1].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				TF2.setText(hour + " : " + min + " : " + sec);
			} else
				TF2.setText("");
			if (ssArr[2] == 1) {
				savetime = SavedssRecTime[2].substring(0, 2) + ":" + SavedssRecTime[2].substring(2, 4) + ":"
						+ SavedssRecTime[2].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				TF3.setText(hour + " : " + min + " : " + sec);
			} else
				TF3.setText("");
			if (ssArr[3] == 1) {
				savetime = SavedssRecTime[3].substring(0, 2) + ":" + SavedssRecTime[3].substring(2, 4) + ":"
						+ SavedssRecTime[3].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				TF4.setText(hour + " : " + min + " : " + sec);
			} else
				TF4.setText("");
			if (ssArr[4] == 1) {
				savetime = SavedssRecTime[4].substring(0, 2) + ":" + SavedssRecTime[4].substring(2, 4) + ":"
						+ SavedssRecTime[4].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				TF5.setText(hour + " : " + min + " : " + sec);
			} else
				TF5.setText("");
			if (ssArr[5] == 1) {
				savetime = SavedssRecTime[5].substring(0, 2) + ":" + SavedssRecTime[5].substring(2, 4) + ":"
						+ SavedssRecTime[5].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				TF6.setText(hour + " : " + min + " : " + sec);
			} else
				TF6.setText("");
		}
	}

	@FXML
	private void getDetailos() throws ParseException {
		if (flag == true) {
			ST = new String[13];
			getTime();
			current = presentTime + ":" + presentMin + ":" + presentSec;

			if (osArr[0] == 1) {
				savetime = SavedosRecTime[0].substring(0, 2) + ":" + SavedosRecTime[0].substring(2, 4) + ":"
						+ SavedosRecTime[0].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				tf1.setText(hour + " : " + min + " : " + sec);
			} else
				tf1.setText("");
			if (osArr[1] == 1) {
				savetime = SavedosRecTime[1].substring(0, 2) + ":" + SavedosRecTime[1].substring(2, 4) + ":"
						+ SavedosRecTime[1].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				tf2.setText(hour + " : " + min + " : " + sec);
			} else
				tf2.setText("");
			if (osArr[2] == 1) {
				savetime = SavedosRecTime[2].substring(0, 2) + ":" + SavedosRecTime[2].substring(2, 4) + ":"
						+ SavedosRecTime[2].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				tf3.setText(hour + " : " + min + " : " + sec);
			} else
				tf3.setText("");
			if (osArr[3] == 1) {
				savetime = SavedosRecTime[3].substring(0, 2) + ":" + SavedosRecTime[3].substring(2, 4) + ":"
						+ SavedosRecTime[3].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				tf4.setText(hour + " : " + min + " : " + sec);
			} else
				tf4.setText("");
			if (osArr[4] == 1) {
				savetime = SavedosRecTime[4].substring(0, 2) + ":" + SavedosRecTime[4].substring(2, 4) + ":"
						+ SavedosRecTime[4].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				tf5.setText(hour + " : " + min + " : " + sec);
			} else
				tf5.setText("");
			if (osArr[5] == 1) {
				savetime = SavedosRecTime[5].substring(0, 2) + ":" + SavedosRecTime[5].substring(2, 4) + ":"
						+ SavedosRecTime[5].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				tf6.setText(hour + " : " + min + " : " + sec);
			} else
				tf6.setText("");
			if (osArr[6] == 1) {
				savetime = SavedosRecTime[6].substring(0, 2) + ":" + SavedosRecTime[6].substring(2, 4) + ":"
						+ SavedosRecTime[6].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				tf7.setText(hour + " : " + min + " : " + sec);
			} else
				tf7.setText("");
			if (osArr[7] == 1) {
				savetime = SavedosRecTime[7].substring(0, 2) + ":" + SavedosRecTime[7].substring(2, 4) + ":"
						+ SavedosRecTime[7].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				tf8.setText(hour + " : " + min + " : " + sec);
			} else
				tf8.setText("");
			if (osArr[8] == 1) {
				savetime = SavedosRecTime[8].substring(0, 2) + ":" + SavedosRecTime[8].substring(2, 4) + ":"
						+ SavedosRecTime[8].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				tf9.setText(hour + " : " + min + " : " + sec);
			} else
				tf9.setText("");
			if (osArr[9] == 1) {
				savetime = SavedosRecTime[9].substring(0, 2) + ":" + SavedosRecTime[9].substring(2, 4) + ":"
						+ SavedosRecTime[9].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				tf10.setText(hour + " : " + min + " : " + sec);
			} else
				tf10.setText("");
			if (osArr[10] == 1) {
				savetime = SavedosRecTime[10].substring(0, 2) + ":" + SavedosRecTime[10].substring(2, 4) + ":"
						+ SavedosRecTime[10].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				tf11.setText(hour + " : " + min + " : " + sec);
			} else
				tf11.setText("");
			if (osArr[11] == 1) {
				savetime = SavedosRecTime[11].substring(0, 2) + ":" + SavedosRecTime[11].substring(2, 4) + ":"
						+ SavedosRecTime[11].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				tf12.setText(hour + " : " + min + " : " + sec);
			} else
				tf12.setText("");
			if (osArr[12] == 1) {
				savetime = SavedosRecTime[12].substring(0, 2) + ":" + SavedosRecTime[12].substring(2, 4) + ":"
						+ SavedosRecTime[12].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
				sec = (int) (difference % 60);
				min = (int) (difference / 60);
				if (min > 60) {
					hour = min / 60;
					min = min % 60;
				}
				tf13.setText(hour + " : " + min + " : " + sec);
			} else
				tf13.setText("");
		}
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
					presentTime = "0" + String.valueOf(Ti);
					presentMin = "0" + String.valueOf(Mi);
					presentSec = "0" + String.valueOf(Si);
				} else {
					presentTime = "0" + String.valueOf(Ti);
					presentMin = "0" + String.valueOf(Mi);
					presentSec = String.valueOf(Si);
				}
			} else {
				if (Si < 10) {
					presentTime = "0" + String.valueOf(Ti);
					presentMin = String.valueOf(Mi);
					presentSec = "0" + String.valueOf(Si);
				} else {
					presentTime = "0" + String.valueOf(Ti);
					presentMin = String.valueOf(Mi);
					presentSec = String.valueOf(Si);
				}
			}
		} else {
			if (Mi < 10) {
				if (Si < 10) {
					presentTime = String.valueOf(Ti);
					presentMin = "0" + String.valueOf(Mi);
					presentSec = "0" + String.valueOf(Si);
				} else {
					presentTime = String.valueOf(Ti);
					presentMin = "0" + String.valueOf(Mi);
					presentSec = String.valueOf(Si);
				}
			} else {
				if (Si < 10) {
					presentTime = String.valueOf(Ti);
					presentMin = String.valueOf(Mi);
					presentSec = "0" + String.valueOf(Si);
				} else {
					presentTime = String.valueOf(Ti);
					presentMin = String.valueOf(Mi);
					presentSec = String.valueOf(Si);
				}
			}
		}
	}

	@FXML
	public void update() throws SQLException, ClassNotFoundException {
		flag = true;
		ssfill = 0;
		osfill = 0;
		getTime();
		updateTime.setText(presentTime);
		updateMin.setText(presentMin);
		updateSec.setText(presentSec);
		// 상상랩
		ssArr = new int[6];
		sstables = new String[6];
		Class.forName(myDriver);
		conn = DriverManager.getConnection(url, id, password);
		String query = "SELECT * FROM inputdata;";
		Statement st = (Statement) conn.createStatement();
		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			ssmapinfo = rs.getString("mapinfo");
			if (!ssmapinfo.equals(sstempdata)) {
				SavedssRecTime[0] = rs.getString("time1");
				SavedssRecTime[1] = rs.getString("time2");
				SavedssRecTime[2] = rs.getString("time3");
				SavedssRecTime[3] = rs.getString("time4");
				SavedssRecTime[4] = rs.getString("time5");
				SavedssRecTime[5] = rs.getString("time6");
			}
			vec1.add(ssmapinfo);
			sstempdata = ssmapinfo;
		}
		try {
			sslastinfo = vec1.lastElement();

			for (int i = 0; i < 6; i++) {
				sstables[i] = sslastinfo.substring(i, i + 1);
				ssArr[i] = Integer.parseInt(sstables[i]);
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

			for (int i = 0; i < 6; i++) {
				if (ssArr[i] == 1)
					ssfill++;
			}
			float r = (float) ssfill / (float) sstotal * 100;
			String result = String.format("%.2f", r);
			Result1.setText(result + "%");
			Div1.setText("" + String.valueOf(ssfill) + "/" + sstotal);

			vec1.clear();
		} catch (NoSuchElementException e) {
		}

		// 오석
		ostables = new String[13];
		osArr = new int[13];
		Class.forName(myDriver);
		conn = DriverManager.getConnection(url, id, password);
		updateTime1.setText(presentTime);
		updateMin1.setText(presentMin);
		updateSec1.setText(presentSec);
		String query1 = "SELECT * FROM osdata;";
		Statement st1 = (Statement) conn.createStatement();
		ResultSet rs1 = st1.executeQuery(query1);

		while (rs1.next()) {
			osmapinfo = rs1.getString("mapinfo");

			if (!osmapinfo.equals(ostempdata)) {
				SavedosRecTime[0] = rs1.getString("time1");
				SavedosRecTime[1] = rs1.getString("time2");
				SavedosRecTime[2] = rs1.getString("time3");
				SavedosRecTime[3] = rs1.getString("time4");
				SavedosRecTime[4] = rs1.getString("time5");
				SavedosRecTime[5] = rs1.getString("time6");
				SavedosRecTime[6] = rs1.getString("time7");
				SavedosRecTime[7] = rs1.getString("time8");
				SavedosRecTime[8] = rs1.getString("time9");
				SavedosRecTime[9] = rs1.getString("time10");
				SavedosRecTime[10] = rs1.getString("time11");
				SavedosRecTime[11] = rs1.getString("time12");
				SavedosRecTime[12] = rs1.getString("time13");
			}
			vec2.add(osmapinfo);
			ostempdata = osmapinfo;
		}
		oslastinfo = vec2.lastElement();
		for (int i = 0; i < 13; i++) {
			ostables[i] = oslastinfo.substring(i, i + 1);
			osArr[i] = Integer.parseInt(ostables[i]);
		}

		if (osArr[0] == 1)
			osRec1.setFill(Color.RED);
		else if (osArr[0] == 2)
			osRec1.setFill(Color.YELLOW);
		else
			osRec1.setFill(Color.GREEN);
		if (osArr[1] == 1)
			osRec2.setFill(Color.RED);
		else if (osArr[1] == 2)
			osRec2.setFill(Color.YELLOW);
		else
			osRec2.setFill(Color.GREEN);
		if (osArr[2] == 1)
			osRec3.setFill(Color.RED);
		else if (osArr[2] == 2)
			osRec3.setFill(Color.YELLOW);
		else
			osRec3.setFill(Color.GREEN);
		if (osArr[3] == 1)
			osRec4.setFill(Color.RED);
		else if (osArr[3] == 2)
			osRec4.setFill(Color.YELLOW);
		else
			osRec4.setFill(Color.GREEN);
		if (osArr[4] == 1)
			osRec5.setFill(Color.RED);
		else if (osArr[4] == 2)
			osRec5.setFill(Color.YELLOW);
		else
			osRec5.setFill(Color.GREEN);
		if (osArr[5] == 1)
			osRec6.setFill(Color.RED);
		else if (osArr[5] == 2)
			osRec6.setFill(Color.YELLOW);
		else
			osRec6.setFill(Color.GREEN);
		if (osArr[6] == 1)
			osRec7.setFill(Color.RED);
		else if (osArr[6] == 2)
			osRec7.setFill(Color.YELLOW);
		else
			osRec7.setFill(Color.GREEN);
		if (osArr[7] == 1)
			osRec8.setFill(Color.RED);
		else if (osArr[7] == 2)
			osRec8.setFill(Color.YELLOW);
		else
			osRec8.setFill(Color.GREEN);
		if (osArr[8] == 1)
			osRec9.setFill(Color.RED);
		else if (osArr[8] == 2)
			osRec9.setFill(Color.YELLOW);
		else
			osRec9.setFill(Color.GREEN);
		if (osArr[9] == 1)
			osRec10.setFill(Color.RED);
		else if (osArr[9] == 2)
			osRec10.setFill(Color.YELLOW);
		else
			osRec10.setFill(Color.GREEN);
		if (osArr[10] == 1)
			osRec11.setFill(Color.RED);
		else if (osArr[10] == 2)
			osRec11.setFill(Color.YELLOW);
		else
			osRec11.setFill(Color.GREEN);
		if (osArr[11] == 1)
			osRec12.setFill(Color.RED);
		else if (osArr[11] == 2)
			osRec12.setFill(Color.YELLOW);
		else
			osRec12.setFill(Color.GREEN);
		if (osArr[12] == 1)
			osRec13.setFill(Color.RED);
		else if (osArr[12] == 2)
			osRec13.setFill(Color.YELLOW);
		else
			osRec13.setFill(Color.GREEN);

		for (int i = 0; i < 13; i++) {
			if (osArr[i] == 1)
				osfill++;
		}
		float r = (float) osfill / (float) ostotal * 100;
		String result = String.format("%.2f", r);
		Result2.setText(result + "%");
		Div2.setText("" + String.valueOf(osfill) + "/" + ostotal);
		vec2.clear();
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
		tf5.setText("");
		tf6.setText("");
		tf7.setText("");
		tf8.setText("");
		tf9.setText("");
		tf10.setText("");
		tf11.setText("");
		tf12.setText("");
		tf13.setText("");
		TF1.setText("");
		TF2.setText("");
		TF3.setText("");
		TF4.setText("");
		TF5.setText("");
		TF6.setText("");
	}

	@FXML
	public void showssinfo1() {
		if (ssArr[0] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedssRecTime[0].substring(0, 2) + ":" + SavedssRecTime[0].substring(2, 4) + ":"
						+ SavedssRecTime[0].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime1.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showssinfo2() {
		if (ssArr[1] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedssRecTime[1].substring(0, 2) + ":" + SavedssRecTime[1].substring(2, 4) + ":"
						+ SavedssRecTime[1].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime1.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showssinfo3() {
		if (ssArr[2] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedssRecTime[2].substring(0, 2) + ":" + SavedssRecTime[2].substring(2, 4) + ":"
						+ SavedssRecTime[2].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime1.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showssinfo4() {
		if (ssArr[3] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedssRecTime[3].substring(0, 2) + ":" + SavedssRecTime[3].substring(2, 4) + ":"
						+ SavedssRecTime[3].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime1.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showssinfo5() {
		if (ssArr[4] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedssRecTime[4].substring(0, 2) + ":" + SavedssRecTime[4].substring(2, 4) + ":"
						+ SavedssRecTime[4].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime1.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showssinfo6() {
		if (ssArr[5] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedssRecTime[5].substring(0, 2) + ":" + SavedssRecTime[5].substring(2, 4) + ":"
						+ SavedssRecTime[5].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime1.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showosinfo1() {
		if (osArr[0] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedosRecTime[0].substring(0, 2) + ":" + SavedosRecTime[0].substring(2, 4) + ":"
						+ SavedosRecTime[0].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime2.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showosinfo2() {
		if (osArr[1] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedosRecTime[1].substring(0, 2) + ":" + SavedosRecTime[1].substring(2, 4) + ":"
						+ SavedosRecTime[1].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime2.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showosinfo3() {
		if (osArr[2] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedosRecTime[2].substring(0, 2) + ":" + SavedosRecTime[2].substring(2, 4) + ":"
						+ SavedosRecTime[2].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime2.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showosinfo4() {
		if (osArr[3] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedosRecTime[3].substring(0, 2) + ":" + SavedosRecTime[3].substring(2, 4) + ":"
						+ SavedosRecTime[3].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime2.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showosinfo5() {
		if (osArr[4] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedosRecTime[4].substring(0, 2) + ":" + SavedosRecTime[4].substring(2, 4) + ":"
						+ SavedosRecTime[4].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime2.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showosinfo6() {
		if (osArr[5] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedosRecTime[5].substring(0, 2) + ":" + SavedosRecTime[5].substring(2, 4) + ":"
						+ SavedosRecTime[5].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime2.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showosinfo7() {
		if (osArr[6] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedosRecTime[6].substring(0, 2) + ":" + SavedosRecTime[6].substring(2, 4) + ":"
						+ SavedosRecTime[6].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime2.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showosinfo8() {
		if (osArr[7] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedosRecTime[7].substring(0, 2) + ":" + SavedosRecTime[7].substring(2, 4) + ":"
						+ SavedosRecTime[7].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime2.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showosinfo9() {
		if (osArr[8] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedosRecTime[8].substring(0, 2) + ":" + SavedosRecTime[8].substring(2, 4) + ":"
						+ SavedosRecTime[8].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime2.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showosinfo10() {
		if (osArr[9] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedosRecTime[9].substring(0, 2) + ":" + SavedosRecTime[9].substring(2, 4) + ":"
						+ SavedosRecTime[9].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime2.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showosinfo11() {
		if (osArr[10] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedosRecTime[10].substring(0, 2) + ":" + SavedosRecTime[10].substring(2, 4) + ":"
						+ SavedosRecTime[10].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime2.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showosinfo12() {
		if (osArr[11] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedosRecTime[11].substring(0, 2) + ":" + SavedosRecTime[11].substring(2, 4) + ":"
						+ SavedosRecTime[11].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime2.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}

	@FXML
	public void showosinfo13() {
		if (osArr[12] == 1) {
			try {
				current = presentTime + ":" + presentMin + ":" + presentSec;
				savetime = SavedosRecTime[12].substring(0, 2) + ":" + SavedosRecTime[12].substring(2, 4) + ":"
						+ SavedosRecTime[12].substring(4, 6);
				time1 = format.parse(savetime);
				time2 = format.parse(current);
				difference = (time2.getTime() - time1.getTime()) / 1000;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec = (int) (difference % 60);
			min = (int) (difference / 60);
			if (min > 60) {
				hour = min / 60;
				min = min % 60;
			}
			savedTime2.setText("현재 " + hour + " 시간 " + min + " 분 " + sec + " 초 동안 사용중");
		}
	}
}