package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.hibernate.vo.Account;
import com.hibernate.vo.Order;
import com.hibernate.util.HibernateUtil;

public class OrderDAO {
	public void saveOrUpdateOrder(Order order) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(order);
	}
	@SuppressWarnings("unchecked")
	public List<Order> getOrders() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Order> order = (List<Order>) session.createCriteria(
				Order.class).list();
		return order;
	}
	@SuppressWarnings("unchecked")
	public List<Order> getOrdersByAccount(Account account) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Order> order = (List<Order>) session.createCriteria(
				Order.class).add(Restrictions.eq("account",account)).list();
		return order;
	}
	public Order getOrder(long orderId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Order order = (Order) session.get(Order.class, orderId);
		return order;
	}

	public void deleteOrder(Order order) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(order);
	}
}
