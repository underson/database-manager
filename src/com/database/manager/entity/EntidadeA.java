package com.database.manager.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class EntidadeA extends EntityBase {

	private static final long serialVersionUID = 1L;

	//precisa ser testado
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
}
