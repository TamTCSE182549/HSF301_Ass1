package hsf301.fe.repo;

import java.util.List;

import hsf301.fe.dao.BookDAO;
import hsf301.fe.pojo.Book;

public class BookRepository implements IBookingRepository {
	
	private BookDAO bookDAO;

	public BookRepository(String fileName) {
		bookDAO = new BookDAO(fileName);
	}

	@Override
	public List<Book> finadAll() {
		// TODO Auto-generated method stub
		return bookDAO.findAll();
	}

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		bookDAO.save(book);
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		bookDAO.update(book);
	}

	@Override
	public void delete(Long bookID) {
		// TODO Auto-generated method stub
		bookDAO.delete(bookID);
	}

	@Override
	public Book findById(Long bookingID) {
		// TODO Auto-generated method stub
		return bookDAO.findById(bookingID);
	}

}
