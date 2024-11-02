package hsf301.fe.gui;


import java.util.List;
import java.util.Scanner;

import hsf301.fe.pojo.Book;
import hsf301.fe.pojo.Student;
import hsf301.fe.service.IStudentService;
import hsf301.fe.service.StudentService;

public class ManyToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "JPAs";
//		String fileName = "hibernate.cfg.xml";
		IStudentService studentService = new StudentService(fileName, 1);
//		Student student = new Student("Lam", "Nguyen", 9);
//		Book book = new Book("Java Persistence with Spring", "Catalin Tudose", "9781617299186");
//		student.getBooks().add(book);
//		studentService.save(student);
//		Create menu
//		0. Exit
//		1. Add
//		2. Show All
//		3. Get by ID
//		4. Delete
//		5. Update
		
		int inputKey = -1;
		while(inputKey!=0) {
			System.out.println("+++++++++Menu+++++++++");
			System.out.println("+ 1. Add             +");
			System.out.println("+ 2. Show All        +");
			System.out.println("+ 3. Get by ID       +");
			System.out.println("+ 4. Delete          +");
			System.out.println("+ 5. Update          +");
			System.out.println("+ 0. Exit            +");
			System.out.println("+++++++++END++++++++++");
			Scanner console = new Scanner(System.in);
			System.out.println("Please enter a number !");
			inputKey = console.nextInt();
			
			switch (inputKey) {
			case 0:
				break;
			case 1:
				System.out.println(studentService.readInput());
				break;
			case 2:
				List<Student> studentList = studentService.findAll();
				for(Student s : studentList) {
					System.out.println(s);
				}
				break;
			case 3:
				System.out.print("ID need find: ");
				int id = console.nextInt();
				Student s = studentService.findById(id);
				System.out.println(s);
				break;
			case 4:
				System.out.print("ID need delete: ");
				id = console.nextInt();
				studentService.delete(id);
				break;
			case 5:
				
				break;
			default:
				System.out.println("Please choice menu !");
			}
			
		}
	}

}
