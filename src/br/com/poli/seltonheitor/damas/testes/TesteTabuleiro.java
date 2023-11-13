package br.com.poli.seltonheitor.damas.testes;

import java.util.Scanner;

import br.com.poli.seltonheitor.damas.excecoes.MovimentoInvalidoException;
import br.com.poli.seltonheitor.damas.jogador.Jogador;
import br.com.poli.seltonheitor.damas.jogo.Tabuleiro;

public class TesteTabuleiro {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inicialX, inicialY, finalX, finalY;

		// CRIA OS DOIS JOGADORES
		Jogador jogador1 = new Jogador("Fox");
		Jogador jogador2 = new Jogador("Kyrus");

		// CRIA TABULEIRO
		Tabuleiro tabuleiro = new Tabuleiro(jogador1, jogador2);

		System.out.println();

		// INSERE AS PECAS
		tabuleiro.gerarTabuleiro();

		// MOSTRA TABULEIRO NO CONSOLE
		tabuleiro.mostrarTabuleiro();

		// PEDE E PEGA POSICAO INICIAL DA PECA QUE DESEJA MOVER
		System.out.print("Digite o x inicial da peca: ");
		inicialX = scan.nextInt();
		System.out.print("Digite o y inicial da peca: ");
		inicialY = scan.nextInt();

		// PEDE E PEGA A POSICAO DA CASA QUE DESEJA INSERIR A PECA
		System.out.print("\nDigite o x final da peca: ");
		finalX = scan.nextInt();
		System.out.print("Digite o y final da peca: ");
		finalY = scan.nextInt();

		System.out.println();

		try {
			// EXECUTA O MOVIMENTO
			tabuleiro.avaliarMovimento(inicialX, inicialY, finalX, finalY);
		} catch (MovimentoInvalidoException e) {
			System.out.println("imobilizacao - movimento invalido!");
		}

		// MOSTRA TABULEIRO NOVAMENTE
		tabuleiro.mostrarTabuleiro();
	}

}
