package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUser;

public class LoginDaoImpl implements LoginDao {
	static Connection conn=null;
	static PreparedStatement seluser;
	static {
		conn=DBUtil.getMyConnection();
		try {
			seluser=conn.prepareStatement("select uname,email,role from myproduct where uname=? and pass=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public MyUser validateUser(String uname, String pass) {
		// TODO Auto-generated method stub
		try {
			seluser.setString(1, uname);
			seluser.setString(2,pass);
			ResultSet rs =seluser.executeQuery();
			if(rs.next()) {
				MyUser us=new MyUser(rs.getString(1),rs.getString(2),rs.getString(3));
				return us;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
