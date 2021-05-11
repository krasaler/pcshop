package com.hibernate.service;

import java.util.List;

import com.hibernate.dao.StatusDAO;
import com.hibernate.vo.Status;


public class StatusService {
	private StatusDAO statusDAO = new StatusDAO();

	public void saveOrUpdateStatus(Status status) {
		statusDAO.saveOrUpdateStatus(status);
	}

	public List<Status> getStatuss() {
		return statusDAO.getStatuss();
	}
	public Status getStatusByName(String name) {
		return statusDAO.getStatusByName(name);
	}
	public Status getStatus(long statusId) {
		return statusDAO.getStatus(statusId);
	}

	public void deleteStatus(Status status) {
		statusDAO.deleteStatus(status);
	}
}
