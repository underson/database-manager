package com.database.manager.bean.test;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import com.database.manager.dao.GenericDaoFacade;
import com.database.manager.entity.TipoLancamento;
import com.database.manager.transaction.TransactionException;

public class DatabaseTest {
	
	@Test
	public void testando (){
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		GenericDaoFacade bean = container.instance().select(GenericDaoFacade.class).get(); 
		
		TipoLancamento tipo = new TipoLancamento();
		tipo.setId(new Long(3));
		
		
		TipoLancamento tipo2 = new TipoLancamento();
		tipo2.setId(new Long(5));
		tipo2.setDescricao("Descricao");
			
		try {
			bean.save(tipo2);
		} catch (TransactionException e) {
			System.out.println(e.getMessage());
		}		
		try {
			bean.save(tipo);
		} catch (TransactionException e) {
			System.out.println(e.getMessage());
		}
		
		weld.shutdown();
	}

}
