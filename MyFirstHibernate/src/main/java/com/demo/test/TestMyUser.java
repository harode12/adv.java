package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.MyUser2;
import com.demo.beans.Productnew;




public class TestMyUser {

	public static void main(String[] args) {
		//create a sessionfactory
				//SessionFactory sf=new Configuration().configure("myconfig.config.xml").buildSessionFactory();
				SessionFactory sf=new Configuration().configure().buildSessionFactory();
				//create a MyUser object
				//both u1 and u2 are in transient state
				MyUser2 u1=new MyUser2(16,"Kishvhori", "kcgnkk@gmail.com");
				MyUser2 u2=new MyUser2(17,"Anicgncl", "agnaa@gmail.com");
				Productnew p1=new Productnew("table",23,54000);
				Productnew p2=new Productnew("chair",30,4000);
				//Session session=sf.getCurrentSession();
				
				Session session=sf.openSession();
				
				Transaction tr=session.beginTransaction();
				//saving object into session changes the state from transient to persistent
				session.save(u1);
				session.save(u2);
				session.save(p1);
				session.save(p2);
				tr.commit();
				session.close();
				sf.close();

	}

}
