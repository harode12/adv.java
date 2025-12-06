package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	boolean addNewProduct(Product p);

	List<Product> displayAll();

}
