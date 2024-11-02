package hsf301.fe.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKS")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "tile", length = 30, columnDefinition = "NVARCHAR(255)")
	private String title;
	
	@Column(name = "author", length = 30, columnDefinition = "NVARCHAR(255)")
	private String author;
	
	@Column(name = "isbn", length = 30, columnDefinition = "NVARCHAR(255)")
	private String isbn;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private Student student;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Book(Long id, String title, String author, String isbn, Student student) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.student = student;
	}
	
	

	public Book(String title, String author, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public Book(String title, String author, String isbn, Student student) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.student = student;
	}

	public Book(Long id, String title, String author, String isbn) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public Book() {
		super();
	}
	
	
}
