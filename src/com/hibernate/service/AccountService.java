package com.hibernate.service;

import java.util.List;

import com.hibernate.dao.AccountDAO;
import com.hibernate.vo.Account;

public class AccountService {
	private AccountDAO accountDAO = new AccountDAO();


	public void saveOrUpdateAccount(Account account) {
		accountDAO.saveOrUpdateAccount(account);
	}

	public List<Account> getAccounts() {
		return accountDAO.getAccounts();
	}
	public Account getAccountByLogin(String login) {
		return accountDAO.getAccountByLogin(login);
	}
	public Account getAccount(long accountId) {
		return accountDAO.getAccount(accountId);
	}

	public void deleteAccount(Account account) {
		accountDAO.deleteAccount(account);
	}
}
