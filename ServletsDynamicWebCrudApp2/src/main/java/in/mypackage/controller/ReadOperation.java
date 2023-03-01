package in.mypackage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.mypackage.dto.EmployeeDto;
import in.mypackage.service.IEmployeeService;
import in.mypackage.servicefactory.EmployeeServiceFactory;

//@WebServlet("/read")
public class ReadOperation extends HttpServlet {
	private static final long serialVersionUID = 356846746L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ReadOperation called");
		PrintWriter out = response.getWriter();
		String eid = request.getParameter("eid");
		
		System.out.println(eid);
		
		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		EmployeeDto employeeDto = employeeService.searchRecord(eid);
		
		System.out.println(employeeDto.getEid());
		System.out.println(employeeDto.getEname());
		System.out.println(employeeDto.getEage());
		System.out.println(employeeDto.getEmail());
		System.out.println(employeeDto.getEmobile());
		
		out.println("<body style='background-color: lightpink; '>");

		out.println("<h1>Please correct the detail respective format...... </h1>");

		out.println(
				"<table style='background-color:lightblue; margin-left: auto; margin-right: auto; border: 1px solid black; '>");
		out.println(
				"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee ID: </td ><td style='border: 1px solid black';>"
						+ employeeDto.getEid() + "</td></tr>");
		out.println(
				"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee Name:</td><td style='border: 1px solid black';>"
						+ employeeDto.getEname() + "</td></tr>");
		out.println(
				"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee Age:</td><td style='border: 1px solid black';>"
						+ employeeDto.getEage() + "</td></tr>");
		out.println(
				"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee Email:</td><td style='border: 1px solid black';>"
						+ employeeDto.getEmail() + "</td></tr>");
		out.println(
				"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee Mobile Number:</td><td style='border: 1px solid black';>"
						+ employeeDto.getEmobile() + "</td></tr>");
		out.println("</table>");

		out.println(
				"<div style='border: 1px solid green; background-color: yellow; text-align : center; width:10%; margin-left: auto; margin-right: auto; margin-top: 10px;'>");
		out.println("<a href='./' style='font-color: green; '>Go to Registration Page</a>");
		out.println("</div>");

		out.println("</body>");
	}

}
