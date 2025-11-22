package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TestPrepareStatement {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://localhost:3306/test?useSSL=false";
		    conn=DriverManager.getConnection(url,"root","root123");
		    PreparedStatement pst=conn.prepareStatement("select * from myproduct");
		    ResultSet rs=pst.executeQuery();
		    while(rs.next()) {
		    	System.out.println("pid:" +rs.getInt("pid"));
		    	System.out.println("pname:"+ rs.getString("pname"));
		    	System.out.println("qty"+rs.getInt("qty"));
		    	System.out.println("price:"+rs.getDouble("price"));
		    	System.out.println("mfgdate:"+rs.getDate("mfgdate"));
		    }
			
		    PreparedStatement pst1=conn.prepareStatement("insert into myproduct values(?,?,?,?,?)");
		    int pid=124;
			String pname="yyyyy";
			int qty=45;
			double price=456.78;
			LocalDate ldt=LocalDate.now();
			String sqlDate = ldt.toString();
			pst1.setInt(1, pid);
			pst1.setString(2, pname);
			pst1.setInt(3, qty);
			pst1.setDouble(4, price);
			pst1.setDate(5, java.sql.Date.valueOf(ldt));
			
			int n=pst1.executeUpdate();
			if(n>0) {
				System.out.println("insertion done");
			}else {
				System.out.println("error");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}





























package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStatement {

	public static void main(String[] args) {
		Connection conn = null;
		
		// 1. Define the criteria for "multiselect" (e.g., a list of empno)
		List<Integer> employeeIds = Arrays.asList(7369, 7499, 7521); // Example IDs
		
		// Create a string of '?' placeholders for the IN clause: ?, ?, ?
		String placeholders = employeeIds.stream()
		                                 .map(id -> "?")
		                                 .collect(Collectors.joining(", "));
		
		// 2. Construct the dynamic SQL query with the IN clause
		String sql = "SELECT empno, ename, job FROM emp WHERE empno IN (" + placeholders + ")";

		try {
			// Database connection setup (same as your original code)
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://192.168.10.117:3306/dac58?useSSL=false";
			conn = DriverManager.getConnection(url, "dac58", "welcome");
			
			// 3. Prepare the statement with the dynamic SQL
			PreparedStatement pst = conn.prepareStatement(sql);
			
			// 4. Set the parameters for the '?' placeholders
			for (int i = 0; i < employeeIds.size(); i++) {
			    // Parameters are 1-indexed in JDBC
			    pst.setInt(i + 1, employeeIds.get(i)); 
			}

			// 5. Execute the query
			ResultSet rs = pst.executeQuery();
			
			System.out.println("--- Results for IDs: " + employeeIds + " ---");
			while (rs.next()) {
			    System.out.println("empno: " + rs.getInt("empno"));
			    System.out.println("ename: " + rs.getString("ename"));
			    System.out.println("job: " + rs.getString("job"));
			    System.out.println();
			}
			
			rs.close(); // Close ResultSet
			pst.close(); // Close PreparedStatement

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Closing connection in the finally block
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}