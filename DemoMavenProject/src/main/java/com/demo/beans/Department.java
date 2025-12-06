package com.demo.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="deptdemo")
public class Department {
	@Id
	private int did;
	private String dname;
	private String dloc;
	@OneToMany(mappedBy="dept")
	Set<Employee> eset;
	public Department() {
		super();
	}
	public Department(int did, String dname, String dloc) {
		super();
		this.did = did;
		this.dname = dname;
		this.dloc = dloc;
	}
	public Department(int did, String dname, String dloc, Set<Employee> eset) {
		super();
		this.did = did;
		this.dname = dname;
		this.dloc = dloc;
		this.eset = eset;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDloc() {
		return dloc;
	}
	public void setDloc(String dloc) {
		this.dloc = dloc;
	}
	public Set<Employee> getEset() {
		return eset;
	}
	public void setEset(Set<Employee> eset) {
		this.eset = eset;
	}
	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", dloc=" + dloc + ", eset=" + eset + "]";
	}
	
}
