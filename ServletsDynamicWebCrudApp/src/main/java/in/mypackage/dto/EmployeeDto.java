package in.mypackage.dto;

import java.io.Serializable;

public class EmployeeDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private String eid;
	private String ename;
	private Integer eage;
	private String email;
	private String emobile;
	

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEid() {
		return eid;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEname() {
		return ename;
	}

	public void setEage(Integer eage) {
		this.eage = eage;
	}

	public Integer getEage() {
		return eage;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmobile(String emobile) {
		this.emobile = emobile;
	}

	public String getEmobile() {
		return emobile;
	}

	@Override
	public String toString() {
		return "EmployeeDto [getEid()=" + getEid() + ", getEname()=" + getEname() + ", getEage()=" + getEage()
				+ ", getEmail()=" + getEmail() + ", getEmobile()=" + getEmobile() + "]";
	}

}
