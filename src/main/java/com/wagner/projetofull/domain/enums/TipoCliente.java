package com.wagner.projetofull.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA,
	PESSOAJURIDICA;

	/*
	/*static pq nao estava dando ok
	
	private static Integer cod; 
	private String descricao;
	
	
	private TipoCliente(Integer cod, String descricao) {
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}



	public static TipoCliente toEnum(Integer Cod) {
		
		if(cod == null) {
			return null;
		}
		
		for (TipoCliente x : TipoCliente.values()) {
			if (Cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod); 
		
		
	}

*--------------------- no projeto broadfactor eu fiz funcionar o tipo enuns



	 */
	
	
	
	
}
