package co.yedam.app.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootLayoutController implements Initializable {

	@FXML
	MenuBar menuBar;
	@FXML
	BorderPane rootLayout;
	@FXML
	Button btnStart;
	@FXML
	Button btnStop;
	@FXML
	Label lblTimer;

	Task<Void> task;


	@FXML
	public void handlerTimer(ActionEvent actionEvent) {
		SimpleDateFormat sdt = new SimpleDateFormat("HH:mm:ss");
		lblTimer.setText("FXML:" + sdt.format(new Date()));
	}

	@FXML
	public void handlerStopTimer(ActionEvent actionEvent) {
		task.cancel();
	}

	class handlerTimerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			SimpleDateFormat sdt = new SimpleDateFormat("HH:mm:ss");
			lblTimer.setText("핸들러클래스:" + sdt.format(new Date()));
		}
	}


	
	public void handlerTimerThread(ActionEvent actionEvent) {
		task = new Task<Void>() {
			@Override
			protected Void call() {
				SimpleDateFormat sdt = new SimpleDateFormat("HH:mm:ss");
				while (true) {
					if (isCancelled()) {
						break;
					}
					Platform.runLater(() -> {
						lblTimer.setText("task:" + sdt.format(new Date()));
					});
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						if (isCancelled()) {
							break;
						}
					}
				}
				return null;
			}

			@Override
			protected void succeeded() {
				System.out.println("success");
			}

		};
		task.setOnFailed(e -> task.getException().printStackTrace());
		task.setOnCancelled(e -> {
			System.out.println("cancel");
		});

		Thread thread = new Thread(task);
		thread.setDaemon(true); // 데몬쓰레드로 (메인쓰레드 종료시 종속쓰레드는 작업 다 못끝내도 메인 쓰레드와 함께 종료된다.)
		thread.start();
	}


	private TimeService timeService;
	
	class TimeService extends Service<Void> {

		@Override
		protected Task<Void> createTask() {
			Task<Void> task = new Task<Void>() {
				@Override
				protected Void call() {
					SimpleDateFormat sdt = new SimpleDateFormat("HH:mm:ss");
					while (true) {
						if (isCancelled()) {
							break;
						}
						Platform.runLater(() -> {
							lblTimer.setText("task:" + sdt.format(new Date()));
						});
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							if (isCancelled()) {
								break;
							}
						}
					}
					return null;
				}
			};
			return task;
		}

	}
	public void handlerTimerServiceStart(ActionEvent actionEvent) {
		timeService = new TimeService();
		timeService.start();
	}

	public void handlerTimerServiceStop(ActionEvent actionEvent) {
		timeService.cancel();
	}

	public void handlerTimerServiceRestart(ActionEvent actionEvent) {
		timeService.restart();
	}
	
    //For MultiThreading
    private Executor exec;
	public void handlerTimerServicePoolStop(ActionEvent actionEvent) {
		task.cancel();
	}
	public void handlerTimerThreadPool(ActionEvent actionEvent) {
		task = new Task<Void>() {
			@Override
			protected Void call() {
				SimpleDateFormat sdt = new SimpleDateFormat("HH:mm:ss");
				while (true) {
					if (isCancelled()) {
						break;
					}
					Platform.runLater(() -> {
						lblTimer.setText("pool:" + sdt.format(new Date()));
					});
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						if (isCancelled()) {
							break;
						}
					}
				}
				return null;
			}

			@Override
			protected void succeeded() {
				System.out.println("success");
			}

		};
		task.setOnFailed(e -> task.getException().printStackTrace());
		task.setOnCancelled(e -> {
			System.out.println("cancel");
		});

		exec.execute(task);
		//exec.submit(task);
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//For multithreading: Create executor that uses daemon threads:
		exec = Executors.newCachedThreadPool((runnable) -> {
            Thread t = new Thread (runnable);
            t.setDaemon(true);
            return t;
        });
		
		btnStart.setOnAction(event -> handlerTimerThreadPool(event));
		//btnStop.setOnAction(event -> handlerTimerServiceStop(event));
		
		File file = new File("d:/log.txt");
		PrintStream printStream = null;
		try {
			printStream = new PrintStream(new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// console로 출력
		System.out.println("Hello World!");
		PrintStream sysout = System.out;
		// standard out과 err을 file로 변경
	//	System.setOut(printStream);
	}

	// Exit the program
	@FXML
	public void handleExit(ActionEvent actionEvent) {
		System.exit(0);
	}

	// Help Menu button behavior
	@FXML
	public void handleHelp(ActionEvent actionEvent) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Program Information");
		alert.setHeaderText("This is a sample JAVAFX application for SWTESTACADEMY!");
		alert.setContentText("You can search, delete, update, insert a new employee with this program.");
		alert.show();
	}

	@FXML
	public void handlePageEmp(ActionEvent actionEvent) {
		try {
			AnchorPane empView = FXMLLoader.load(getClass().getResource("employeeView.fxml"));
			rootLayout.setCenter(empView);
			/*
			 * Scene scene = new Scene(empView);
			 * 
			 * Stage primaryStage=(Stage)menuBar.getScene().getWindow();
			 * primaryStage.setScene(scene); primaryStage.show();
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void handlePageDept(ActionEvent actionEvent) {
		try {
			AnchorPane deptView = FXMLLoader.load(getClass().getResource("DeptView.fxml"));
			rootLayout.setCenter(deptView);
			System.out.println("change dept");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@FXML
	public void handlePage(ActionEvent actionEvent) {
		try {
			AnchorPane deptView = FXMLLoader.load(getClass().getResource("/co/yedam/app/view/LoginView.fxml"));
			Scene scene = new Scene(deptView);

			Stage primaryStage = (Stage) menuBar.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@FXML
	public void handlePopup(ActionEvent actionEvent) {
		try {
			Popup popup = new Popup();
			popup.setX(300);
			popup.setY(200);
			AnchorPane loginView = FXMLLoader.load(getClass().getResource("/co/yedam/app/view/LoginView.fxml"));
			popup.getContent().add(loginView);
			Stage primaryStage = (Stage) menuBar.getScene().getWindow();
			popup.show(primaryStage, 300, 300);
			// miDeptview.gets
			// Person tempPerson = new Person();
			// boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void handleDialog(ActionEvent actionEvent) {
		try {
			AnchorPane loginView = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
			Stage primaryStage = (Stage) menuBar.getScene().getWindow();

			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(primaryStage);
			dialog.setTitle("로그인");

			AnchorPane aPane = (AnchorPane) FXMLLoader.load(getClass().getResource("custom_dialog.fxml"));
			Label txtTitle = (Label) aPane.lookup("#txtTitle");
			txtTitle.setText("확인하셨습니까?");
			Button btnOk = (Button) aPane.lookup("#btnOk");
			btnOk.setOnAction(event -> dialog.close());

			Scene scene = new Scene(loginView);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
