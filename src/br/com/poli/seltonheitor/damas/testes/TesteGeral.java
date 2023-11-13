package br.com.poli.seltonheitor.damas.testes;

import java.util.Scanner;

import br.com.poli.seltonheitor.damas.enums.Resultado;
import br.com.poli.seltonheitor.damas.excecoes.MovimentoInvalidoException;
import br.com.poli.seltonheitor.damas.jogo.Jogo;

public class TesteGeral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inicialX, inicialY, finalX, finalY;
		boolean avaliaJogada;
		String nome1, nome2;

		Scanner scan = new Scanner(System.in);

		Jogo jogo = new Jogo();

		/* PEGA OS NOMES DOS JOGADORES */
		System.out.print("Nome do jogador 1: ");
		nome1 = scan.nextLine();
		System.out.print("Nome do jogador 2: ");
		nome2 = scan.nextLine();

		/* DA INICIO A PARTIDA */
		jogo.iniciarPartida(nome1, nome2);

		do {
			avaliaJogada = false;

			/* MOSTRA TABULEIRO */
			jogo.getTabuleiro().mostrarTabuleiro();

			/* MOSTRA O NUMERO DE JOGADAS ATE O MOMENTO */
			System.out.println("\nNumero de jogadas: " + jogo.getTabuleiro().getNumeroDeJogadas());

			/* DETERMINA DE QUEM EH A VEZ, E MOSTRA NO CONSOLE */
			if (jogo.getTabuleiro().getContadorJogadas() % 2 == 0) {
				System.out.println(jogo.getTabuleiro().getJogador1().getNome() + " eh a sua vez! (CLARAS)");
			} else {
				System.out.println(jogo.getTabuleiro().getJogador2().getNome() + " eh a sua vez! (ESCURAS)");
			}

			do {
				// PEDE E PEGA POSICAO INICIAL DA PECA QUE DESEJA MOVER
				System.out.print("\nDigite o x inicial da peca: ");
				inicialX = scan.nextInt();
				System.out.print("Digite o y inicial da peca: ");
				inicialY = scan.nextInt();

				// PEDE E PEGA A POSICAO DA CASA QUE DESEJA INSERIR A PECA
				System.out.print("\nDigite o x final da peca: ");
				finalX = scan.nextInt();
				System.out.print("Digite o y final da peca: ");
				finalY = scan.nextInt();

				try {
					avaliaJogada = jogo.getTabuleiro().jogar(inicialX, inicialY, finalX, finalY);
				} catch (MovimentoInvalidoException e) {
					System.out.println("\nValores Invalidos!!");
				}

				if (!avaliaJogada) {
					jogo.getTabuleiro().mostrarTabuleiro();

					System.out.println("\nNumero de jogadas: " + jogo.getTabuleiro().getNumeroDeJogadas());

					if (jogo.getTabuleiro().getContadorJogadas() % 2 == 0) {
						System.out.println(jogo.getTabuleiro().getJogador1().getNome() + " eh a sua vez! (CLARAS)");
					} else {
						System.out.println(jogo.getTabuleiro().getJogador2().getNome() + " eh a sua vez! (ESCURAS)");
					}
				}

			} while (!avaliaJogada);

			// Cria Dama
			jogo.getTabuleiro().criarDamas();

			/*
			 * CONTA AS JOGADAS E ENVIA PARA O TABULEIRO PARA QUE ELE POSSA
			 * AVALIAR DE QUEM EH A VEZ DE JOGAR
			 */
			jogo.getTabuleiro().setNumeroDeJogadas(jogo.getTabuleiro().getNumeroDeJogadas() + 1);
			jogo.getTabuleiro().setJogadas(jogo.getTabuleiro().getContadorJogadas());

		} while (!jogo.isFimDeJogo());

		jogo.getTabuleiro().mostrarTabuleiro();

		System.out.println("\n\nFim do jogo\n");
		System.out.println("Tempo da partida: " + String.valueOf(jogo.tempoDeJogo() / 60) + " minutos.");

		if (jogo.getResultado() == Resultado.COMVENCEDOR) {
			System.out.println("\nParabens " + jogo.getTabuleiro().getVencedor().getNome() + " voce venceu!!");
		} else {
			System.out.println("\nJogo empatado!!");
		}

	}

}
