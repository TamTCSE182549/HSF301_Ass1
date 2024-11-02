package hsf301.fe.pojo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_book")
public class StudentBook {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Hoặc sử dụng một chiến lược tạo ID khác
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public StudentBook(Long id, Student student, Book book) {
		super();
		this.id = id;
		this.student = student;
		this.book = book;
	}

	public StudentBook() {
		super();
	}
}
