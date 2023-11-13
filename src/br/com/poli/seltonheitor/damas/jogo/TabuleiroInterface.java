package br.com.poli.seltonheitor.damas.jogo;

import br.com.poli.seltonheitor.damas.enums.CorPeca;
import br.com.poli.seltonheitor.damas.excecoes.MovimentoInvalidoException;
import br.com.poli.seltonheitor.damas.jogo.Casa;
import javafx.scene.Group;

public interface TabuleiroInterface {
	public static final int TAMANHO = 80;
	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;

	Casa tabuleiro[][] = new Casa[WIDTH][HEIGHT];

	Group grupoDeCasas = new Group();
	Group grupoDePecas = new Group();

	public abstract void executarMovimentoPeca(int inicialX, int inicialY, int finalX, int finalY)
			throws MovimentoInvalidoException;

	public abstract boolean avaliarMovimento(int inicialX, int inicialY, int finalX, int finalY)
			throws MovimentoInvalidoException;

	public abstract void executaCaptura(int inicialX, int inicialY, int pecaMeioX, int pecaMeioY, int finalX,
			int finalY);

	public abstract boolean avaliarCaptura(int inicialX, int inicialY, CorPeca corInicial);

	public abstract boolean avaliarCapturaCombo(int inicialX, int inicialY);

	public abstract boolean avaliarTabuleiro(int contadorJogadas);

	public abstract boolean avaliarTabuleiroDama(int contadorJogadas);

	public abstract boolean capturarDaPeca(int inicialX, int inicialY, int finalX, int finalY);

	public abstract int toBoard(double pixel);

	public abstract Peca eventoOnMouse(Peca peca);

	public abstract Peca criarPeca(Peca pecaJog, CorPeca cor, int x, int y);

	public abstract void avaliacao(int inicialX, int inicialY, int finalX, int finalY);

	public abstract void gerarTabuleiro();

	public abstract int quantidadePecas(CorPeca cor);

	public abstract boolean imobilizacaoPecas(int numeroDeJogadas);

	public abstract void criarDamas();

	public abstract boolean verificaPeca(int inicialX, int inicialY);

	public abstract boolean avaliarMovimentoDama(int inicialX, int inicialY, int finalX, int finalY);

	public abstract void executarMovimentoDama(int inicialX, int inicialY, int finalX, int finalY);

	public abstract boolean avaliarCapturaDama(int inicialX, int inicialY, CorPeca corInicial)
			throws MovimentoInvalidoException;

	public abstract boolean capturarDaDama(int inicialX, int inicialY, int finalX, int finalY)
			throws MovimentoInvalidoException;

	public abstract boolean avaliarCapturaComboDama(int inicialX, int inicialY);

	public abstract boolean jogar(int inicialX, int inicialY, int finalX, int finalY) throws MovimentoInvalidoException;

	public abstract boolean tratarMovimentoPecaNormal(int inicialX, int inicialY, int finalX, int finalY);

}
