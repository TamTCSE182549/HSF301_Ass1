package hsf301.fe.dao;

import java.util.List;

import hsf301.fe.pojo.Book;

public interface IBookDAO {
	
	List<Book> findAll();
	
	void save(Book book);
	
	void update(Book book);
	
	void delete(Long bookID);
	
	Book findById(Long bookID);
}
