package br.com.poli.seltonheitor.damas.jogo;

import java.util.Calendar;

import br.com.poli.seltonheitor.damas.enums.CorPeca;
import br.com.poli.seltonheitor.damas.enums.Resultado;
import br.com.poli.seltonheitor.damas.excecoes.MovimentoInvalidoException;
import br.com.poli.seltonheitor.damas.jogador.Jogador;

public class Jogo implements JogoInterface {
	private Jogador jogador1;
	private Jogador jogador2;
	private Jogador vencedor;
	private Tabuleiro tabuleiro;
	private Resultado resultado;
	/* AVALIA O NUMERO DE JOGADAS SEGUIDAS COM DAMAS */
	private int contadorJogadas;
	private Calendar tempoInicial;
	private Calendar contaTempo;
	private Calendar tempoFinal;
	/* Conta as jogadas para avaliar quem eh ojogador no Tabuleiro */
	private int numeroDeJogadas;

	/* CONSTRUTOR DA CLASSE JOGO */
	public Jogo() {

	}

	public Calendar getContaTempo() {
		return contaTempo;
	}

	public void setContaTempo(Calendar contaTempo) {
		this.contaTempo = contaTempo;
	}

	public Calendar getTempoFinal() {
		return tempoFinal;
	}

	public void setTempoInicial(Calendar tempoInicial) {
		this.tempoInicial = tempoInicial;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public Jogador getJogador1() {
		return jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

	public Jogador getVencedor() {
		return this.vencedor;
	}

	public void setVencedor(Jogador vencedor) {
		this.vencedor = vencedor;
	}

	public int getNumeroDeJogadas() {
		return numeroDeJogadas;
	}

	public void setNumeroDeJogadas(int numeroDeJogadas) {
		this.numeroDeJogadas = numeroDeJogadas;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public int getContadorJogadas() {
		return numeroDeJogadas;
	}

	public void setContadorJogadas(int contadorJogadas) {
		this.numeroDeJogadas = contadorJogadas;
	}

	public Calendar getTempoInicial() {
		return tempoInicial;
	}

	public void setTempoFinal(Calendar tempoFinal) {
		this.tempoFinal = tempoFinal;
	}

	/* VERIFICA SE O JOGO EMPATOU */
	public boolean verificaEmpate() {
		boolean empate = false;

		this.contadorJogadas = this.tabuleiro.getContadorJogadas();
		this.numeroDeJogadas = this.tabuleiro.getNumeroDeJogadas();

		/* ATINGIU O NUMERO MAXIMO DE JOGADAS CONSECUTIVAS COM A DAMA ? */
		if (this.contadorJogadas == 20) {
			empate = true;
		}

		return empate;
	}

	/* Analisa se o jogo terminou */
	public boolean isFimDeJogo() {
		boolean fim = false;

		/* O JOGO FOI EMPATE ? */
		if (verificaEmpate()) {
			fim = true;

			this.vencedor = null;

			/* DETERMINA O MOMENTO QUE O JOGO TERMINOU */
			this.tempoFinal = Calendar.getInstance();

			/* DETERMINA O RESULTADO DO JOGO */
			this.resultado = Resultado.EMPATE;
		}
		/* O JOGADOR 2 VENCEU ? */
		else if (this.tabuleiro.quantidadePecas(CorPeca.CLARA) == 0) {
			fim = true;

			/* DETERMINA QUAL JOGADOR VENCEU */
			this.vencedor = this.jogador2;
			this.tabuleiro.setVencedor(this.vencedor);

			/* DETERMINA O MOMENTO QUE O JOGO TERMINOU */
			this.tempoFinal = Calendar.getInstance();

			/* DETERMINA O RESULTADO DO JOGO */
			this.resultado = Resultado.COMVENCEDOR;
		}
		/* O JOGADOR 1 VENCEU ? */
		else if (this.tabuleiro.quantidadePecas(CorPeca.ESCURA) == 0) {
			fim = true;

			/* DETERMINA QUAL JOGADOR VENCEU */
			this.vencedor = this.jogador1;
			this.tabuleiro.setVencedor(this.vencedor);

			/* DETERMINA O MOMENTO QUE O JOGO TERMINOU */
			this.tempoFinal = Calendar.getInstance();

			/* DETERMINA O RESULTADO DO JOGO */
			this.resultado = Resultado.COMVENCEDOR;
		}
		/* AS PECAS ESTAO IMOBILIZADAS (SEM MOVIMENTOS POSSIVEIS) ? */
		else if (this.tabuleiro.imobilizacaoPecas(this.numeroDeJogadas)) {
			// verifica se tem movimento da peca normal
			// verifica se tem movimento com Dama
			// verifica se tem captura normal
			// verifica se tem captura com a dama

			if (!this.tabuleiro.avaliarTabuleiroDama(this.numeroDeJogadas)) {
				if (!this.tabuleiro.avaliarTabuleiro(this.numeroDeJogadas)) {
					fim = true;
					this.vencedor = this.tabuleiro.getVencedor();

					this.resultado = Resultado.COMVENCEDOR;
				}
			}

		}

		return fim;
	}

	public Jogador retornaVencedor() {
		if (this.resultado.equals(Resultado.COMVENCEDOR)) {
			return this.vencedor;
		} else {
			return null;
		}
	}

	public void capturar(int origemX, int origemY, int destinoX, int destinoY) {
		try {
			this.tabuleiro.jogar(origemX, origemY, destinoX, destinoY);
		} catch (MovimentoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Incrementa o tempo
	public void contaTempo() {
		this.contaTempo.setTimeInMillis(this.contaTempo.getTimeInMillis() + 1000);
	}

	/* RETORNA O TEMPO QUE O JOGO DUROU */
	public long tempoDeJogo() {
		return (this.tempoFinal.getTimeInMillis() - this.tempoInicial.getTimeInMillis()) / 1000;
	}

	public void iniciarPartida(String nomeUm, String nomeDois) {

		if (nomeUm == "Computador" || nomeDois == "Computador") {
			// Jogador 1 (CLARAS) sera autonomo:
			if (nomeUm == "Computador") {
				this.jogador1 = new JogadorAutonomo(nomeUm);
				this.jogador2 = new Jogador(nomeDois);
			}
			// Jogador 2 (ESCURAS) sera autonomo:
			else {
				this.jogador1 = new Jogador(nomeUm);
				this.jogador2 = new JogadorAutonomo(nomeDois);
			}

		} else {
			/* INSERE OS NOMES DOS JOGADORES */
			this.jogador1 = new Jogador(nomeUm);
			this.jogador2 = new Jogador(nomeDois);
		}

		/*
		 * CRIA O TABULEIRO E JA INSERE AS PECAS E AS CORES DAS CASA, POIS O
		 * "gerarTabulero() E "inserirPecas()" ESTAO DENTRO DO CONSTRUTOR
		 */
		this.tabuleiro = new Tabuleiro(this.jogador1, this.jogador2);

		/* PEGA O TEMPO QUE O JOGO COMECOU */
		this.tempoInicial = Calendar.getInstance();
		this.contaTempo = this.tempoInicial;

	}

}
