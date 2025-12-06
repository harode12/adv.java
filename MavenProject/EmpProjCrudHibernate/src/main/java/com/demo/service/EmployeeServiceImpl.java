package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.demo.beans.Employee;
import com.demo.beans.Project;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;
import com.demo.dao.ProjectDao;
import com.demo.dao.ProjectDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao edao;
	 private ProjectDao pdao;
	public EmployeeServiceImpl() {
		edao=new EmployeeDaoImpl();
		this.pdao=new ProjectDaoImpl();
	}

	@Override
	public boolean addNewEmployee() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enetr new Id");
		int eid=sc.nextInt();
		System.out.println("enetr name");
		String ename=sc.next();
		System.out.println("enter hiredate(dd/MM/yyyy)");
		String dt=sc.next();
		LocalDate ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("enter salary");
		double s=sc.nextDouble();
		System.out.println("enetr project id");
		String pid=sc.next();
		String[] parr=pid.split(",");
		Set<Project> pset=pdao.findByPid(parr);
		Employee e=new Employee(eid,ename,ldt,s,pset);
		return edao.save(e);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return edao.getAllEmp();
	}

	@Override
	public boolean deleteEmployee(int eid) {
		// TODO Auto-generated method stub
		return edao.deleteEmp(eid);
	}

	@Override
	public boolean updateEmployee(int eid, String name, double sal) {
		// TODO Auto-generated method stub
		return edao.updateEmployee( eid,  name, sal);
	}

	@Override
	public boolean addProjectToEmployee(int eid, int pid) {
	 Employee e = edao.findById(eid);
	 Project p= pdao.findById(pid);
	 if(e!=null && p!=null) {
		 return edao.addProjectToEmployee(e, p);
	 }
	return false;
	 
		}

	@Override
	public List<Employee> SortEmployeeBySalary() {
		// TODO Auto-generated method stub
		return edao.sortBySalary();
	}

	@Override
	public void closeMySessionFactory() {
     edao.closeMySessionFactory();
		
	}

}
