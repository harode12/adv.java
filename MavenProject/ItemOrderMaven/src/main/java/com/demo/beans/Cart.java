package com.demo.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	@Id
	private int cid;
	private int quantity;
	private int price;
	@ManyToMany(mappedBy="cset", cascade=CascadeType.ALL)
	Set<Item> iset;
	public Cart() {
		super();
	}
	public Cart(int cid, int quantity, int price, Set<Item> iset) {
		super();
		this.cid = cid;
		this.quantity = quantity;
		this.price = price;
		this.iset = iset;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Set<Item> getIset() {
		return iset;
	}
	public void setIset(Set<Item> iset) {
		this.iset = iset;
	}
	public String toString() {
		return "Cart [cid=" + cid + ", quantity=" + quantity + ", price=" + price + ", iset=" + iset + "]";
	}
	
	
}
