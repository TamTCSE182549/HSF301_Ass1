package hsf301.fe.repo;

import hsf301.fe.pojo.Account;

public interface IAccountRepository {
	 public Account findByUserName(String userName);
	 
	 public Account findAccount(String userName, String password);
}
