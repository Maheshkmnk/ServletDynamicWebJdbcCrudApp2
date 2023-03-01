package in.mypackage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.mypackage.service.IEmployeeService;
import in.mypackage.servicefactory.EmployeeServiceFactory;

//@WebServlet("/delete")
public class DeleteOperation extends HttpServlet {
	private static final long serialVersionUID = 11345346654L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String eid = request.getParameter("eid");

		IEmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();

		String msg = employeeService.deleteRecord(eid);

		if (msg.equalsIgnoreCase("success")) {
			out.println("<h1>record deleted successfully.....</h1>");
		} else if (msg.equalsIgnoreCase("failure")) {
			out.println("<h1>given record not available.....</h1>");
		}
	}

}
