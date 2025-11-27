package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllProduct();

	boolean addProduct(Product p);

	boolean changePass(String uname, String email, String newpass);

}
