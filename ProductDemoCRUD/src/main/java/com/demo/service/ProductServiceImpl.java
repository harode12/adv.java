package com.demo.service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	 private ProductDao pdao;
	 
	 public ProductServiceImpl() {
		 pdao=new ProductDaoImpl();
	 }

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return pdao.getAllProduct();
	}

	@Override
	public boolean addProduct(Product p) {
		// TODO Auto-generated method stub
		return pdao.addProduct(p);
	}

	@Override
	public boolean changePass(String uname, String email, String newpass) {
		// TODO Auto-generated method stub
		return pdao.changePass(uname,email,newpass);
	}
	 
}
