package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("pick.fxml"));
		Scene scene = new Scene(root, 600, 450);
		stage.setTitle("FXML welcom");
		stage.setScene(scene);
		stage.show();
	}

}

