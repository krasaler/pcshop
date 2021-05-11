package com.hibernate.service;

import java.util.List;

import com.hibernate.dao.PCTypeDAO;
import com.hibernate.vo.PCType;
public class PCTypeService {
	private PCTypeDAO pcTypeDAO = new PCTypeDAO();

	public void saveOrUpdatePCType(PCType pcType) {
		pcTypeDAO.saveOrUpdatePCType(pcType);
	}

	public List<PCType> getPCTypes() {
		return pcTypeDAO.getPCTypes();
	}
	public PCType getPCTypeByName(String name) {
		return pcTypeDAO.getPCTypeByName(name);
	}
	public PCType getPCType(long pcTypeId) {
		return pcTypeDAO.getPCType(pcTypeId);
	}

	public void deletePCType(PCType pcType) {
		pcTypeDAO.deletePCType(pcType);
	}
}
