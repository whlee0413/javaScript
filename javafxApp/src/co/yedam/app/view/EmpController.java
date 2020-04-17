package co.yedam.app.view;

import java.net.URL;
import java.util.ResourceBundle;

import co.yedam.app.model.EmpDAO;
import co.yedam.app.model.EmpDO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class EmpController implements Initializable {

	@FXML
	TextField txtEmployeeId;

	@FXML
	TextField txtLastName;

	@FXML
	TextField txtEmail;

	@FXML
	TextField txtHireDate;

	@FXML
	TextField txtJobId;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

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

}
