package com.hibernate.service;

import java.util.List;

import com.hibernate.dao.TovarDAO;
import com.hibernate.vo.Tovar;

public class TovarService {
	private TovarDAO tovarDAO = new TovarDAO();


	public void saveOrUpdateAccount(Tovar tovar) {
		tovarDAO.saveOrUpdateAccount(tovar);
	}
	public List<Tovar> getTovars() {
		return tovarDAO.getTovars();
	}

	public Tovar getTovar(long tovarId) {
		return tovarDAO.getTovar(tovarId);
	}
	public List<Tovar> getTovarsBeetwenPrice(int priceStart, int priceEnd) {
		return tovarDAO.getTovarsBeetwenPrice(priceStart, priceEnd);
	}
	public void deleteAccount(Tovar tovar) {
		tovarDAO.deleteAccount(tovar);
	}
}
