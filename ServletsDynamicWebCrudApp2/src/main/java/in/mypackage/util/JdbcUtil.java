package in.mypackage.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcUtil {
	
	private  JdbcUtil() {}
	
	private static Connection connection = null;
	
	static {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	
	public static Connection getJdbcConnection() throws IOException, SQLException {
		
		FileInputStream fis =new FileInputStream("D:\\Ineuron Full Stack Java course\\Projects\\ServletsDynamicWebCrudApp2\\src\\main\\java\\in\\mypackage\\properties\\properties.properties");
		
		Properties properties = new Properties();
		
		properties.load(fis);
		
		connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
		
		System.out.println("..........connected successfully to MySQL database......");
		
		return connection;
	}
	
	public static void clean(Connection con, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		if(con!=null) {
			con.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(rs != null) {
			rs.close();
		}	
	}
	
}
