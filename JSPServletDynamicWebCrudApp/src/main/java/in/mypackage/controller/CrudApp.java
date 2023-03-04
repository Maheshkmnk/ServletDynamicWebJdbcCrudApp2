package in.mypackage.controller;

import java.util.Scanner;

import in.mypackage.dto.Employee;
import in.mypackage.service.IEmployeeService;
import in.mypackage.servicefactory.EmployeeServiceFactory;



public class CrudApp {
	static Scanner sc = new Scanner(System.in);
	private static IEmployeeService studentService;

	public static void main(String[] args) {
		for(int i=1; i>0; i++) {
			System.out.println("\n\t1.Insert\n\t2.Update\n\t3.Delete\n\t4.Read\n\t5.Exit");
			System.out.println("Enter the operation number which you want to do....");
			int opNumber = Integer.parseInt(sc.next());
			if(opNumber!=5) {
				switch(opNumber) {
				case 1: insert();
						break;
						
				case 2: updateStudent();
						break;
						
				case 3: deleteStudent();
						break;
						
				case 4: searchStudent();
						break;
						
				case 5: break;
				
				default: System.out.println("Choose proper option in the given list!");
						 break;
				}
			}else {
				System.out.println("Thank you for using our application...visit again");
				break;
			}
		}
	}

	public static void insert() {
		System.out.println("Enter Student id:");
		String eid = sc.next();
		System.out.println("Enter Student name:");
		String ename = sc.next();
		System.out.println("Enter student Age:");
		int eage = sc.nextInt();
		System.out.println("Enter student Salary:");
		int esalary = sc.nextInt();

		studentService = EmployeeServiceFactory.getEmployeeService();

		String msg = studentService.createEmp(eid, ename, eage, esalary);

		if (msg.equals("success")) {
			System.out.println("Record inserted successfully......");
		} else {
			System.out.println("Record insertion failed.......");
		}

	}

	public static void searchStudent() {
		System.out.println("Enter student id that you want to see : ");
		String eid = sc.next();
		Employee student = null;
		studentService = EmployeeServiceFactory.getEmployeeService();

		student = studentService.readEmp(eid);

		if (student != null) {
			//System.out.println(student);
			System.out.println(student.getEid() + "\t" + student.getEname() + "\t" + student.getEage() + "\t" + student.getEsalary());

		} else {
			System.out.println("Record not found for the given record id of " + eid);
		}

	}

	public static void updateStudent() {
		System.out.println("enter the student id you want to update :");
		String eid = sc.next();

		studentService = EmployeeServiceFactory.getEmployeeService();

		Employee oldStd = studentService.readEmp(eid);

		if (oldStd != null) {
			Employee newStd = new Employee();

			System.out.println("current student detail of the searched student id " + eid+" are \n");
			System.out.println(oldStd.getEname() + "\t" + oldStd.getEage() + "\t" + oldStd.getEsalary()+"\n");
			
			newStd.setEid(oldStd.getEid());
			
			System.out.println("if you want to update new name please enter....");
			String ename = sc.next();
			if(ename.equals("") | ename == "") {
				newStd.setEname(oldStd.getEname());
			}else {
				newStd.setEname(ename);
			}
			
			System.out.println("if you want to update new age please enter....");
			String eage = sc.next();
			if(eage.equals("") | eage == "") {
				newStd.setEage(oldStd.getEage());
			}else {
				newStd.setEage(Integer.parseInt(eage));
			}
			
			System.out.println("if you want to update new salary please enter....");
			String esalary = sc.next();
			if(esalary.equals("") | esalary == "") {
				newStd.setEsalary(oldStd.getEsalary());
			}else {
				newStd.setEsalary(Integer.parseInt(esalary));
			}
			
			System.out.println("new object data is : "+ newStd);
			
			String msg = studentService.updateEmp(newStd);
			
			
			if(msg.equals("success")) {
				System.out.println("Record updated successfully");
			}
			else {
				System.out.println("Record updation failed......");
			}
		}
		
		
	}

	public static  void deleteStudent() {
		
		System.out.println("Enter Student id which you want to delete.....");
		
		String eid = sc.next();
		
		studentService = EmployeeServiceFactory.getEmployeeService();
		
		String msg = studentService.deleteEmp(eid);
		
		if(msg.equalsIgnoreCase("success")) {
			System.out.println("Record deleted successfully...");
		}else {
			System.out.println("Entered Id not found in the records, please try with proper id.......");
		}	
	}

}
