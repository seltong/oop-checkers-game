package br.com.poli.seltonheitor.damas.testes;

import br.com.poli.seltonheitor.damas.jogo.Casa;

public class TesteCasa {

	public static void main(String[] args) {
		Casa casa1 = new Casa(false, 0, 1);

		System.out.println("Cor da Casa: " + casa1.getCor());
		System.out.println("Ocupada: " + casa1.isOcupada());

	}
}
