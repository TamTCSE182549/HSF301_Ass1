package hsf301.fe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hsf301.fe.pojo.Account;

public class AccountDAO implements IAccountDAO{
	
	private EntityManager em;
	private EntityManagerFactory emf;

	public AccountDAO(String fileName) {
		emf = Persistence.createEntityManagerFactory(fileName);
	}

	@Override
	public List<Account> accounts() {
		List<Account> accounts = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			accounts = em.createQuery("from account", Account.class).getResultList();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			// TODO: handle exception
		} finally {
			em.close();
		}
		// TODO Auto-generated method stub
		return accounts;
	}

	@Override
	public Account findById(String userName, String password) {
		Account account = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			account = em.createQuery("select a from account a where user_name = ?1 and password = ?2", Account.class)
					.setParameter(1, userName)
					.setParameter(2, password)
					.getSingleResult();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			// TODO: handle exception
		} finally {
			em.close();
		}
		return account;
	}

	@Override
	public void create(String userName, String password) {
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(new Account(userName, password));
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Error: " + e.getMessage());
			// TODO: handle exception
		} finally {
			em.close();
		}
		
	}

	@Override
	public void delete(String userName) {
		// TODO Auto-generated method stub
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.find(Account.class, userName));
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			// TODO: handle exception
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Account account, String newPass) {
		// TODO Auto-generated method stub
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Account acc = em.createQuery("select * from account where user_name = ?1 and password = ?2", Account.class).getSingleResult();
			if(acc != null) {
				acc.setUserName(account.getUserName());
				acc.setPassword(newPass);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			// TODO: handle exception
		} finally {
			em.close();
		}
	}

	@Override
	public Account findByUserName(String userName) {
		Account account = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			account = em.find(Account.class, userName);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			// TODO: handle exception
		} finally {
			em.close();
		}
		return account;
	}

}
