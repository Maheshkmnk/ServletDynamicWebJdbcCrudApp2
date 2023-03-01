package in.mypackage.service;

import in.mypackage.dto.EmployeeDto;
import in.mypackage.dao.IEmployeeDao;
import in.mypackage.daofactory.EmployeeDaoFactory;

public class EmployeeServiceImplementation implements IEmployeeService {

	private static IEmployeeDao empDao = EmployeeDaoFactory.getEmployeeDao();

	@Override
	public String insertRecord(String eid, String ename, Integer eage, String email, String emobile) {
		return empDao.insertRecord(eid, ename, eage, email, emobile);
	}

	@Override
	public String deleteRecord(String eid) {
		return empDao.deleteRecord(eid);
	}

	@Override
	public String updateRecord(EmployeeDto EmployeeDto) {
		return empDao.updateRecord(EmployeeDto);
	}

	@Override
	public EmployeeDto searchRecord(String eid) {
		return empDao.searchRecord(eid);
	}

}
