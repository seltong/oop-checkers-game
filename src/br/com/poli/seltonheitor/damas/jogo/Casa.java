package br.com.poli.seltonheitor.damas.jogo;

import br.com.poli.seltonheitor.damas.enums.CorCasa;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Casa extends Rectangle {
	private CorCasa cor;
	private boolean valida;
	private boolean ocupada;
	private Peca peca;
	private Dama dama;

	// CONSTRUTOR da class CASA:
	public Casa(boolean clara, int x, int y) {
		this.dama = null;

		setWidth(Tabuleiro.TAMANHO);
		setHeight(Tabuleiro.TAMANHO);

		relocate(x * Tabuleiro.TAMANHO, y * Tabuleiro.TAMANHO);
									// #feb					// #582
		setFill(clara ? Color.valueOf("#fff") : Color.valueOf("#aaa"));

		if (clara) {
			this.cor = CorCasa.BRANCA;
			this.valida = false;
		} else {
			this.cor = CorCasa.PRETA;
			this.valida = true;
		}

		this.ocupada = false;
	}

	public Dama getDama() {
		return dama;
	}

	public void setDama(Dama dama) {
		this.dama = dama;
	}

	/* Se a casa eh valida, pode ser inserir peca nela */
	public boolean isValida() {
		return valida;
	}

	public void setValida(boolean valida) {
		this.valida = valida;
	}

	// GET do Atributo COR:
	public CorCasa getCor() {
		return this.cor;
	}

	// SET do Atributo COR:
	public void setCor(CorCasa cor) {
		this.cor = cor;
	}

	// GET do Atributo OCUPADA:
	public boolean isOcupada() {
		return this.ocupada;
	}

	// SET do Atributo OCUPADA:
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	// GET do Atributo PECA:
	public Peca getPeca() {
		return this.peca;
	}

	// SET do Atributo PECA:
	public void setPeca(Peca peca) {
		this.peca = peca;
	}

}
