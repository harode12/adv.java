package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDaoImpl implements RegisterDao{
	static Connection conn=null;
	static {
		conn=DBUtil.getMyConnection();
	}
	@Override
	public boolean registerUser(String uname, String pass, String email, String gender) {
		// TODO Auto-generated method stub
		PreparedStatement newuser;
		try {
			newuser=conn.prepareStatement("insert into validate(username,password,email,role,gender) values(?,?,?,?,?)");
			newuser.setString(1, uname);
			newuser.setString(2, pass);
			newuser.setString(3, email);
			newuser.setString(4, "user");
			newuser.setString(5, gender);
			int n=newuser.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
