package hsf301.fe.dao;

import java.util.List;

import hsf301.fe.pojo.Account;

public interface IAccountDAO {
	
	List<Account> accounts();
	
	void create(String userName, String password);
	
	void delete(String userName);
	
	void update(Account account, String newPass);
	
	Account findById(String userName, String password);
	
	Account findByUserName(String userName);
} 
