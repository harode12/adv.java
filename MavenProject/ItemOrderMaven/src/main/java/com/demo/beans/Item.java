package com.demo.beans;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	@Id
	private int iid;
	private String iname;
	private LocalDate dop;
	@ManyToMany
	Set<Cart> cset;
	public Item() {
		super();
	}
	public Item(int iid, String iname, LocalDate dop, Set<Cart> cset) {
		super();
		this.iid = iid;
		this.iname = iname;
		this.dop = dop;
		this.cset = cset;
	}
	public Item(int iid, String iname, LocalDate dop) {
		super();
		this.iid = iid;
		this.iname = iname;
		this.dop = dop;
	}
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public LocalDate getDop() {
		return dop;
	}
	public void setDop(LocalDate dop) {
		this.dop = dop;
	}
	public Set<Cart> getCset() {
		return cset;
	}
	public void setCset(Set<Cart> cset) {
		this.cset = cset;
	}
	@Override
	public String toString() {
		return "Item [iid=" + iid + ", iname=" + iname + ", dop=" + dop + "]";
	}
    
	
	
}
