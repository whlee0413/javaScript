package co.yedam.app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AppMain  extends Application{
	
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    
	public static void main(String[] args) {
		launch(args);
		//new DeptFrame();
	}

	@Override
	public void start(Stage stage) throws Exception {
        //1)  primary stage 설정 (모든 메서드에서 사용 가능)
        this.primaryStage = stage;

        //Optional: 스테이지 타이틀 변경
        this.primaryStage.setTitle("사원관리");

        //2) Initialize RootLayout
        initRootLayout();

        //3) Display the EmployeeOperations View
        showDeptView();
        
	}
	
	   public void initRootLayout() {
	        try {
	            rootLayout = FXMLLoader.load(getClass().getResource("view/RootLayout.fxml"));

	            Scene scene = new Scene(rootLayout); 
	            primaryStage.setScene(scene); 

	            primaryStage.show();		
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public void showDeptView() {
	        try {
	        	AnchorPane deptView = FXMLLoader.load(getClass().getResource("view/deptView.fxml"));
	            rootLayout.setCenter(deptView);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
}
