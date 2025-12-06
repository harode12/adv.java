package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Student;

public class TestGetData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		System.out.println("before get");
		Course c = session.get(Course.class,101);
		System.out.println("after get");
		
		
		System.out.println("---------------------");
		System.out.println(c);
		
		System.out.println("before get studetn");
		Student s=session.load(Student.class, 2);
		System.out.println("after get student ");
		System.out.println(s);
		
		
		
	}

}
