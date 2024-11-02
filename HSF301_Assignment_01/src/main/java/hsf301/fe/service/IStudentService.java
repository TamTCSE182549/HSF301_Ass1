package hsf301.fe.service;

import java.util.List;

import hsf301.fe.pojo.Book;
import hsf301.fe.pojo.Student;

public interface IStudentService {
	public List<Student> findAll();
	
	public void save(Student student);
	
	public void delete(int StudentID);
	
	public Student findById(int StudentID);
	
	public void update(Student student);
	
	public Student readInput();
	
	public List<Student> findByFirstName(String name);
}
