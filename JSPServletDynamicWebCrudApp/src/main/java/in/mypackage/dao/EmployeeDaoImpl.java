package in.mypackage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.mypackage.dto.Employee;
import in.mypackage.util.JdbcUtil;

public class EmployeeDaoImpl implements IEmployeeDao {

	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;
		
	
	@Override
	public String createEmp(String eid, String ename, Integer eage, Integer esalary) {
			
		String createQuery = "insert into employee2(eid, ename, eage, esalary)values(?,?,?,?)" ;
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null) {	
				pstmt = connection.prepareStatement(createQuery);
			}
			
			if(pstmt != null) {			
				pstmt.setString(1, eid);
				pstmt.setString(2, ename);
				pstmt.setInt(3, eage);
				pstmt.setInt(4, esalary);
				
				Integer rowAffect = pstmt.executeUpdate();
				if(rowAffect == 1) {
					return "success";
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "failure";
	}

	@Override
	public Employee readEmp(String eid) {
		
		String readQuery = "select eid, ename, eage, esalary from employee2 where eid=?";
		Employee employee = new Employee();
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null) {
				pstmt = connection.prepareStatement(readQuery);
			}
			
			if(pstmt != null) {
				pstmt.setString(1, eid);
				
				resultSet = pstmt.executeQuery();
				
				while(resultSet.next()) {
					employee.setEid(resultSet.getString("eid"));
					employee.setEname(resultSet.getString("ename"));
					employee.setEage(resultSet.getInt("eage"));
					employee.setEsalary(resultSet.getInt("esalary"));	
					
					return employee;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public String updateEmp(Employee employee) {
		String updateQuery = "update employee2 set ename=?, eage=?, esalary=? where eid=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null) {	
				pstmt = connection.prepareStatement(updateQuery);
			}
			
			if(pstmt != null) {			
				
				pstmt.setString(1, employee.getEname());
				pstmt.setInt(2, employee.getEage());
				pstmt.setInt(3, employee.getEsalary());
				pstmt.setString(4, employee.getEid());
				
				Integer rowAffect = pstmt.executeUpdate();
				if(rowAffect == 1) {
					return "success";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String deleteEmp(String eid) {
		String deleteQuery = "delete from employee2 where eid=?";
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null) {
				pstmt = connection.prepareStatement(deleteQuery);
			}
			
			if(pstmt != null) {
				pstmt.setString(1, eid);
				
				Integer rowAffect = pstmt.executeUpdate();
				
				if(rowAffect == 1) {
					return "success";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "failure";
	}
	
}
