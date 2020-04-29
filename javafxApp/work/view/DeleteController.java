package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DeleteController implements Initializable {

	
	@FXML Button btnCheck;

	

	@FXML
	public void loginCheck(ActionEvent event) {
		try {
			
			Stage primaryStage = (Stage) btnCheck.getScene().getWindow();

            // 새 레이아웃 추가
			Pane pickView = FXMLLoader.load(getClass().getResource("pick.fxml"));
 
            // 씬에 레이아웃 추가
            Scene sc = new Scene(pickView);
 
            // 씬을 스테이지에서 상영
            primaryStage.setScene(sc);
            primaryStage.show();
            
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
