package view;

import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.MenuDAO;
import model.MenuDO;
import model.ObserverMenuDO;

public class MenuController implements Initializable { //view랑 model이랑 연결하는게 controller

	@FXML TextField txtFoodName;

	@FXML TextField txtFoodKind;



	@FXML	TableView<MenuDO> tvMenu;
	@FXML  TableColumn<ObserverMenuDO, String> colFoodName;
	@FXML  TableColumn<ObserverMenuDO, String> colFoodKind;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		colFoodName.setCellValueFactory(new PropertyValueFactory<ObserverMenuDO, String>("FoodName"));
		colFoodKind.setCellValueFactory(new PropertyValueFactory<ObserverMenuDO, String>("FoodKind"));

	}

	@FXML // 등록버튼 click
	public void insertMenu(ActionEvent actionEvent) {
		//DAO 불러서 DB처리
		//텍스트필드값을 읽어서 DO 객체 담기
		MenuDO menu = new MenuDO();
		menu.setFoodName(txtFoodName.getText());
		menu.setFoodKind(txtFoodKind.getText());

		//DAO 등록
		MenuDAO dao =new MenuDAO();
		dao.insert(menu);
		System.out.println("등록처리됨");
	}

	@FXML
	public void empUpdate(ActionEvent actionEvent) {
		System.out.println("수정처리됨");
	}

	
	@FXML
	public void empSelect(ActionEvent actionEvent) {
		//조회할 메뉴 DO객체에 담기
		MenuDO menu = new MenuDO();
		menu.setFoodName(txtFoodName.getText());

		//단건조회 호출
		MenuDAO dao = new MenuDAO();
		MenuDO result = dao.selectOne(menu); //조회결과를 result에 담음
		
		//텍스트필드 표시     화면에 뿌림.
		txtFoodName.setText(result.getFoodName()); 
		txtFoodKind.setText(result.getFoodKind());
		System.out.println("조회처리됨");
	}
	@FXML	//전체조회 버튼 클릭 이벤트 핸들러
	public void empSelectAll(ActionEvent actionEvent) {
		MenuDAO dao = new MenuDAO();
		ArrayList<MenuDO> list = dao.selectAll();
		tvMenu.setItems(FXCollections.observableArrayList(list));
		
	}
	
	@FXML // 테이블뷰 마우스 클릭한 행의 정보를 텍스트필드에 표시
	public void empInfo(MouseEvent mouseEvent) {
		MenuDO menuDO = tvMenu.getSelectionModel().getSelectedItem();
		txtFoodName.setText(menuDO.getFoodName());
		txtFoodKind.setText(menuDO.getFoodKind());
	}
	
	
	//삭제
	@FXML
	protected void delMenu(ActionEvent event) {
        MenuDO menuDO = tvMenu.getSelectionModel().getSelectedItem();
        ObservableList<MenuDO> data = tvMenu.getItems();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("삭제 메시지");
        alert.setHeaderText("칼럼을 삭제하려합니다.");
        alert.setContentText("정말 삭제하시겠습니까?");

        Optional<ButtonType>result = alert.showAndWait();
        if(result.get() == ButtonType.OK) {
        	MenuDAO dao = new MenuDAO();
        	//DB에서 삭제
        	dao.delete(menuDO);
        	//tableview 에서 삭제
        	data.remove(menuDO);
        }
	}

	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
