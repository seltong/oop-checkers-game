package br.com.poli.seltonheitor.damas.testes;

import java.util.Scanner;

import br.com.poli.seltonheitor.damas.enums.Resultado;
import br.com.poli.seltonheitor.damas.excecoes.MovimentoInvalidoException;
import br.com.poli.seltonheitor.damas.jogo.Jogo;

public class TesteJogo {

	public static void main(String[] args) {
		int inicialX, inicialY, finalX, finalY;
		boolean avaliaJogada = false;

		Jogo jogo = new Jogo();

		Scanner scan = new Scanner(System.in);

		/* DA INICIO A PARTIDA */
		jogo.iniciarPartida("nome1", "nome2");

		do {
			/* MOSTRA TABULEIRO */
			jogo.getTabuleiro().mostrarTabuleiro();

			/* MOSTRA O NUMERO DE JOGADAS ATE O MOMENTO */
			System.out.println("\nNumero de jogadas: " + jogo.getNumeroDeJogadas());

			/* DETERMINA DE QUEM EH A VEZ, E MOSTRA NO CONSOLE */
			if (jogo.getContadorJogadas() % 2 == 0) {
				System.out.println(jogo.getJogador1().getNome() + " eh a sua vez! (CLARAS)");
			} else {
				System.out.println(jogo.getJogador2().getNome() + " eh a sua vez! (ESCURAS)");
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

				try{
					avaliaJogada = jogo.getTabuleiro().jogar(inicialX, inicialY, finalX, finalY);
				}catch(MovimentoInvalidoException e){
					System.out.println("\nJogada Invalida!!");
				}
				

				if (!avaliaJogada) {
					jogo.getTabuleiro().mostrarTabuleiro();
				}

			} while (!avaliaJogada);
			jogo.getTabuleiro().criarDamas();

			/*
			 * CONTA AS JOGADAS E ENVIA PARA O TABULEIRO PARA QUE ELE POSSA
			 * AVALIAR DE QUEM EH A VEZ DE JOGAR
			 */
			jogo.setNumeroDeJogadas(jogo.getNumeroDeJogadas() + 1);
			jogo.getTabuleiro().setJogadas(jogo.getContadorJogadas());

		} while (!jogo.isFimDeJogo());

		System.out.println("Fim do jogo");

		if (jogo.getResultado() == Resultado.COMVENCEDOR) {
			System.out.println("\nParabens " + jogo.getVencedor() + "voce venceu!!");
		} else {
			System.out.println("\nJogo empatado!!");
		}

	}

}
