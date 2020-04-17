package co.yedam.app.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import co.yedam.app.model.Departments;
import co.yedam.app.model.DepartmentsTable;
import co.yedam.app.model.Employee;
import co.yedam.app.service.impl.DeptServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class DeptController implements Initializable  {

	DeptServiceImpl deptService = DeptServiceImpl.getInstance();
	
	@FXML private Button btnInsert;
	@FXML private Button btnUpdate;
	@FXML private Button btnDelete;
	@FXML private Button btnSelect;
	@FXML private Button btnSelectAll;
	
	@FXML private TextField txtDepartmentId;
	@FXML private TextField txtDepartmentName;
	@FXML private TextField txtManagerId;
	@FXML private TextField txtLocationId;	
	@FXML private TextField txtSearch;	
	@FXML private TextArea areaResult;
	
	@FXML private TableView<DepartmentsTable> tvDept;
	@FXML private TableColumn<DepartmentsTable, Integer> columnDepartmentId;
	@FXML private TableColumn<DepartmentsTable, String> columnDepartmentName;
	@FXML private TableColumn<DepartmentsTable, Integer> columnManagerId;
	@FXML private TableColumn<DepartmentsTable, Integer> columnLocationId;
	
    private Executor exec;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		columnDepartmentId.setCellValueFactory(cellData -> cellData.getValue().deoartment_idProperty().asObject());
        columnDepartmentName.setCellValueFactory(cellData -> cellData.getValue().department_nameProperty());
        columnManagerId.setCellValueFactory(cellData -> cellData.getValue().manager_idProperty().asObject());
        columnLocationId.setCellValueFactory(cellData -> cellData.getValue().location_idProperty().asObject());
        
        exec = Executors.newCachedThreadPool((runnable) -> {
            Thread t = new Thread (runnable);
            t.setDaemon(true);
            return t;
        });
	}
	
	@FXML
	public void insertDept(ActionEvent event) {
        try {
        	Departments dept = new Departments();
        	if(txtDepartmentId.getText() == null || txtDepartmentId.getText().isEmpty()) {
        		areaResult.setText("부서번호 필수 입력 \n");
        		return;
        	}  	
        	
        	if(txtDepartmentName.getText() == null || txtDepartmentName.getText().isEmpty()) {
        		areaResult.setText("부서명 필수입력 \n");
        		return;
        	}
        	dept.setDepartment_id(Integer.parseInt(txtDepartmentId.getText()));
        	dept.setDepartment_name(txtDepartmentName.getText());
        	if(txtManagerId.getText() != null && !txtManagerId.getText().isEmpty())
        		dept.setManager_id(Integer.parseInt(txtManagerId.getText()));
        	if(txtLocationId.getText() != null  && !txtLocationId.getText().isEmpty())
        		dept.setLocation_id(Integer.parseInt(txtLocationId.getText()));
        	
            deptService.insert(dept);
            areaResult.setText("dept inserted! \n");
        } catch (Exception e) {
        	areaResult.setText("Problem occurred while inserting dept " + e);
            throw e;
        }
	}

	@FXML
	public void updateDept(ActionEvent event) {
        try {
        	Departments dept = new Departments();
        	dept.setDepartment_id(Integer.parseInt(txtDepartmentId.getText()));
        	dept.setDepartment_name(txtDepartmentName.getText());
        	dept.setManager_id(Integer.parseInt(txtManagerId.getText()));
        	dept.setLocation_id(Integer.parseInt(txtLocationId.getText()));
            deptService.update(dept);
            areaResult.setText("dept updateed! \n");
        } catch (Exception e) {
        	areaResult.setText("Problem occurred while updating dept " + e);
            throw e;
        }
	}
	
	@FXML
	public void DeleteDept(ActionEvent event) {
        try {
        	int departmentId= Integer.parseInt(txtDepartmentId.getText());
            deptService.delete(departmentId);
            areaResult.setText("dept deleted! \n");
        } catch (Exception e) {
        	areaResult.setText("Problem occurred while deleting dept " + e);
            throw e;
        }
	}
	
	@FXML
	public void SelectDept(ActionEvent event) {
        try {
        	int departmentId= Integer.parseInt(txtSearch.getText());
            Departments dept = deptService.selectOne(departmentId);
            
            showDeptDetails(dept);
            
        } catch (Exception e) {
        	areaResult.setText("Problem occurred while selecting dept " + e);
            throw e;
        }
	}

	@FXML
	public void SelectAllDept(ActionEvent event) {
		/*
		 * List<DepartmentsTable> list = deptService.selectAllTable();
		 * ObservableList<DepartmentsTable> obsList =
		 * FXCollections.observableArrayList(list); tvDept.setItems(obsList);
		 */

		Task<ObservableList<DepartmentsTable>> task = new Task<ObservableList<DepartmentsTable>>() {
			@Override
			public ObservableList<DepartmentsTable> call() throws Exception {
				List<DepartmentsTable> list = deptService.selectAllTable();
				ObservableList<DepartmentsTable> obsList = FXCollections.observableArrayList(list);
				return obsList;
			}
		};

		task.setOnFailed(e -> task.getException().printStackTrace());
		task.setOnSucceeded(e -> tvDept.setItems((ObservableList<DepartmentsTable>) task.getValue()));
		exec.execute(task);
	}
	
	private void showDeptDetails(Departments dept) {
        if(dept != null) {
        	txtDepartmentId.setText(dept.getDepartment_id().toString());
        	txtDepartmentName.setText(dept.getDepartment_name());
        	txtManagerId.setText(dept.getManager_id().toString());
        	txtLocationId.setText(dept.getLocation_id().toString());
        	areaResult.setText("dept seleted! \n");
        } else {
        	txtDepartmentId.setText("");
        	txtDepartmentName.setText("");
        	txtManagerId.setText("");
        	txtLocationId.setText("");
        	areaResult.setText("dept no seleted " );
        }
	}
}
