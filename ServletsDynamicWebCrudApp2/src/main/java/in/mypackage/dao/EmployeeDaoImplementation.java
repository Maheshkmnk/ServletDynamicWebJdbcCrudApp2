package in.mypackage.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.mypackage.dto.EmployeeDto;
import in.mypackage.util.JdbcUtil;

public class EmployeeDaoImplementation implements IEmployeeDao {

	Connection connection = null;
	ResultSet resultSet = null;
	PreparedStatement pstmt = null;
	
	
	@Override
	public String insertRecord(String eid, String ename, Integer eage, String email, String emobile) {
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			String queryString = "insert into employee(eid, ename, eage, email, emobile )values(?,?,?,?,?)";
			
			if(connection != null) {
				pstmt = connection.prepareStatement(queryString);
			}
			if(pstmt != null) {
				pstmt.setString(1, eid);
				pstmt.setString(2, ename);
				pstmt.setInt(3, eage);
				pstmt.setString(4, email);
				pstmt.setString(5, emobile);
				
				int rowAffect = pstmt.executeUpdate();
				
				if(rowAffect == 1) {
					System.out.println("successfull");
					
					return "success";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return "failure";
	}

	@Override
	public String deleteRecord(String eid) {
		String queryString = "delete from employee where eid=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null) {				
				pstmt = connection.prepareStatement(queryString);
			}
			if(pstmt!=null) {
				
				pstmt.setString(1, eid);
				
				int rowAffected = pstmt.executeUpdate();
				
				if(rowAffected == 1) {
					return "success";
				}
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public String updateRecord(EmployeeDto employeeDto) {
		
		String queryString = "update employee set ename=?, eage=?, email=?, emobile=? where eid = ?";
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null) {
				pstmt = connection.prepareStatement(queryString);
			}
			if(pstmt != null) {
				
				System.out.println("inside update operation ");
				System.out.println(employeeDto.getEage());
				
				pstmt.setString(1, employeeDto.getEname());
				pstmt.setInt(2, employeeDto.getEage());
				pstmt.setString(3, employeeDto.getEmail());
				pstmt.setString(4, employeeDto.getEmobile());
				pstmt.setString(5, employeeDto.getEid());
				
				int rowAffected = pstmt.executeUpdate();
				if(rowAffected == 1) {
					return "success";
				}
				
			}
		} catch (SQLException | IOException e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public EmployeeDto searchRecord(String eid) {
		String queryString = "select eid, ename, eage, email, emobile from employee where eid=?";
		EmployeeDto employeeDto = new EmployeeDto();
		System.out.println(">>>>searchRecord EmployeeDao implementation....");
		System.out.println(eid);
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null) {
				pstmt = connection.prepareStatement(queryString);
			}
			if(pstmt != null) {
				pstmt.setString(1, eid);
				resultSet = pstmt.executeQuery();
			}
			if(resultSet.next()) {
				
				System.out.println(">>>>inside result set ....");
				System.out.println(resultSet.getString(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getInt(3));
				System.out.println(resultSet.getString(4));
				System.out.println(resultSet.getString(5));
				
				employeeDto.setEid(resultSet.getString(1));
				employeeDto.setEname(resultSet.getString(2));
				employeeDto.setEage(resultSet.getInt(3));
				employeeDto.setEmail(resultSet.getString(4));
				employeeDto.setEmobile(resultSet.getString(5));
				
				System.out.println(employeeDto);
				return employeeDto;
			}
			
		} catch (SQLException | IOException e) {
			// TODO: handle exception
		}
		
		return null;
	}

}
