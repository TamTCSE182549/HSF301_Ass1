package hsf301.fe.service;

import hsf301.fe.pojo.Account;

public interface IAccountService {
	
	Account findAccount(String userName, String password);
	
	Account findByUserName(String userName);
}
