package hsf301.fe.pojo;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "firstName", nullable = false, columnDefinition = "NVARCHAR(255)")
	private String firstName;

	@Column(name = "lastName", columnDefinition = "NVARCHAR(255)")
	private String lastName;

	@Column(name = "marks")
	private int marks;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	private Set<Book> books;

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	

	public Student() {
		this.books = new HashSet<Book>();
	}
	
	


	public Student(int id, String firstName, String lastName, int marks) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.marks = marks;
	}

	public Student(String firstName, String lastName, int marks, Set<Book> books) {
		super();
		books = new HashSet<Book>();
		this.firstName = firstName;
		this.lastName = lastName;
		this.marks = marks;
	}

	

	public Student(String firstName, String lastName, int marks) {
		super();
		books = new HashSet<Book>();
		this.firstName = firstName;
		this.lastName = lastName;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", marks=" + marks
				+ ", books=" + books + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(books, firstName, id, lastName, marks);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(books, other.books) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && marks == other.marks;
	} 
	
}
