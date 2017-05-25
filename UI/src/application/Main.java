package application;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.mysql.jdbc.Statement;

import javafx.application.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.stage.*;

public class Main extends Application {
	private static Stage primaryStage;
	private static BorderPane mainLayout;
	protected static boolean First, Pre;// Flag
	public static String T, M, S;// 선택한 시간 정보
	public double Freq = 5;// 카메라 주기

	protected Connection conn = null;
	protected String url = "jdbc:mysql://127.0.0.1/spaceinfo";
	protected String id = "root";
	protected String password = "1234";
	protected String myDriver = "com.mysql.jdbc.Driver";

	protected static String ssmapinfo, osmapinfo, newinfo, table_1, table_2, table_3, table_4, table_5, table_6,
			table_7;
	protected static int tableNo_1, tableNo_2, tableNo_3, tableNo_4, tableNo_5, tableNo_6, tableNo_7;

	protected static String sstables[];
	protected static String ostables[];

	protected Vector<String> vec1 = new Vector<String>();
	protected Vector<String> vec2 = new Vector<String>();
	protected Vector<String> graphvec = new Vector<String>();
	protected Vector<Float> charinfo = new Vector<Float>();

	@FXML
	public Rectangle ssRec1, ssRec2, ssRec3, ssRec4, ssRec5, ssRec6;// 상상랩 좌석
	@FXML
	public Rectangle osRec1, osRec2, osRec3, osRec4, osRec5, osRec6, osRec7, osRec8, osRec9, osRec10, osRec11, osRec12,
			osRec13;// 오석관

	public int[] ssArr;// 좌석의 점유 정보
	public int[] osArr;
	public String[] SavedssRecTime, SavedosRecTime;
	public int sstotal = 6, ostotal = 13;

	@Override
	public void start(Stage primaryStage) throws IOException {
		Main.primaryStage = primaryStage;
		Main.primaryStage.setTitle("공간 점유도 분석");
		showMainView();
		showMainItems();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				try {
					String myDriver = "com.mysql.jdbc.Driver";
					Class.forName(myDriver);
					conn = DriverManager.getConnection(url, id, password);
					String query = "DELETE FROM inputdata;";
					String query1 = "DELETE FROM osdata;";
					Statement st = (Statement) conn.createStatement();
					Statement st1 = (Statement) conn.createStatement();
					st.executeUpdate(query);
					st1.executeUpdate(query1);
					System.out.println("프로그램 종료 & DB flush");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});// 종료될때 DB에 저장된 data 모두 제거
	}

	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("main/mainWindow.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void showMainItems() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("main/mainItems.fxml"));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
	}

	public static void showAdmin() throws IOException {
		First = true;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("admin/AdminMain.fxml"));
		BorderPane admin = loader.load();
		mainLayout.setCenter(admin);
	}

	public static void showUser() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("user/UsersMain.fxml"));
		BorderPane user = loader.load();
		mainLayout.setCenter(user);
	}

	public static void showPresentss() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("admin/presentSS.fxml"));
		BorderPane presentOc = loader.load();
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("상상랩 현재 현황");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene = new Scene(presentOc);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();
	}

	public static void showPresentos() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("admin/presentOS.fxml"));
		BorderPane presentOc = loader.load();
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("오석 현재 현황");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene = new Scene(presentOc);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();
	}

	public static void showSelectss() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("admin/SelectSS.fxml"));
		BorderPane selectOc = loader.load();
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("상상랩 시간 선택");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene = new Scene(selectOc);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();
	}

	public static void showSelectos() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("admin/SelectOS.fxml"));
		BorderPane selectOc = loader.load();
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("오석 시간 선택");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene = new Scene(selectOc);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
