package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> getAllProduct();

	boolean addProduct(Product p);

	boolean changePass(String uname, String email, String newpass);

}
