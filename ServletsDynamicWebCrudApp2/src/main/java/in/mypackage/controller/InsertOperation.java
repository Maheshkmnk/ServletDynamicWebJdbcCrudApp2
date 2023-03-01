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


//@WebServlet("/insert")
public class InsertOperation extends HttpServlet {
	private static final long serialVersionUID = 2546546546L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		PrintWriter out = response.getWriter();
		
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String eage = request.getParameter("eage");
		String email = request.getParameter("email");
		String emobile = request.getParameter("emobile");
		
		IEmployeeService empService = EmployeeServiceFactory.getEmployeeService();
		
		String msg = empService.insertRecord(eid, ename, Integer.parseInt(eage), email, emobile);
		
		if(msg.equalsIgnoreCase("success")) {
			out.println("<h1>Successfully Record inserted......</h1>");
		}
	}

}
