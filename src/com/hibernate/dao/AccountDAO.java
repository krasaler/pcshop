package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.hibernate.util.HibernateUtil;
import com.hibernate.vo.Account;

public class AccountDAO {
	public void saveOrUpdateAccount(Account account) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(account);
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAccounts() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Account> accounts = (List<Account>) session.createCriteria(
				Account.class).list();
		return accounts;
	}

	@SuppressWarnings("unchecked")
	public Account getAccountByLogin(String login) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Account> accounts = (List<Account>) session
				.createCriteria(Account.class)
				.add(Restrictions.eq("login", login)).list();
		return accounts.get(0);
	}

	public Account getAccount(long accountId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Account account = (Account) session.get(Account.class, accountId);
		return account;
	}

	public void deleteAccount(Account account) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(account);
	}
}
