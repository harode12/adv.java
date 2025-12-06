package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeService {

	boolean addNewEmployee();

	List<Employee> getAllEmployee();

	boolean deleteEmployee(int eid);

	boolean updateEmployee(int eid, String name, double sal);

	boolean addProjectToEmployee(int eid, int pid);

	List<Employee> SortEmployeeBySalary();

	void closeMySessionFactory();

}
