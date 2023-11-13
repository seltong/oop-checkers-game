package br.com.poli.seltonheitor.damas.jogo;

import static br.com.poli.seltonheitor.damas.jogo.Tabuleiro.TAMANHO;

import br.com.poli.seltonheitor.damas.enums.CorPeca;
import br.com.poli.seltonheitor.damas.jogador.Jogador;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Peca extends StackPane {
	protected CorPeca cor;
	protected Jogador jogador;

	protected double mouseX, mouseY;
	protected double inicialX, inicialY;

	// CONSTRUTOR da class PECA
	protected Peca(Jogador jogador, CorPeca cor, int x, int y) {
		this.jogador = jogador;
		this.cor = cor;

		move(x, y);

		Ellipse bg = new Ellipse(TAMANHO * 0.3125, TAMANHO * 0.26);
		if (cor == CorPeca.ESCURA) {
			bg.setFill(Color.GRAY);

			bg.setStroke(Color.GRAY);
		} else {
			bg.setFill(Color.BLACK);

			bg.setStroke(Color.BLACK);
		}
		bg.setStrokeWidth(TAMANHO * 0.03);

		bg.setTranslateX((TAMANHO - TAMANHO * 0.3125 * 2) / 2);
		bg.setTranslateY((TAMANHO - TAMANHO * 0.26 * 2) / 2 + TAMANHO * 0.07);

		Ellipse elipse = new Ellipse(TAMANHO * 0.3125, TAMANHO * 0.26);
		elipse.setFill(cor == CorPeca.ESCURA ? Color.valueOf("#000000") : Color.valueOf("#fff9f4"));

		elipse.setStroke(Color.BLACK);
		elipse.setStrokeWidth(TAMANHO * 0.03);

		elipse.setTranslateX((TAMANHO - TAMANHO * 0.3125 * 2) / 2);
		elipse.setTranslateY((TAMANHO - TAMANHO * 0.26 * 2) / 2);

		getChildren().addAll(bg, elipse);

		setOnMousePressed(e -> {
			this.mouseX = e.getSceneX();
			this.mouseY = e.getSceneY();
		});

		setOnMouseDragged(e -> {
			relocate(e.getSceneX() - this.mouseX + this.inicialY, e.getSceneY() - this.mouseY + this.inicialX);
		});

	}

	public Peca(Jogador jogador) {
		this.jogador = jogador;
	}

	public void move(int x, int y) {
		this.inicialY = x * TAMANHO;
		this.inicialX = y * TAMANHO;

		relocate(this.inicialY, this.inicialX);
	}

	public void abortaMovimento() {
		relocate(this.inicialY, this.inicialX);
	}

	public double getInicialX() {
		return inicialX;
	}

	public void setInicialX(double inicialX) {
		this.inicialX = inicialX;
	}

	public double getInicialY() {
		return inicialY;
	}

	public void setInicialY(double inicialY) {
		this.inicialY = inicialY;
	}

	public Peca(Jogador jogador, CorPeca cor) {
		this.cor = cor;
		this.jogador = jogador;
	}

	// GET do Atributo COR:
	public CorPeca getCor() {
		return cor;
	}

	// SET do Atributo COR:
	public void setCor(CorPeca cor) {
		this.cor = cor;
	}

	// GET do Atributo COR:
	public Jogador getJogador() {
		return jogador;
	}

	// SET do Atributo COR:
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

}
