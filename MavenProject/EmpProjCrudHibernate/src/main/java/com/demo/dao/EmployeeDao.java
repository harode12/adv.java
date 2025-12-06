package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;
import com.demo.beans.Project;

public interface EmployeeDao {

	boolean save(Employee e);

	List<Employee> getAllEmp();

	boolean deleteEmp(int eid);

	boolean updateEmployee(int eid, String name, double sal);



	Employee findById(int eid);

	boolean addProjectToEmployee(Employee e, Project p);

	List<Employee> sortBySalary();

	void closeMySessionFactory();



}
