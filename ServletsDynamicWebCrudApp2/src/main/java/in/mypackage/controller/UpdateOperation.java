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

//@WebServlet("/update")
public class UpdateOperation extends HttpServlet {
	private static final long serialVersionUID = 4646546546L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
		System.out.println(request.getRequestURI().endsWith("edit"));
		
		
		if (request.getRequestURI().endsWith("edit")) {
			String eid = request.getParameter("eid");
			EmployeeDto employeeDto = employeeService.searchRecord(eid);

			out.println("<body style='background-color: lightpink; '>");

			out.println("<h1>This are the current details of searched record ID to update </h1>");

			out.println("<form >");
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

			out.println("</form>");

			out.println(
					"<div style='border: 1px solid green; background-color: yellow; text-align : center; width:10%; margin-left: auto; margin-right: auto; margin-top: 10px;'>");
			out.println("<a href='./' style='font-color: green; '>Go to Registration Page</a>");
			out.println("</div>");

			out.println("<h1>Enter the details you want to update </h1>");

			out.println("<form method='post' action='./update'>");
			out.println(
					"<table style='background-color:lightblue; margin-left: auto; margin-right: auto; border: 1px solid black; '>");
			out.println(
					"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee ID: </td ><td style='border: 1px solid black';><input type='text' name='eid' value='"
							+ employeeDto.getEid() + "' readonly /></td></tr>");
			out.println(
					"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee Name:</td><td style='border: 1px solid black';><input name='ename' /></td></tr>");
			out.println(
					"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee Age:</td><td style='border: 1px solid black';><input name='eage' /></td></tr>");
			out.println(
					"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee Email:</td><td style='border: 1px solid black';><input name='email' /></td></tr>");
			out.println(
					"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee Mobile Number:</td><td style='border: 1px solid black';><input name='emobile' /></td></tr>");
			out.println("</table>");
			out.println(
					"<button style='border: 1px solid green; background-color: yellow; text-align : center; width:10%; margin-left: auto; margin-right: auto; margin-top: 10px;'>Submit</button>");
			out.println("</form>");

			out.println("</div>");

			out.println("</body>");
		}

		if (request.getRequestURI().endsWith("update")) {
			String eid = request.getParameter("eid");
			String ename = request.getParameter("ename");
			String eage = request.getParameter("eage");
			String email = request.getParameter("email");
			String emobile = request.getParameter("emobile");
			
			EmployeeDto employeeDto = new EmployeeDto();
			
			
			employeeDto.setEid(eid);
			employeeDto.setEname(ename);
			employeeDto.setEage(Integer.parseInt(eage));
			employeeDto.setEmail(email);
			employeeDto.setEmobile(emobile);
			
			System.out.println(Integer.parseInt(eage));
			System.out.println(employeeDto.getEage());
			
			String msg = employeeService.updateRecord(employeeDto);
			if(msg.equalsIgnoreCase("success")) {
				out.println("<h1>Successfully updated the selected record...</h1>");
			}else {
				out.println("<h1>failed to update the selected record...</h1>");
			}
			
		}

	}

}
