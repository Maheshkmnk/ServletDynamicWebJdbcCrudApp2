package in.mypackage.servicefactory;

import in.mypackage.service.EmployeeServiceImplementation;
import in.mypackage.service.IEmployeeService;

public class EmployeeServiceFactory {
	
	private static IEmployeeService empService= null;
	
	private EmployeeServiceFactory() {}
	
	public static IEmployeeService getEmployeeService() {
		if(empService == null) {
			empService = new EmployeeServiceImplementation();
		}
		return empService;
	}
	
	

}
