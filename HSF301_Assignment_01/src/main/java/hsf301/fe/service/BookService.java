package hsf301.fe.service;

import java.util.List;

import hsf301.fe.pojo.Book;
import hsf301.fe.repo.BookRepository;
import hsf301.fe.repo.IBookingRepository;

public class BookService implements IBookService{
	
	private IBookingRepository iBookingRepository;

	public BookService(String fileName) {
		iBookingRepository = new BookRepository(fileName);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return iBookingRepository.finadAll();
	}

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		iBookingRepository.save(book);
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		iBookingRepository.update(book);
	}

	@Override
	public void delete(Long bookID) {
		// TODO Auto-generated method stub
		iBookingRepository.delete(bookID);
	}

	@Override
	public Book findById(Long bookID) {
		// TODO Auto-generated method stub
		return iBookingRepository.findById(bookID);
	}

}
