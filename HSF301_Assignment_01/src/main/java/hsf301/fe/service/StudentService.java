package hsf301.fe.service;

import java.util.List;
import java.util.Scanner;

import hsf301.fe.pojo.Student;
import hsf301.fe.repo.IStudentRepository;
import hsf301.fe.repo.StudentRepository;

public class StudentService implements IStudentService{

	private IStudentRepository iStudentRepo = null;
	
	public StudentService(String fileName, int type) {
		iStudentRepo = new StudentRepository(fileName, type);
	}
	
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return iStudentRepo.findAll();
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		iStudentRepo.save(student);
	}

	@Override
	public void delete(int StudentID) {
		// TODO Auto-generated method stub
		iStudentRepo.delete(StudentID);
	}

	@Override
	public Student findById(int StudentID) {
		// TODO Auto-generated method stub
		return iStudentRepo.findById(StudentID);
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		iStudentRepo.update(student);
	}

	@Override
	public Student readInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Fill all fields below");
		System.out.print("First Name: ");
		String firstName = sc.nextLine();
		System.out.print("Last Name: ");
		String lastName = sc.nextLine();
		System.out.print("Marks: ");
		int mark = sc.nextInt();
		return new Student(firstName, lastName, mark);
	}

	@Override
	public List<Student> findByFirstName(String name) {
		// TODO Auto-generated method stub
		return iStudentRepo.findByFirstName(name);
	}

}
