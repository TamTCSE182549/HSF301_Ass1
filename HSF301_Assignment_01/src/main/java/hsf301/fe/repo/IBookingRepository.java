package hsf301.fe.repo;

import java.util.List;

import hsf301.fe.pojo.Book;

public interface IBookingRepository {
	List<Book> finadAll();
	
	void save(Book book);
	
	void update(Book book);
	
	void delete(Long bookID);
	
	Book findById(Long bookingID);
}
