package com.database.manager.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.database.manager.entity.EntityBase;
import com.database.manager.transaction.TransactionException;

@Named
public class GenericDaoFacade {

	@Inject EntityManager entityManager;
	@Inject GenericDao dao;
	
	public void save(EntityBase object) throws TransactionException{
		dao.save(entityManager, object);
	}

	public void delete(EntityBase object) throws TransactionException{
		dao.delete(entityManager, object);
	}

}