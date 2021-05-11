package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.hibernate.util.HibernateUtil;
import com.hibernate.vo.Status;

public class StatusDAO {
	public void saveOrUpdateStatus(Status status) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(status);
	}

	@SuppressWarnings("unchecked")
	public List<Status> getStatuss() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Status> accounts = (List<Status>) session.createCriteria(
				Status.class).list();
		return accounts;
	}

	@SuppressWarnings("unchecked")
	public Status getStatusByName(String name) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Status> statuss = (List<Status>) session
				.createCriteria(Status.class)
				.add(Restrictions.eq("name", name)).list();
		return statuss.get(0);
	}

	public Status getStatus(long statusId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Status status = (Status) session.get(Status.class, statusId);
		return status;
	}

	public void deleteStatus(Status status) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(status);
	}
}
