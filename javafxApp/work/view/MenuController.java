package view;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.MenuDAO;
import model.MenuDO;


public class MenuController implements Initializable{

	
	@FXML
	TextField txtType;
	@FXML
	TextField txtName;
	

	@FXML //등록버튼 click 
	public void meunInsert(ActionEvent actionEvent) {
		//DAO
		//텍스트필드값을 읽어서 DO 객체 담기
		MenuDO meun = new MenuDO();
		meun.setType(txtType.getText());
		meun.setName(txtName.getText());
		
		System.out.println("등록처리됨");
		
		//DAO 등록
		MenuDAO dao = new MenuDAO();
		dao.insert(meun);
	}
	
	@FXML 
	public void menuDelete(ActionEvent actionEvent) {
		System.out.println("삭제");
	}
	@FXML  
	public void selectAll(ActionEvent actionEvent) {
		//조회할 사번을 DO 객체에 담기
		MenuDO menu = new MenuDO();
		menu.setType(txtType.getText());
		menu.setName(txtName.getText());
		
		//단건조회
		MenuDAO dao = new MenuDAO();
		MenuDO result = dao.selectAll(menu);
		
		//텍스트 필드에 표시
		txtType.setText(result.getType());
		txtName.setText(result.getName());
		System.out.println("조회처리됨");
		
	}

	@FXML  
	public void selectRandom(ActionEvent actionEvent) {
		//조회할 사번을 DO 객체에 담기
		MenuDO menu = new MenuDO();
		menu.setName(txtName.getText());
		
		//단건조회
		MenuDAO dao = new MenuDAO();
		MenuDO result = dao.selectAll(menu);
		
		//텍스트 필드에 표시
		txtName.setText(result.getName());
		System.out.println("조회처리됨");
		
	}
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}