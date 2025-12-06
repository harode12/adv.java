package com.demo.beans;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student12")
public class Student {
	@Id
	private int sid;
	private String sname;
	private LocalDate joindt;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cid")
	private Course course;
	public Student() {
		super();
	}
	public Student(int sid, String sname, LocalDate joindt, Course course) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.joindt = joindt;
		this.course = course;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public LocalDate getJoindt() {
		return joindt;
	}
	public void setJoindt(LocalDate joindt) {
		this.joindt = joindt;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", joindt=" + joindt + "]";
	}
	
	
}
