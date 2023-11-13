package br.com.poli.seltonheitor.damas.jogo;

import br.com.poli.seltonheitor.damas.jogador.Jogador;

interface AutoPlayer {
	public boolean jogarAuto(Jogo jogo);

	public Jogador vencedor();
}
