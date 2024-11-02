package hsf301.fe.service;

import java.util.List;

import hsf301.fe.pojo.Book;

public interface IBookService {
	List<Book> findAll();
	
	void save(Book book);
	
	void update(Book book);
	
	void delete(Long l);
	
	Book findById(Long bookID);
}
