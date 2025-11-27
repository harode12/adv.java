package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {
	static Connection conn;
	static {
		conn=DBUtil.getMyConnection();
	}
	@Override
	public List<String> getAllCategory() {
		List<String> llist=new ArrayList<>();
		PreparedStatement getall;
		try {
			getall=conn.prepareStatement("select name from myproduct");
			ResultSet rs=getall.executeQuery();
			while(rs.next()) {
				llist.add(rs.getString(1));
			}
			return llist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Product> getByName(String name) {
		try {
			PreparedStatement getprod=conn.prepareStatement("select * from myproduct where name=? ");
	        getprod.setString(1, name);
	        ResultSet rs =getprod.executeQuery();
	        List<Product> plist=new ArrayList<>();
	        while (rs.next())
	        {
	        	plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(), 0));
	           
	        }
	        return plist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
