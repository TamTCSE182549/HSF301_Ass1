package hsf301.fe.repo;

import hsf301.fe.dao.AccountDAO;
import hsf301.fe.pojo.Account;

public class AccountRepository implements IAccountRepository{
	
	private AccountDAO accountDAO = null;
	
	public AccountRepository(String fileConfig) {
		accountDAO = new AccountDAO(fileConfig);
	}

	@Override
	public Account findByUserName(String userName) {
		// TODO Auto-generated method stub
		return accountDAO.findByUserName(userName);
	}

	@Override
	public Account findAccount(String userName, String password) {
		// TODO Auto-generated method stub
		return accountDAO.findById(userName, password);
	}

}
