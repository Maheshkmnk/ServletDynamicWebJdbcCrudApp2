package in.mypackage.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class InsertFilterValidation implements Filter {

	public InsertFilterValidation() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String eid_error_msg = "";
		String ename_error_msg = "";
		String eage_error_msg = "";
		String email_error_msg = "";
		String emobile_error_msg = "";
		boolean flag = true;

		PrintWriter out = response.getWriter();

		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String eage = request.getParameter("eage");
		String email = request.getParameter("email");
		String emobile = request.getParameter("emobile");

		if (eid.equals("") || eid == null) {
			eid_error_msg = "Employee id is required";
			flag = false;
		} else {
			if (!eid.startsWith("kmnk-")) {
				eid_error_msg = "Employee id must start with 'kmnk-'";
				flag = false;
			}
		}

		if (ename.equals("") || ename == null) {
			ename_error_msg = "Employee Name is required";
			flag = false;
		}

		if (eage.equals("") || eage == null) {
			eage_error_msg = "Employee Age is required";
			flag = false;
		} else {
			if (!(Integer.parseInt(eage) > 20 && Integer.parseInt(eage) < 30)) {
				eage_error_msg = "Employee Age should be in between 20 to 30";
				flag = false;
			}
		}

		if (email.equals("") || email == null) {
			email_error_msg = "Employee Email is required";
			flag = false;
		} else {
			if (!email.endsWith("@kmnk.com")) {
				email_error_msg = "Employee Email must ends with '@kmnk.com'";
				flag = false;
			}
		}

		if (emobile.equals("") || emobile == null) {
			emobile_error_msg = "Employee mobile number is required";
			flag = false;
		} else {
			if (!emobile.startsWith("+91")) {
				emobile_error_msg = "Employee mobile number must start with '+91'";
				flag = false;
			}
		}

		if (flag == false) {
			out.println("<body style='background-color: lightpink; '>");

			out.println("<h1>Please correct the detail respective format...... </h1>");

			out.println(
					"<table style='background-color:lightblue; margin-left: auto; margin-right: auto; border: 1px solid black; '>");
			out.println(
					"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee ID: </td ><td style='border: 1px solid black';>"
							+ eid + "</td><td style='border: 1px solid black';>" + eid_error_msg + "</td></tr>");
			out.println(
					"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee Name:</td><td style='border: 1px solid black';>"
							+ ename + "</td><td style='border: 1px solid black';>" + ename_error_msg + "</td></tr>");
			out.println(
					"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee Age:</td><td style='border: 1px solid black';>"
							+ eage + "</td><td style='border: 1px solid black';>" + eage_error_msg + "</td></tr>");
			out.println(
					"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee Email:</td><td style='border: 1px solid black';>"
							+ email + "</td><td style='border: 1px solid black';>" + email_error_msg + "</td></tr>");
			out.println(
					"<tr style='border: 1px solid black'><td style='border: 1px solid black'>Employee Mobile Number:</td><td style='border: 1px solid black';>"
							+ emobile + "</td><td style='border: 1px solid black';>" + emobile_error_msg
							+ "</td></tr>");
			out.println("</table>");

			out.println(
					"<div style='border: 1px solid green; background-color: yellow; text-align : center; width:10%; margin-left: auto; margin-right: auto; margin-top: 10px;'>");
			out.println("<a href='./' style='font-color: green; '>Go to Registration Page</a>");
			out.println("</div>");

			out.println("</body>");

		} else {
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
