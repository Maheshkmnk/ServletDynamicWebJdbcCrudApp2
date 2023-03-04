package in.mypackage.service;

import in.mypackage.dao.IEmployeeDao;
import in.mypackage.daofactory.EmployeeDaoFactory;
import in.mypackage.dto.Employee;

public class EmployeeServiceImpl implements IEmployeeService {
	IEmployeeDao empDao = EmployeeDaoFactory.getEmployeeDao();

	@Override
	public String createEmp(String eid, String ename, Integer eage, Integer esalary) {
		return empDao.createEmp(eid, ename, eage, esalary);
	}

	@Override
	public Employee readEmp(String eid) {
		return empDao.readEmp(eid);
	}

	@Override
	public String updateEmp(Employee employee) {
		return empDao.updateEmp(employee);
	}

	@Override
	public String deleteEmp(String eid) {
		return empDao.deleteEmp(eid);
	}

}
