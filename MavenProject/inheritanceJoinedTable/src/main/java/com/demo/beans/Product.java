package com.demo.beans;

import java.time.LocalDate;

@Entity
@Table(name="productinheri")
public class Product {
	@Id
	private int pid;
	private String pname;
	private int qty;
	private double price;
	private LocalDate mfgdate;
	
}
