package com.database.manager.producer;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import org.jboss.weld.environment.se.events.ContainerInitialized;

@ApplicationScoped
public class EntityManagerProducer{
	
	private EntityManagerFactory entityManagerFactory;

    @Produces
    protected EntityManager createEntityManager(){    
        return entityManagerFactory.createEntityManager();//Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa").createEntityManager();
    }

    protected void closeEntityManager(@Disposes EntityManager entityManager){
        
    	if (entityManager.isOpen())
            entityManager.close();        
    }

	
	public void init(@Observes ContainerInitialized container){
		entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
	}
	
	@PreDestroy
	public void shutdown(){
		entityManagerFactory.close();
	}
}
