package com.demo.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="empdemo")
public class Employee {
	@Id
	private int empid;
	private String ename;
	private LocalDate ldt;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="deptid")
	private Department dept;
	public Employee() {
		super();
	}
	public Employee(int empid, String ename, LocalDate ldt, Department dept) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.ldt = ldt;
		this.dept = dept;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public LocalDate getLdt() {
		return ldt;
	}
	public void setLdt(LocalDate ldt) {
		this.ldt = ldt;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", ldt=" + ldt +  "]";
	}
	
	
}
