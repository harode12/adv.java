package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.AddressA;
import com.demo.beans.MyUserA;

public class TestMyUser {
public static void main(String[] args) {
	SessionFactory sf= new Configuration().configure().buildSessionFactory();
	Session session= sf.openSession();
	Transaction tr= session.beginTransaction();
	AddressA a1= new AddressA("wakad","Pune","411022");
	MyUserA u1 = new MyUserA(12,"pk","1111", a1);
	a1.setUser1(u1);
	AddressA a2= new AddressA("baner","Pune","411019");
	MyUserA u2 = new MyUserA(13,"uk","2222", a2);
	a2.setUser1(u2);
	session.save(a1);
	session.save(u1);
	session.save(u1);
	session.save(u2);
	tr.commit();
	session.close();
	sf.close();
	
}
}
