package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean addNewProduct(Product p) {
		int n = jdbcTemplate.update("insert into product values(?,?,?,?,?,?)",new Object [] {p.getPid(),p.getPname(),p.getQty(),p.getPrice(),p.getMfgdate(),p.getCid()});
		
		return n > 0;
	}

	@Override
	public List<Product> displayAll() {
		// TODO Auto-generated method stub
		List<Product> plist=jdbcTemplate.query("select * from product",(rs,n)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
			p.setMfgdate(rs.getDate(5).toLocalDate());
			p.setCid(rs.getInt(6));
			return p;
		});
		return plist;
	}
	
	
}
