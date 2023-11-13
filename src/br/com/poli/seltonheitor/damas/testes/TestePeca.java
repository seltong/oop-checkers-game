package br.com.poli.seltonheitor.damas.testes;

import br.com.poli.seltonheitor.damas.enums.CorPeca;
import br.com.poli.seltonheitor.damas.jogador.Jogador;
import br.com.poli.seltonheitor.damas.jogo.Peca;

public class TestePeca {

	public static void main(String[] args) {
		Jogador jogador = new Jogador("Mujer");
		Peca peca = new Peca(jogador, CorPeca.CLARA);

		peca.setJogador(null);

		System.out.println("Cor: " + peca.getCor());
		if (peca.getJogador() != null)
			System.out.println("Jogador dono: " + peca.getJogador().getNome());
		else
			System.out.println("Jogador dono: " + peca.getJogador());
	}

}
