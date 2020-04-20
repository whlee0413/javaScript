package co.yedam.app.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import co.yedam.app.model.EmpDAO;
import co.yedam.app.model.EmpDO;
import co.yedam.app.model.ObserverEmpDO;
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

public class EmpController implements Initializable { //view랑 model이랑 연결하는게 controller

	@FXML TextField txtEmployeeId;

	@FXML TextField txtLastName;

	@FXML  TextField txtEmail;

	@FXML TextField txtHireDate;

	@FXML TextField txtJobId;

	@FXML	TableView<EmpDO> tvEmp;
	@FXML  TableColumn<ObserverEmpDO, String> colEmployeeId;
	@FXML  TableColumn<ObserverEmpDO, String> colLastName;
	@FXML  TableColumn<ObserverEmpDO, String> colEmail;
	@FXML  TableColumn<ObserverEmpDO, String> colHireDate;
	@FXML  TableColumn<ObserverEmpDO, String> colJobId;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		colEmployeeId.setCellValueFactory(new PropertyValueFactory<ObserverEmpDO, String>("employeeId"));
		colLastName.setCellValueFactory(new PropertyValueFactory<ObserverEmpDO, String>("lastName"));
		colEmail.setCellValueFactory(new PropertyValueFactory<ObserverEmpDO, String>("email"));
		colHireDate.setCellValueFactory(new PropertyValueFactory<ObserverEmpDO, String>("hireDate"));
		colJobId.setCellValueFactory(new PropertyValueFactory<ObserverEmpDO, String>("jobId"));

	}

	@FXML // 등록버튼 click
	public void empInsert(ActionEvent actionEvent) {
		//DAO 불러서 DB처리
		//텍스트필드값을 읽어서 DO 객체 담기
		EmpDO emp = new EmpDO();
		emp.setEmployeeId(txtEmployeeId.getText());
		emp.setEmail(txtEmail.getText());
		emp.setHireDate(txtHireDate.getText());
		emp.setJobId(txtJobId.getText());
		emp.setLastName(txtLastName.getText());

		//DAO 등록
		EmpDAO dao =new EmpDAO();
		dao.insert(emp);
		System.out.println("등록처리됨");
	}

	@FXML
	public void empUpdate(ActionEvent actionEvent) {
		System.out.println("수정처리됨");
	}

	
	@FXML
	public void empSelect(ActionEvent actionEvent) {
		//조회할 사번을 DO객체에 담기
		EmpDO emp = new EmpDO();
		emp.setEmployeeId(txtEmployeeId.getText());

		//단건조회 호출
		EmpDAO dao = new EmpDAO();
		EmpDO result = dao.selectOne(emp); //조회결과를 result에 담음
		
		//텍스트필드 표시     화면에 뿌림.
		txtEmployeeId.setText(result.getEmployeeId()); 
		txtLastName.setText(result.getLastName());
		txtJobId.setText(result.getJobId());
		txtEmail.setText(result.getEmail());
		txtHireDate.setText(result.getHireDate());
		System.out.println("조회처리됨");
	}
	@FXML	//전체조회 버튼 클릭 이벤트 핸들러
	public void empSelectAll(ActionEvent actionEvent) {
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpDO> list = dao.selectAll();
		tvEmp.setItems(FXCollections.observableArrayList(list));
		
	}
	
	@FXML // 테이블뷰 마우스 클릭한 행의 정보를 텍스트필드에 표시
	public void empInfo(MouseEvent mouseEvent) {
		EmpDO empDO = tvEmp.getSelectionModel().getSelectedItem();
		txtEmployeeId.setText(empDO.getEmployeeId());
		txtLastName.setText(empDO.getEmployeeId());
		txtEmail.setText(empDO.getEmail());
		txtHireDate.setText(empDO.getHireDate());
		txtJobId.setText(empDO.getJobId());
	}
	
	
	//삭제
	@FXML
	protected void delEmp(ActionEvent event) {
        EmpDO empDO = tvEmp.getSelectionModel().getSelectedItem();
        ObservableList<EmpDO> data = tvEmp.getItems();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("삭제 메시지");
        alert.setHeaderText("칼럼을 삭제하려합니다.");
        alert.setContentText("정말 삭제하시겠습니까?");

        Optional<ButtonType>result = alert.showAndWait();
        if(result.get() == ButtonType.OK) {
        	EmpDAO dao = new EmpDAO();
        	//DB에서 삭제
        	dao.delete(empDO);
        	//tableview 에서 삭제
        	data.remove(empDO);
        }
	}
}
