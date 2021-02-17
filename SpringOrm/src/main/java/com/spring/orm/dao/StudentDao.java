package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entites.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	
	//insert the student and return the id of the student added 
	@Transactional
	public int insert(Student s) {
		int id = (Integer)this.hibernateTemplate.save(s);
		return id;
	}
	
	//to get all the students i.e all the rows of a table
	public List<Student> getAll(){
		List<Student> s = this.hibernateTemplate.loadAll(Student.class);
		return s;
	}
	
	//to get only one row with specified id
	public Student get(int studentId) {
		Student s = this.hibernateTemplate.get(Student.class,studentId);
		return s;
	}
	
	//to update the value
	@Transactional
	public int change(Student s) {
		this.hibernateTemplate.update(s);
		return 1; 
	}
	
	//to delete one
	@Transactional
	public void delete(int studentId) {
		Student s = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(s);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}