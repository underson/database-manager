package com.database.manager.dao;

import javax.inject.Named;
import javax.persistence.EntityManager;

import com.database.manager.entity.EntityBase;
import com.database.manager.transaction.TransactionException;
import com.database.manager.transaction.Transactional;

@Named
public class GenericDao {
	
	
	@Transactional
	public void save(EntityManager entityManager, EntityBase object) throws TransactionException{
		entityManager.merge(object);
	}
	
	@Transactional
	public void delete(EntityManager entityManager, EntityBase object) throws TransactionException{
		entityManager.remove(entityManager.find(object.getClass(), object.getId() ));
	}

}
