package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.beans.Employee;
import com.demo.beans.Project;

public class EmployeeDaoImpl implements EmployeeDao {
	static SessionFactory sf;
	static {
		sf=HibernateUtil.getMySessionFactory();
	}
	
	
	@Override
	public boolean save(Employee e) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(e);
		tr.commit();
		session.close();
		return true;
		
	}


	@Override
	public List<Employee> getAllEmp() {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		List<Employee> elist=session.createQuery("from Employee",Employee.class).list();
		tr.commit();
		session.close();
		return elist;
	}


	@Override
	public boolean deleteEmp(int eid) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Employee e=session.get(Employee.class,eid);
		if(e!=null) {
			session.delete(e);
			return true;
		}
		tr.commit();
		session.close();
		return false;
	}


	@Override
	public boolean updateEmployee(int eid, String name, double sal) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Employee e=session.get(Employee.class,eid);
		if(e!=null) {
			e.setEname(name);
			e.setSal(sal);
			session.merge(e);
			return true;
		}
		tr.commit();
		session.close();
		return false;
	}




	@Override
	public Employee findById(int eid) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Employee e=session.get(Employee.class,eid);
		
		tr.commit();
		session.close();
		return e;
	
	}


	@Override
	public boolean addProjectToEmployee(Employee e, Project p) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		e.getPset().add(p);
		p.getEset().add(e);
		session.update(e);
		tr.commit();
		session.close();
		return true;
	
	}


	@Override
	public List<Employee> sortBySalary() {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		List<Employee> elist=session.createQuery("from Employee e1 order by e1.sal",Employee.class).list();
		tr.commit();
		session.close();
		return elist;
	}


	@Override
	public void closeMySessionFactory() {
		HibernateUtil.closeMySessionFactory();
		
	}


	

	

}
