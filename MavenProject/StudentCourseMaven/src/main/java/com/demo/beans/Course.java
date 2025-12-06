package com.demo.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	@Id
	private int cid;
	private String cname;
	private int dur;
	@OneToMany(mappedBy="course")
	Set<Student> sset;
	public Course() {
		super();
	}
	public Course(int cid, String cname, int dur, Set<Student> sset) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.dur = dur;
		this.sset = sset;
	}
	public Course(int cid, String cname, int dur) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.dur = dur;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getDur() {
		return dur;
	}
	public void setDur(int dur) {
		this.dur = dur;
	}
	public Set<Student> getSset() {
		return sset;
	}
	public void setSset(Set<Student> sset) {
		this.sset = sset;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", dur=" + dur + ", sset=" + sset + "]";
	}
	
}
