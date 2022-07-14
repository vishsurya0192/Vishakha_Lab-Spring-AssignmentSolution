package com.greatlearning.studentmanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.studentmanagement.entity.Student;
import com.greatlearning.studentmanagement.repository.StudentRepository;

@Repository
public class StudentServiceImpl implements StudentService {
	
	//private SessionFactory sessionFactory;
	
	//private Session session;
	
	@Autowired
	StudentRepository studentRepository;
	
	/*public StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {session = sessionFactory.getCurrentSession();
		}catch(HibernateException e) {
			session = sessionFactory.openSession();
		}
	}*/
	
	@Transactional
	public List<Student> findAll() {
		
		//Transaction tx = session.beginTransaction();
		
		List<Student> student = studentRepository.findAll();
		
		//List<Student> student = session.createQuery("from Student").list();
		
		//tx.commit();
		return student;
		
	}
	
	@Transactional
	public Student findById(int id) {
		Student student = new Student();
		
		//Transaction tx = session.beginTransaction();
		
		student = studentRepository.findById(id).get();
		//student = session.get(Student.class, id);
		//tx.commit();
		return student;
	}
	
	@Transactional
	public void save(Student theStudent) {
		//Transaction tx = session.beginTransaction();
		//session.saveOrUpdate(theStudent);
		//tx.commit();
		
		studentRepository.save(theStudent);
	}
	
	@Transactional
	public void deleteById(int id) {
		
		//Transaction tx = session.beginTransaction();
		//Student student = session.get(Student.class, id);
		//session.delete(student);
		//tx.commit();
		
		studentRepository.deleteById(id);
	}
	

}
