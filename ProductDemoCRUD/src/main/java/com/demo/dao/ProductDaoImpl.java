package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{
	static Connection conn=null;
	static {
		conn=DBUtil.getMyConnection();
	}
	@Override
	public List<Product> getAllProduct() {
		List<Product> plist= new ArrayList<>();
		PreparedStatement getall;
		try {
			getall=conn.prepareStatement("select * from myproduct");
			ResultSet rs=getall.executeQuery();
			while(rs.next()) {
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),0));
			}
			return plist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean addProduct(Product p) {
		PreparedStatement addPro;
		try {
			addPro=conn.prepareStatement("Insert into myproduct values(?,?,?,?,?)");
			addPro.setInt(1, p.getPid());
			addPro.setString(2,p.getPname());
			addPro.setInt(3, p.getQty());
			addPro.setDouble(4,p.getPrice());
			addPro.setDate(5,java.sql.Date.valueOf(p.getExpdate()));
			
			int n = addPro.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean changePass(String uname, String email, String newpass) {
		// TODO Auto-generated method stub
		PreparedStatement changep;
		try {
			changep=conn.prepareStatement("update  validate set password=? where username=? and email=? ");
			changep.setString(1, newpass);
			changep.setString(2, uname);
			changep.setString(3, email);
			int n=changep.executeUpdate();
			return n>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
