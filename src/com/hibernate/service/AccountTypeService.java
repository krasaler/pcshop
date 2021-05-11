package com.hibernate.service;

import java.util.List;

import com.hibernate.dao.AccountTypeDAO;
import com.hibernate.vo.AccountType;

public class AccountTypeService {
	private AccountTypeDAO accounttypeDAO = new AccountTypeDAO();

	public void saveOrUpdateAccount(AccountType account) {
		accounttypeDAO.saveOrUpdateAccountType(account);
	}

	public List<AccountType> getAccountTypes() {
		return accounttypeDAO.getAccountTypes();
	}
	public AccountType getAccountTypeByName(String name) {
		return accounttypeDAO.getAccountTypeByName(name);
	}
	public AccountType getAccountType(long accountTypeId) {
		return accounttypeDAO.getAccountType(accountTypeId);
	}

	public void deleteAccountType(AccountType account) {
		accounttypeDAO.deleteAccountType(account);
	}
}
