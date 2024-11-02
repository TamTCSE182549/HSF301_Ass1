package hsf301.fe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hsf301.fe.pojo.Book;

public class BookDAO implements IBookDAO{
	
	private EntityManager em;
	private EntityManagerFactory emf;
	
	

	public BookDAO(String fileName) {
		emf = Persistence.createEntityManagerFactory(fileName);
	}

	@Override
	public List<Book> findAll() {
		List<Book> books = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			books = em.createQuery("from Book", Book.class).getResultList();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			// TODO: handle exception
		} finally {
			em.close();
		}
		// TODO Auto-generated method stub
		return books;
	}

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(book);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Error: " + e.getMessage());
			// TODO: handle exception
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Book b = em.find(Book.class, book.getId());
			if (b!=null) {
				b.setAuthor(book.getAuthor());
				b.setIsbn(book.getIsbn());
				b.setTitle(book.getTitle());
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			// TODO: handle exception
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(Long bookID) {
		// TODO Auto-generated method stub
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Book book = em.find(Book.class, bookID);
			em.remove(book);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			// TODO: handle exception
		} finally {
			em.close();
		}
	}

	@Override
	public Book findById(Long bookID) {
		Book book = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			book = em.find(Book.class, bookID);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			// TODO: handle exception
		} finally {
			em.close();
		}
		// TODO Auto-generated method stub
		return book;
	}

}
