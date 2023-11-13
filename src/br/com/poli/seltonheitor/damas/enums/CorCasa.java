package br.com.poli.seltonheitor.damas.enums;

public enum CorCasa {
	BRANCA(0), PRETA(1);
	
	private int valor;
	
	CorCasa(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return this.valor;
	}
}
