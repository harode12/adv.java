package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.demo.beans.Project;
import com.demo.dao.ProjectDao;
import com.demo.dao.ProjectDaoImpl;

public class ProjectServiceImpl implements ProjectSevice {
	private ProjectDao pdao;
	
	public ProjectServiceImpl() {
		pdao= new ProjectDaoImpl();
	}
	@Override
	public void addNewProject() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter pid");
		int pid=sc.nextInt();
		
		System.out.println("Enter pname");
		String pname=sc.next();
		
		System.out.println("start duration");
		int dur=sc.nextInt();

		Project p=new Project(pid,pname,dur);
		pdao.save(p);
		
	}

}
