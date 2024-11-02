package hsf301.fe.dao;

import java.util.List;

import hsf301.fe.pojo.Student;

public interface IStudentDAO {
	public List<Student> findAll();
	
	public void save(Student student);
	
	public void delete(int StudentID);
	
	public Student findById(int StudentID);
	
	public void update(Student student);
	
	public List<Student> findByFirstName(String name);
}
