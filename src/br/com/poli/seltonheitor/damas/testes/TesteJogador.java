package br.com.poli.seltonheitor.damas.testes;

import br.com.poli.seltonheitor.damas.jogador.Jogador;

public class TesteJogador {

	public static void main(String[] args) {
		Jogador jogador1 = new Jogador("Um");

		jogador1.setNome("Irrruuu");

		System.out.println("O jogador é: " + jogador1.getNome());
	}
}
