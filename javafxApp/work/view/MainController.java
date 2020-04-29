package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController implements Initializable{

	
	@FXML Pane rootLayout;
	
	@FXML Button regiBtn;
	@FXML Button deleBtn;
	@FXML Button allBtn;
	@FXML Button randomBtn;
	@FXML Button back;
	
	@FXML CheckBox jap;
	@FXML CheckBox wes;
	@FXML CheckBox chi;

	@FXML
	public void pickView(ActionEvent event) { 
		try {
			Button pickView = FXMLLoader.load(getClass().getResource("pick.fxml"));
			back.getScene(); // rootLayout = BorderPane의 센터에 끼워 넣는다
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void allView(ActionEvent event) { 
		try {
			Pane allView = FXMLLoader.load(getClass().getResource("result.fxml"));
			back.getScene();// rootLayout = BorderPane의 센터에 끼워 넣는다
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@FXML
	public void regiView(ActionEvent event) {
		try {
			Pane regiView = FXMLLoader.load(getClass().getResource("regi.fxml"));
			regiBtn.getScene();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@FXML
	public void deleteView(ActionEvent event) {
		try {
			Pane deleteView = FXMLLoader.load(getClass().getResource("Delete.fxml"));
			Stage primaryStage = (Stage) deleBtn.getScene().getWindow();

			Stage dialog = new Stage(StageStyle.UTILITY); //dialog 다른 창 구현
			dialog.initModality(Modality.WINDOW_MODAL); //Modality 원래창 못움직이게 막음
			dialog.initOwner(primaryStage);
			dialog.setTitle("메뉴 삭제");

			Scene scene = new Scene(deleteView);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show(); //보이게 하는 부

		} catch (Exception e) {
			e.printStackTrace();
		}		
	}


	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
