package departments;

public class Departments {
	int deptId;
	String deptName;
	int mngrId;
	int lctnId;
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getMngrId() {
		return mngrId;
	}
	public void setMngrId(int mngrId) {
		this.mngrId = mngrId;
	}
	public int getLctnId() {
		return lctnId;
	}
	public void setLctnId(int lctnId) {
		this.lctnId = lctnId;
	}
	@Override
	public String toString() {
		return "Departments [deptId=" + deptId + ", deptName=" + deptName + ", mngrId=" + mngrId + ", lctnId=" + lctnId
				+ "]";
	}

}
