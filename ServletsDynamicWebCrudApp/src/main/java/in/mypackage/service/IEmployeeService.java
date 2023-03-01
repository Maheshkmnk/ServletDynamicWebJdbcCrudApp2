package in.mypackage.service;

import in.mypackage.dto.EmployeeDto;

public interface IEmployeeService {

	public String insertRecord(String eid, String ename, Integer eage, String email, String emobile);

	public String deleteRecord(String eid);
	
	public String updateRecord(EmployeeDto EmployeeDto);
	
	public EmployeeDto searchRecord(String eid);
	
}
