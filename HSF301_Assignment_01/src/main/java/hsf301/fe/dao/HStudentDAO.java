package hsf301.fe.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hsf301.fe.pojo.Student;

public class HStudentDAO implements IStudentDAO{
	
	private SessionFactory sessionFactory = null;
	private Configuration cf = null;
	
	public HStudentDAO(String hibernateConfig) {
		cf = new Configuration();
		cf = cf.configure(hibernateConfig);
		sessionFactory = cf.buildSessionFactory();
	}
	
	public void save(Student student) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(student);
			t.commit();
			System.out.println("successfully saved");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			sessionFactory.close();
			session.close();		
		}
	}
	
	public void delete(int studentID) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			Student student = session.get(Student.class, studentID);
			session.delete(student);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
	
	public Student findById(int studentID) {
		Session session = sessionFactory.openSession();
		try {
			return session.get(Student.class, studentID);
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void update(Student student) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(student);
			t.commit();
			System.out.println("update saved");
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
		} finally {
			sessionFactory.close();
			session.close();
		}
	}

	@Override
	public List<Student> findAll() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		List<Student> students = null;
		try {
			tx.begin();
			students = session.createQuery("from Student", Student.class).list();
		} catch (RuntimeException e) {
			throw e;
		}
		return students;
	}

	@Override
	public List<Student> findByFirstName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
