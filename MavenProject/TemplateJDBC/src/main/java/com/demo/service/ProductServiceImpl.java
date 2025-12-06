package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao pdao;
	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public boolean addNewProduct() {
		System.out.println("Enter product id ");
		int pid = sc.nextInt();
		System.out.println("Enter product name ");
		String pname = sc.next();
		System.out.println("Enter product quantity ");
		int qty = sc.nextInt();
		System.out.println("Enter product price ");
		double price = sc.nextDouble();
		System.out.println("ENter mgf date");
		String dt = sc.next();
		LocalDate ldt = LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Enter cid");
		int cid = sc.nextInt();
		Product p = new Product(pid,pname,qty,price,ldt,cid);
		return pdao.addNewProduct(p);
	}

	@Override
	public List<Product> displayAll() {
		// TODO Auto-generated method stub
		return pdao.displayAll();
	}
	
}
