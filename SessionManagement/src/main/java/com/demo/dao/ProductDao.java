package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<String> getAllCategory();

	List<Product> getByName(String name);

}
