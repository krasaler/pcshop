package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.hibernate.vo.Tovar;
import com.hibernate.util.HibernateUtil;

public class TovarDAO {
	public void saveOrUpdateAccount(Tovar tovar) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(tovar);
	}

	@SuppressWarnings("unchecked")
	public List<Tovar> getTovars() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		return (List<Tovar>) session.createCriteria(Tovar.class).list();
	}
	@SuppressWarnings("unchecked")
	public List<Tovar> getTovarsBeetwenPrice(int priceStart, int priceEnd) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		return (List<Tovar>) session.createCriteria(Tovar.class)
				.add(Restrictions.between("price", priceStart, priceEnd)).list();
	}
	public Tovar getTovar(long tovarId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		return (Tovar) session.get(Tovar.class, tovarId);
	}

	public void deleteAccount(Tovar tovar) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(tovar);
	}
}
