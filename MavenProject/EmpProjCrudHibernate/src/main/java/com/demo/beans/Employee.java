package com.demo.beans;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="emp123")
public class Employee {
	@Id
	private int eid;
	private String ename;
	private LocalDate hrdt;
	private double sal;
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable(
			name="emp_project",
			joinColumns =@JoinColumn(name="eid"),
			inverseJoinColumns =  @JoinColumn(name="pid")
			)
	Set<Project> pset ;
	public Employee() {
		super();
	}
	public Employee(int eid, String ename, LocalDate hrdt, double sal, Set<Project> pset) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.hrdt = hrdt;
		this.sal = sal;
		this.pset = pset;
	}
	
	
	public Employee(int eid, String ename, LocalDate hrdt, double sal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.hrdt = hrdt;
		this.sal = sal;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public LocalDate getHrdt() {
		return hrdt;
	}
	public void setHrdt(LocalDate hrdt) {
		this.hrdt = hrdt;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public Set<Project> getPset() {
		return pset;
	}
	public void setPset(Set<Project> pset) {
		this.pset = pset;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", hrdt=" + hrdt + ", sal=" + sal +  "]";
	}
	
	
	
}
