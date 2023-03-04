package in.mypackage.servicefactory;

import in.mypackage.service.EmployeeServiceImpl;
import in.mypackage.service.IEmployeeService;

public class EmployeeServiceFactory {
	private static IEmployeeService employeeService = null;
	
	private EmployeeServiceFactory() {
	}
	
	public static IEmployeeService getEmployeeService() {
		if(employeeService == null) {
			employeeService = new EmployeeServiceImpl();
		}
		
		return employeeService;
	}
	
}
