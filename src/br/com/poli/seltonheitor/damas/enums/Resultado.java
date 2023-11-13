package br.com.poli.seltonheitor.damas.enums;

public enum Resultado {
	EMPATE(0), COMVENCEDOR(1);

	private int valor;

	Resultado(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return this.valor;
	}

}
