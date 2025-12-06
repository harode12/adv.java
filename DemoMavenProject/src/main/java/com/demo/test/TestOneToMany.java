package com.demo.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Department;
import com.demo.beans.Employee;

public class TestOneToMany {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.getCurrentSession();
		Transaction tr=session.beginTransaction();
		Department d1= new Department(101,"Developer","florida");
		Department d2= new Department(102,"Designer","LA");
		Employee e1=new Employee(1,"harodeBhai",LocalDate.of(2009, 04, 03),d1);
		Employee e2=new Employee(2,"chiknesaabKaDisappointment",LocalDate.of(2025, 10, 23),d1);
		Employee e3=new Employee(3,"Pratik",LocalDate.of(2004, 12, 03),d2);
		Employee e4=new Employee(4,"pranit",LocalDate.of(2009, 04, 23),d2);
		Set<Employee> eset1=new HashSet<Employee>();
		eset1.add(e1);
		eset1.add(e2);
		Set<Employee> eset2=new HashSet<Employee>();
		eset2.add(e3);
		eset2.add(e4);
		d1.setEset(eset1);
		d2.setEset(eset2);
		session.save(d1);
		session.save(d2);
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		tr.commit();
		sf.close();

	}

}
