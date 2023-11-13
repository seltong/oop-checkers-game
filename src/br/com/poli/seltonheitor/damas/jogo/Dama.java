package br.com.poli.seltonheitor.damas.jogo;

import static br.com.poli.seltonheitor.damas.jogo.Tabuleiro.TAMANHO;

import br.com.poli.seltonheitor.damas.enums.CorPeca;
import br.com.poli.seltonheitor.damas.jogador.Jogador;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Dama extends Peca {

	private boolean damaValida;

	public Dama(Jogador jogador, CorPeca cor, int x, int y) {
		super(jogador, cor, x, y);

		Ellipse bg2 = new Ellipse(TAMANHO * 0.3125 / 2, TAMANHO * 0.26 / 2);
		bg2.setFill(Color.valueOf("#FFD700"));
		bg2.setStroke(Color.valueOf("#FFFF00"));

		bg2.setStrokeWidth(TAMANHO * 0.03);

		bg2.setTranslateX((TAMANHO - TAMANHO * 0.3125 * 2) / 2);
		bg2.setTranslateY((TAMANHO - TAMANHO * 0.26 * 2) / 2);

		getChildren().addAll(bg2);

	}

	public boolean isDamaValida() {
		return damaValida;
	}

	public void setDamaValida(boolean damaValida) {
		this.damaValida = damaValida;
	}

}
