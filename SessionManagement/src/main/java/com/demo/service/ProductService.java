package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<String> getAllCategory();

	List<Product> getByName(String name);
	
}
