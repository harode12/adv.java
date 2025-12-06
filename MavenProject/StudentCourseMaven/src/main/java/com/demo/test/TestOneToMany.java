package com.demo.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Student;



public class TestOneToMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.getCurrentSession();
		Transaction tr=session.beginTransaction();
		Course c1=new Course(101,"DAC",6);
		Course c2=new Course(102,"TeamRocket",3);
		Student s1=new Student(1,"vabofit",LocalDate.of(2025,8, 12),c1);
		Student s2=new Student(2,"meauth",LocalDate.of(2025,2, 12),c1);
		Student s3=new Student(3,"james",LocalDate.of(2025,8, 12),c1);
		Student s4=new Student(4,"jesse",LocalDate.of(2025,8, 12),c1);
		Set<Student> sset1 = new HashSet<Student>();
		sset1.add(s1);
		sset1.add(s2);
		Set<Student> sset2 = new HashSet<Student>();
		sset2.add(s3);
		sset2.add(s4);
		c1.setSset(sset1);
		c2.setSset(sset2);
		session.save(c1);
		session.save(c2);
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		tr.commit();
		sf.close();
	}
	

}
