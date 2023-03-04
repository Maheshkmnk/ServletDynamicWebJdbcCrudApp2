package in.mypackage.service;

import in.mypackage.dto.Employee;

public interface IEmployeeService {
	
	public String createEmp(String eid, String ename, Integer eage, Integer esalary);

	public Employee readEmp(String eid);

	public String updateEmp(Employee employee);

	public String deleteEmp(String eid);
}
