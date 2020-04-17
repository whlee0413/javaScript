package co.yedam.app.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DepartmentsTable {

	private IntegerProperty department_id;
	private StringProperty department_name;
	private IntegerProperty manager_id;
	private IntegerProperty location_id;

	public DepartmentsTable() {
		department_id = new SimpleIntegerProperty();
		department_name = new SimpleStringProperty();
		manager_id= new SimpleIntegerProperty();
		location_id= new SimpleIntegerProperty();
	}
	public IntegerProperty deoartment_idProperty() {
		return department_id;
	}
	public StringProperty department_nameProperty() {
		return department_name;
	}
	public IntegerProperty manager_idProperty() {
		return manager_id;
	}
	public IntegerProperty location_idProperty() {
		return location_id;
	}
	
	public Integer getDepartment_id() {
		return department_id.get();
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id.set(department_id);
	}

	public String getDepartment_name() {
		return department_name.get();
	}

	public void setDepartment_name(String department_name) {
		this.department_name.set(department_name);
	}

	public Integer getManager_id() {
		return manager_id.get();
	}

	public void setManager_id(Integer manager_id) {
		this.manager_id.set(manager_id);
	}

	public Integer getLocation_id() {
		return location_id.get();
	}

	public void setLocation_id(Integer location_id) {
		this.location_id.set(location_id);
	}

	@Override
	public String toString() {
		return "Deaprtments [department_id=" + department_id.get() + ", department_name=" + department_name.get() + ", manager_id="
				+ manager_id.get() + ", location_id=" + location_id.get() + "]";
	}
	
}
