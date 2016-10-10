package com.database.manager.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="TRUSTY_LOGO")
@AttributeOverride(name="id", column=@Column(name="SQ_LOGO") )
public class TipoLancamento extends EntityBase {

	private static final long serialVersionUID = 1L;

	@Column(name="NM_LOGO")
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	

}