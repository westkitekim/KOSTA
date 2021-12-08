package org.kosta.myproject.model.domain;

public class DepartmentDTO {
	private int deptNo;
	private String dname;
	private String loc;
	
	public DepartmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DepartmentDTO(int deptNo, String dname, String loc) {
		super();
		this.deptNo = deptNo;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [deptNo=" + deptNo + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
}
