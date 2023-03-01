package in.mypackage.daofactory;

import in.mypackage.dao.EmployeeDaoImplementation;
import in.mypackage.dao.IEmployeeDao;

public class EmployeeDaoFactory {
	private static IEmployeeDao employeeDao = null;
	
	private EmployeeDaoFactory() {}
	
	public static IEmployeeDao getEmployeeDao() {
		
		if(employeeDao == null) {
			employeeDao = new EmployeeDaoImplementation();
		}
		
		return employeeDao;
	}
	
	
}
