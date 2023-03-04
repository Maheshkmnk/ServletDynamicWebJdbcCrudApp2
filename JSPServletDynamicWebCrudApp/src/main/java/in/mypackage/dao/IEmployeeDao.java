package in.mypackage.dao;

import in.mypackage.dto.Employee;

public interface IEmployeeDao {
	
	public String createEmp(String eid, String ename, Integer eage, Integer esalary);

	public Employee readEmp(String eid);

	public String updateEmp(Employee employee);

	public String deleteEmp(String eid);
	
}
