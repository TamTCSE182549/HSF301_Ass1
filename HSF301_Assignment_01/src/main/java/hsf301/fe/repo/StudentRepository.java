package hsf301.fe.repo;

import java.util.List;

import hsf301.fe.dao.HStudentDAO;
import hsf301.fe.dao.IStudentDAO;
import hsf301.fe.dao.StudentDAO;
import hsf301.fe.pojo.Student;

public class StudentRepository implements IStudentRepository{
	private IStudentDAO studentDAO = null;
	
	public StudentRepository(String fileConfig, int type) {
		if (type==1) {
			studentDAO = new StudentDAO(fileConfig);
		} else {
			studentDAO = new HStudentDAO(fileConfig);
		}
		
	}
	
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentDAO.findAll();
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentDAO.save(student);
	}

	@Override
	public void delete(int StudentID) {
		// TODO Auto-generated method stub
		studentDAO.delete(StudentID);
	}

	@Override
	public Student findById(int StudentID) {
		// TODO Auto-generated method stub
		return studentDAO.findById(StudentID);
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentDAO.update(student);
	}

	@Override
	public List<Student> findByFirstName(String name) {
		// TODO Auto-generated method stub
		return studentDAO.findByFirstName(name);
	}

}
