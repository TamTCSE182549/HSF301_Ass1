package hsf301.fe.service;

import hsf301.fe.pojo.Account;
import hsf301.fe.repo.AccountRepository;
import hsf301.fe.repo.IAccountRepository;

public class AccountService implements IAccountService{
	
	private IAccountRepository iAccountRepository = null;
	
	public AccountService(String fileConfig) {
		iAccountRepository = new AccountRepository(fileConfig);
	}

	@Override
	public Account findAccount(String userName, String password) {
		// TODO Auto-generated method stub
		return iAccountRepository.findAccount(userName, password);
	}

	@Override
	public Account findByUserName(String userName) {
		// TODO Auto-generated method stub
		return iAccountRepository.findByUserName(userName);
	}

}
