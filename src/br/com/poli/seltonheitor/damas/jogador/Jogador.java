package br.com.poli.seltonheitor.damas.jogador;

import br.com.poli.seltonheitor.damas.jogo.Peca;

public class Jogador {
	private String nome;
	private Peca peca;

	// CONSTRUTOR da class JOGADOR
	public Jogador(String nome) {
		this.nome = nome;
	}

	// GET do Atributo NOME
	public String getNome() {
		return nome;
	}

	// SET do Atributo NOME
	public void setNome(String nome) {
		this.nome = nome;
	}

	// GET DO ATRIBUTO PECA
	public Peca getPeca() {
		return peca;
	}

	// SET DO ATRIBUTO PECA
	public void setPeca(Peca peca) {
		this.peca = peca;
	}

}
