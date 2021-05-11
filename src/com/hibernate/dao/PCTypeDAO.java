package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.hibernate.util.HibernateUtil;
import com.hibernate.vo.PCType;

public class PCTypeDAO {
	public void saveOrUpdatePCType(PCType pcType) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(pcType);
	}

	@SuppressWarnings("unchecked")
	public List<PCType> getPCTypes() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<PCType> pcTypes = (List<PCType>) session.createCriteria(
				PCType.class).list();
		return pcTypes;
	}

	@SuppressWarnings("unchecked")
	public PCType getPCTypeByName(String name) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<PCType> pcTypes = (List<PCType>) session
				.createCriteria(PCType.class)
				.add(Restrictions.eq("name", name)).list();
		return pcTypes.get(0);
	}

	public PCType getPCType(long pcTypeId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		PCType pcType = (PCType) session.get(PCType.class, pcTypeId);
		return pcType;
	}

	public void deletePCType(PCType pcType) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(pcType);
	}
}
