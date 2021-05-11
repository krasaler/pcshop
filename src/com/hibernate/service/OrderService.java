package com.hibernate.service;

import java.util.List;

import com.hibernate.dao.OrderDAO;
import com.hibernate.vo.Account;
import com.hibernate.vo.Order;

public class OrderService {
	private OrderDAO orderDAO = new OrderDAO();


	public void saveOrUpdateOrder(Order order) {
		orderDAO.saveOrUpdateOrder(order);
	}
	public List<Order> getOrders() {
		return orderDAO.getOrders();
	}

	public Order getOrder(long orderId) {
		return orderDAO.getOrder(orderId);
	}
	public List<Order> getOrdersByAccount(Account account) {
		return orderDAO.getOrdersByAccount(account);
	}
	public void deleteOrder(Order order) {
		orderDAO.deleteOrder(order);
	}
}
