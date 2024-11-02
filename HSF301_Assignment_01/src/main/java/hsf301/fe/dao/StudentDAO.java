package hsf301.fe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hsf301.fe.pojo.Student;
import hsf301.fe.repo.IStudentRepository;



public class StudentDAO implements IStudentDAO{
	
	private static EntityManager em;
	private static EntityManagerFactory emf;
	
	public StudentDAO(String persistenceName) {
		emf = Persistence.createEntityManagerFactory(persistenceName);
	}
	
	public void save(Student student) {
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(student);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			System.out.println("Error: "+ e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public List<Student> findAll(){
		List<Student> students = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			students = em.createQuery("from Student").getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+ e.getMessage());
		} finally {
			em.close();
		}
		return students;
	}
	
	public Student findById(int studentID) {
		Student student = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			student = em.find(Student.class, studentID);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+ e.getMessage());
		} finally {
			em.close();
		}
		return student;
	}
	
	public void delete(int studentID) {
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Student s = em.find(Student.class, studentID);
			em.remove(s);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public void update(Student student) {
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Student s = em.find(Student.class, student.getId());
			if(s!=null) {
				s.setFirstName(student.getFirstName());
				s.setLastName(student.getLastName());
				s.setMarks(student.getMarks());
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		} finally {
			em.close();
		}
	}

	@Override
	public List<Student> findByFirstName(String name) {
		List<Student> students = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			students = em.createQuery("select s from Student s where s.firstName like :name", Student.class)
					.setParameter("name","%" + name + "%").getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		} finally {
			em.close();
		}
		// TODO Auto-generated method stub
		return students;
	}
}
