package br.com.poli.seltonheitor.damas.enums;

public enum CorPeca {
	CLARA(-1), ESCURA(1);
	
	//private
	final int valor;
	
	CorPeca(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return this.valor;
	}
}
