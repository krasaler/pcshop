package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.hibernate.util.HibernateUtil;
import com.hibernate.vo.AccountType;

public class AccountTypeDAO {
	public void saveOrUpdateAccountType(AccountType accounttype) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(accounttype);
	}

	@SuppressWarnings("unchecked")
	public List<AccountType> getAccountTypes() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<AccountType> accounts = (List<AccountType>) session.createCriteria(
				AccountType.class).list();
		return accounts;
	}

	@SuppressWarnings("unchecked")
	public AccountType getAccountTypeByName(String name) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<AccountType> accounts = (List<AccountType>) session
				.createCriteria(AccountType.class)
				.add(Restrictions.eq("name", name)).list();
		return accounts.get(0);
	}

	public AccountType getAccountType(long accountTypeId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		AccountType accounttype = (AccountType) session.get(AccountType.class, accountTypeId);
		return accounttype;
	}

	public void deleteAccountType(AccountType accounttype) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(accounttype);
	}
}
