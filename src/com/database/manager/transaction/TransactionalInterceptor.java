package com.database.manager.transaction;

import java.io.Serializable;
import java.util.Arrays;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


@Interceptor
@Transactional
public class TransactionalInterceptor implements Serializable
{
    private static final long serialVersionUID = 8787285444722371172L;
    
    @AroundInvoke
    public Object executeInTransaction(InvocationContext context) throws TransactionException {
    	
    	EntityManager manager =  (EntityManager) context.getParameters()[0];
        
    	EntityTransaction trx = manager.getTransaction();
        Object obj = null;
        boolean criador = false;

        try {

            if (!trx.isActive()) {

                System.out.println("Iniciando transação ...");
                trx.begin();

                criador = true;
            }

            obj = context.proceed();

            if (trx != null && trx.isActive() && criador) {

                System.out.println("Comitando ...");
                trx.commit();

            }

            System.out.println("Finalizando interceptor ...");

        } catch (Exception e) {

            System.out.println("ERRO ENCONTRADO !");                    

            if (trx != null && trx.isActive() && criador) {
                System.out.println("Rollback ...");
                trx.rollback();
                
                String message = new String();
                
                Throwable cause = e.getCause();
                
                message = e.getMessage();
                
                while(cause != null){                	                	
                	message = message.concat("\n").concat(cause.getMessage());
                	cause = cause.getCause();
                }
                
                
                
                throw new TransactionException(message);
            }

            System.out.println("Finalizando interceptor ...");

            return obj;
        } 

        return obj;
    }
}