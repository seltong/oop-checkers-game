package br.com.poli.seltonheitor.damas.jogo;

import br.com.poli.seltonheitor.damas.enums.CorPeca;
import br.com.poli.seltonheitor.damas.excecoes.MovimentoInvalidoException;
import br.com.poli.seltonheitor.damas.jogador.Jogador;
import javafx.scene.Group;

//Tabuleiro eh responsavel por conter os dados referentes a jogadas e pecas
public class Tabuleiro implements TabuleiroInterface {
	public static final int TAMANHO = 80;
	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;

	Group grupoDeCasas = new Group();
	Group grupoDePecas = new Group();

	private Peca pecasClaras;
	private Peca pecasEscuras;
	private Dama dama;
	private Casa[][] grid = new Casa[WIDTH][HEIGHT];
	private int contadorJogadas; // AVALIA O NUMERO DE JOGADAS SEGUIDAS COM
									// DAMAS
	private int numeroDeJogadas; // Conta as jogadas para avaliar quem eh
									// o jogador no Tabuleiro
	private byte cont = 0; // Conta as jogadas para mudar a frase de erro
	private Jogador jogador1;
	private Jogador jogador2;
	private int quantidadePecasClaras = 12;
	private int quantidadePecasEscuras = 12;
	private Jogador vencedor;
	private int[] capturaPeca = new int[4];
	private int[] capturaDama = new int[4];

	// CONSTRUTOR da class TABULEIRO
	public Tabuleiro(Jogador jogador1, Jogador jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;

		this.pecasClaras = new Peca(jogador1, CorPeca.CLARA);
		this.pecasEscuras = new Peca(jogador2, CorPeca.ESCURA);

		gerarTabuleiro();
	}

	public void setVencedor(Jogador vencedor) {
		this.vencedor = vencedor;
	}

	public Jogador getVencedor() {
		return vencedor;
	}

	public int[] getCapturaPeca() {
		return capturaPeca;
	}

	public void setCapturaPeca(int[] capturaPeca) {
		this.capturaPeca = capturaPeca;
	}

	public int[] getCapturaDama() {
		return capturaDama;
	}

	public void setCapturaDama(int[] capturaDama) {
		this.capturaDama = capturaDama;
	}

	public int getQuantidadePecasClaras() {
		return quantidadePecasClaras;
	}

	public void setQuantidadePecasClaras(int quantidadePecasClaras) {
		this.quantidadePecasClaras = quantidadePecasClaras;
	}

	public int getQuantidadePecasEscuras() {
		return quantidadePecasEscuras;
	}

	public void setQuantidadePecasEscuras(int quantidadePecasEscuras) {
		this.quantidadePecasEscuras = quantidadePecasEscuras;
	}

	public int getContadorJogadas() {
		return contadorJogadas;
	}

	public Jogador getJogador1() {
		return jogador1;
	}

	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}

	public void setContadorJogadas(int contadorJogadas) {
		this.contadorJogadas = contadorJogadas;
	}

	public Casa[][] getGrid() {
		return this.grid;
	}

	// GET DO ATRIBUTO JOGADAS
	public int getJogadas() {
		return numeroDeJogadas;
	}

	// SET DO ATRIBUTO JOGADAS
	public void setJogadas(int jogadas) {
		this.numeroDeJogadas = jogadas;
	}

	public Group getGrupoDeCasas() {
		return grupoDeCasas;
	}

	public void setGrupoDeCasas(Group grupoDeCasas) {
		this.grupoDeCasas = grupoDeCasas;
	}

	public Group getGrupoDePecas() {
		return grupoDePecas;
	}

	public void setGrupoDePecas(Group grupoDePecas) {
		this.grupoDePecas = grupoDePecas;
	}

	public int getNumeroDeJogadas() {
		return numeroDeJogadas;
	}

	public void setNumeroDeJogadas(int numeroDeJogadas) {

		this.numeroDeJogadas = numeroDeJogadas;
	}

	// MOSTRA TABULEIRO:
	public void mostrarTabuleiro() {

		System.out.println("\n  0  1  2  3  4  5  6  7");
		for (int i = 0; i < this.grid.length; i++) {
			if (i >= 0)
				System.out.print(i);

			for (int j = 0; j < this.grid.length; j++) {
				if (!this.grid[i][j].isValida()) {
					System.out.print("|-|");
				} else if (this.grid[i][j].isOcupada()) {
					if (this.grid[i][j].getPeca() instanceof Dama) {
						if (this.grid[i][j].getPeca().getCor() == CorPeca.ESCURA)
							System.out.print("|E|");
						else
							System.out.print("|C|");
					} else if (this.grid[i][j].getPeca() instanceof Peca) {
						if (this.grid[i][j].getPeca().getCor() == CorPeca.ESCURA)
							System.out.print("|e|");
						else
							System.out.print("|c|");
					}
				} else {
					System.out.print("| |");
				}

			}
			System.out.println();
		}

	}

	public void executarMovimento(int origemX, int origemY, int destinoX, int destinoY) {
		try {
			jogar(origemX, origemY, destinoX, destinoY);
		} catch (MovimentoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// REALIZA O MOVIMENTO DAS PECAS:
	public void executarMovimentoPeca(int inicialX, int inicialY, int finalX, int finalY)
			throws MovimentoInvalidoException {
		if (!this.grid[inicialX][inicialY].isOcupada()) {
			throw new MovimentoInvalidoException("Posicao inicial nao possui peca");
		} else {
			// COLOCA A PECA NA POSICAO:
			this.grid[finalX][finalY].setPeca(this.grid[inicialX][inicialY].getPeca());
			this.grid[finalX][finalY].setOcupada(true);

			this.grid[finalX][finalY].getPeca().move(finalY, finalX);

			// REMOVE A PECA DA POSICAO ANTERIOR:
			this.grid[inicialX][inicialY].setPeca(null);
			this.grid[inicialX][inicialY].setOcupada(false);
		}

	}

	// "executarMovimento()" que ira realizar o movimento de uma pecas entre as
	// casas
	public boolean avaliarMovimento(int inicialX, int inicialY, int finalX, int finalY)
			throws MovimentoInvalidoException {
		boolean movimentoValido = false;

		if (!this.grid[inicialX][inicialY].isOcupada()) {

		} else if (this.grid[finalX][finalY].isOcupada()) {

		} else if (finalX >= this.grid.length) {

		} else if (finalY >= this.grid.length) {

		} else {
			if (this.numeroDeJogadas % 2 != 0) {
				if (this.grid[inicialX][inicialY].getPeca().getCor().equals(CorPeca.ESCURA)) {
					if (inicialX + 1 < this.grid.length) {
						if (inicialY + 1 < this.grid.length) {
							if (this.grid[inicialX + 1][inicialY + 1] == this.grid[finalX][finalY]) {
								movimentoValido = true;
							}
						}
						if (inicialY - 1 >= 0) {
							if (this.grid[inicialX + 1][inicialY - 1] == this.grid[finalX][finalY]) {
								movimentoValido = true;
							}
						}
					}
				}
			} else if (this.numeroDeJogadas % 2 == 0) {
				if (inicialX - 1 >= 0 && inicialX - 1 < this.grid.length) {
					if (inicialY + 1 < this.grid.length) {
						if (this.grid[inicialX - 1][inicialY + 1] == this.grid[finalX][finalY]) {
							movimentoValido = true;
						}
					}
					if (inicialY - 1 >= 0 && inicialY - 1 < this.grid.length) {
						if (this.grid[inicialX - 1][inicialY - 1] == this.grid[finalX][finalY]) {
							movimentoValido = true;
						}
					}
				}
			}
		}
		return movimentoValido;

	}

	/* Executa Captura */
	public void executaCaptura(int inicialX, int inicialY, int pecaMeioX, int pecaMeioY, int finalX, int finalY) {

		if (this.grid[inicialX][inicialY].getPeca().getCor().equals(CorPeca.CLARA))
			this.quantidadePecasEscuras--;
		else
			this.quantidadePecasClaras--;

		this.grid[finalX][finalY].setPeca(this.grid[inicialX][inicialY].getPeca());
		this.grid[finalX][finalY].setOcupada(true);

		this.grid[finalX][finalY].getPeca().move(finalY, finalX);

		grupoDePecas.getChildren().remove(this.grid[inicialX][inicialY].getPeca());
		grupoDePecas.getChildren().add(this.grid[finalX][finalY].getPeca());

		this.grid[inicialX][inicialY].setPeca(null);
		this.grid[inicialX][inicialY].setOcupada(false);

		grupoDePecas.getChildren().remove(this.grid[pecaMeioX][pecaMeioY].getPeca());

		this.grid[pecaMeioX][pecaMeioY].setPeca(null);
		this.grid[pecaMeioX][pecaMeioY].setOcupada(false);

	}

	// CAPTURA AS PECAS ADVERSARIAS
	public boolean avaliarCaptura(int inicialX, int inicialY, CorPeca corInicial) {
		boolean captura = false;

		if (!this.grid[inicialX][inicialY].isOcupada()) {

		} else {
			if (inicialX < 6) {
				if (inicialY < 6) {
					if (this.grid[inicialX + 1][inicialY + 1].isOcupada()) {
						if (!this.grid[inicialX + 1][inicialY + 1].getPeca().getCor().equals(corInicial)) {
							if (!this.grid[inicialX + 2][inicialY + 2].isOcupada()) {
								/* Peca ESCURA pode Capturar */
								captura = true;

								this.capturaPeca[2] = inicialX + 2;
								this.capturaPeca[3] = inicialY + 2;

								return captura;
							}
						}
					}
				}
				if (inicialY > 1) {
					if (this.grid[inicialX + 1][inicialY - 1].isOcupada()) {
						if (!this.grid[inicialX + 1][inicialY - 1].getPeca().getCor().equals(corInicial)) {
							if (!this.grid[inicialX + 2][inicialY - 2].isOcupada()) {
								/* Peca ESCURA pode Capturar */
								captura = true;

								this.capturaPeca[2] = inicialX + 2;
								this.capturaPeca[3] = inicialY - 2;

								return captura;
							}
						}
					}
				}
			}
			if (inicialX > 1) {
				if (inicialY < 6) {
					if (this.grid[inicialX - 1][inicialY + 1].isOcupada()) {
						if (!this.grid[inicialX - 1][inicialY + 1].getPeca().getCor().equals(corInicial)) {
							if (!this.grid[inicialX - 2][inicialY + 2].isOcupada()) {
								/* Peca ESCURA pode Capturar */
								captura = true;

								this.capturaPeca[2] = inicialX - 2;
								this.capturaPeca[3] = inicialY + 2;

								return captura;
							}
						}
					}
				}
				if (inicialY > 1) {
					if (this.grid[inicialX - 1][inicialY - 1].isOcupada()) {
						if (!this.grid[inicialX - 1][inicialY - 1].getPeca().getCor().equals(corInicial)) {
							if (!this.grid[inicialX - 2][inicialY - 2].isOcupada()) {
								/* Peca ESCURA pode Capturar */
								captura = true;

								this.capturaPeca[2] = inicialX - 2;
								this.capturaPeca[3] = inicialY - 2;

								return captura;
							}
						}
					}
				}
			}
		}
		return captura;
	}

	/* VERIFICA SE EH POSSIVEL COMER MAIS PECAS */
	public boolean avaliarCapturaCombo(int inicialX, int inicialY) {
		boolean captura = false;
		CorPeca corInicial;

		if (this.numeroDeJogadas % 2 == 0) {
			corInicial = CorPeca.CLARA;
		} else {
			corInicial = CorPeca.ESCURA;
		}

		if (!this.grid[inicialX][inicialY].isOcupada()) {

		} else {
			if (inicialX < 6) {
				if (inicialY < 6) {
					if (this.grid[inicialX + 1][inicialY + 1].isOcupada()) {
						if (!this.grid[inicialX + 1][inicialY + 1].getPeca().getCor().equals(corInicial)) {
							if (!this.grid[inicialX + 2][inicialY + 2].isOcupada()) {
								/* Peca ESCURA pode Capturar */
								captura = true;

								this.capturaPeca[0] = inicialX;
								this.capturaPeca[1] = inicialY;
								this.capturaPeca[2] = inicialX + 2;
								this.capturaPeca[3] = inicialY + 2;

								return captura;
							}
						}
					}
				}
				if (inicialY > 1) {
					if (this.grid[inicialX + 1][inicialY - 1].isOcupada()) {
						if (!this.grid[inicialX + 1][inicialY - 1].getPeca().getCor().equals(corInicial)) {
							if (!this.grid[inicialX + 2][inicialY - 2].isOcupada()) {
								/* Peca ESCURA pode Capturar */
								captura = true;

								this.capturaPeca[0] = inicialX;
								this.capturaPeca[1] = inicialY;
								this.capturaPeca[2] = inicialX + 2;
								this.capturaPeca[3] = inicialY - 2;

								return captura;
							}
						}
					}
				}
			}
			if (inicialX > 1) {
				if (inicialY < 6) {
					if (this.grid[inicialX - 1][inicialY + 1].isOcupada()) {
						if (!this.grid[inicialX - 1][inicialY + 1].getPeca().getCor().equals(corInicial)) {
							if (!this.grid[inicialX - 2][inicialY + 2].isOcupada()) {
								/* Peca ESCURA pode Capturar */
								captura = true;

								this.capturaPeca[0] = inicialX;
								this.capturaPeca[1] = inicialY;
								this.capturaPeca[2] = inicialX - 2;
								this.capturaPeca[3] = inicialY + 2;

								return captura;
							}
						}
					}
				}
				if (inicialY > 1) {
					if (this.grid[inicialX - 1][inicialY - 1].isOcupada()) {
						if (!this.grid[inicialX - 1][inicialY - 1].getPeca().getCor().equals(corInicial)) {
							if (!this.grid[inicialX - 2][inicialY - 2].isOcupada()) {
								/* Peca ESCURA pode Capturar */
								captura = true;

								this.capturaPeca[0] = inicialX;
								this.capturaPeca[1] = inicialY;
								this.capturaPeca[2] = inicialX - 2;
								this.capturaPeca[3] = inicialY - 2;

								return captura;
							}
						}
					}
				}
			}
		}
		return captura;
	}

	/* Avalia se ha captura a ser efetuada em alguma parte do tabuleiro */
	public boolean avaliarTabuleiro(int contadorJogadas) {
		boolean retorno = false;
		CorPeca cor;

		if (contadorJogadas % 2 == 0)
			cor = CorPeca.CLARA;
		else
			cor = CorPeca.ESCURA;

		for (int x = 0; x < this.grid.length; x++) {
			for (int y = 0; y < this.grid.length; y++) {
				if (this.grid[x][y].isOcupada()) {
					if (this.grid[x][y].getPeca().getCor() == cor) {
						retorno = avaliarCaptura(x, y, cor);
						if (retorno == true) {
							this.capturaPeca[0] = x;
							this.capturaPeca[1] = y;

							return retorno;
						}
					}
				}
			}
		}

		return retorno;
	}

	// Avalia se ha captura com a dama a ser efetuada em alguma parte do
	// tabuleiro
	public boolean avaliarTabuleiroDama(int contadorJogadas) {
		boolean retorno = false;
		CorPeca cor;

		if (contadorJogadas % 2 == 0)
			cor = CorPeca.CLARA;
		else
			cor = CorPeca.ESCURA;

		for (int x = 0; x < this.grid.length; x++) {
			for (int y = 0; y < this.grid.length; y++) {
				if (this.grid[x][y].isOcupada()) {
					if (this.grid[x][y].getPeca() instanceof Dama) {
						if (this.grid[x][y].getPeca().getCor() == cor) {

							try {
								retorno = avaliarCapturaDama(x, y, cor);
							} catch (MovimentoInvalidoException e) {
								System.out.println("Opa");
							}

							if (retorno == true) {
								this.capturaDama[0] = x;
								this.capturaDama[1] = y;

								return retorno;

							}
						}
					}
				}
			}
		}

		return retorno;
	}

	/* VERIFICA SE A CAPTURA ESCOLHIDA PELO USUARIO ESTA DE ACORDO */
	public boolean capturarDaPeca(int inicialX, int inicialY, int finalX, int finalY) {
		boolean captura = false;
		CorPeca corInicial;

		/* Exceptions */
		if (!this.grid[inicialX][inicialY].isOcupada()) {
		} else {
			if (this.numeroDeJogadas % 2 == 0) {
				corInicial = CorPeca.CLARA;
			} else {
				corInicial = CorPeca.ESCURA;
			}

			if (this.grid[inicialX][inicialY].getPeca().getCor().equals(corInicial)) {
				if (inicialX + 2 == finalX) {
					if (inicialY + 2 == finalY) {
						if (this.grid[inicialX + 1][inicialY + 1].isOcupada()) {
							if (!this.grid[inicialX + 1][inicialY + 1].getPeca().getCor().equals(corInicial)) {
								if (!this.grid[inicialX + 2][inicialY + 2].isOcupada()) {
									/* Executa Captura */
									executaCaptura(inicialX, inicialY, inicialX + 1, inicialY + 1, finalX, finalY);
									captura = true;
								}
							}
						}
					} else if (inicialY - 2 == finalY) {
						if (this.grid[inicialX + 1][inicialY - 1].isOcupada()) {
							if (!this.grid[inicialX + 1][inicialY - 1].getPeca().getCor().equals(corInicial)) {
								if (!this.grid[inicialX + 2][inicialY - 2].isOcupada()) {
									/* Executa Captura */
									executaCaptura(inicialX, inicialY, inicialX + 1, inicialY - 1, finalX, finalY);
									captura = true;
								}
							}
						}
					}
				} else if (inicialX - 2 == finalX) {
					if (inicialY + 2 == finalY) {
						if (this.grid[inicialX - 1][inicialY + 1].isOcupada()) {
							if (!this.grid[inicialX - 1][inicialY + 1].getPeca().getCor().equals(corInicial)) {
								if (!this.grid[inicialX - 2][inicialY + 2].isOcupada()) {
									/* Executa Captura */
									executaCaptura(inicialX, inicialY, inicialX - 1, inicialY + 1, finalX, finalY);
									captura = true;
								}
							}
						}
					} else if (inicialY - 2 == finalY) {
						if (this.grid[inicialX - 1][inicialY - 1].isOcupada()) {
							if (!this.grid[inicialX - 1][inicialY - 1].getPeca().getCor().equals(corInicial)) {
								if (!this.grid[inicialX - 2][inicialY - 2].isOcupada()) {
									/* Executa Captura */
									executaCaptura(inicialX, inicialY, inicialX - 1, inicialY - 1, finalX, finalY);
									captura = true;
								}
							}
						}
					}
				}
			}
		}
		return captura;
	}

	public int toBoard(double pixel) {
		return (int) (pixel + TAMANHO / 2) / TAMANHO;
	}

	public Peca eventoOnMouse(Peca peca) {
		peca.setOnMouseReleased(e -> {
			int finalX = toBoard(peca.getLayoutY());
			int finalY = toBoard(peca.getLayoutX());

			int x0 = toBoard(peca.getInicialX());
			int y0 = toBoard(peca.getInicialY());

			try {

				/* MOSTRA TABULEIRO */
				mostrarTabuleiro();

				/* MOSTRA O NUMERO DE JOGADAS ATE O MOMENTO */
				System.out.println("\nNumero de jogadas: " + getNumeroDeJogadas());

				/* DETERMINA DE QUEM EH A VEZ, E MOSTRA NO CONSOLE */
				if (getNumeroDeJogadas() % 2 == 0) {
					System.out.println(getJogador1().getNome() + " eh a sua vez! (CLARAS)");
				} else {
					System.out.println(getJogador2().getNome() + " eh a sua vez! (ESCURAS)");
				}

				if (jogar(x0, y0, finalX, finalY)) {
					setNumeroDeJogadas(getNumeroDeJogadas() + 1);
					criarDamas();
				}

				mostrarTabuleiro();

				System.out.println("\nNumero de jogadas: " + getNumeroDeJogadas());

				if (getNumeroDeJogadas() % 2 == 0) {
					System.out.println(getJogador1().getNome() + " eh a sua vez! (CLARAS)");
				} else {
					System.out.println(getJogador2().getNome() + " eh a sua vez! (ESCURAS)");
				}

			} catch (Exception ev) {
			}
		});

		return peca;
	}

	public Peca criarPeca(Peca pecaJog, CorPeca cor, int x, int y) {
		Peca peca = new Peca(pecaJog.getJogador(), cor, x, y);

		peca = eventoOnMouse(peca);
		return peca;
	}

	public void avaliacao(int inicialX, int inicialY, int finalX, int finalY) {
		/*
		 * try { this.jogo.jogar(inicialX, inicialY, finalX, finalY); } catch
		 * (MovimentoInvalidoException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	// "gerarTabuleiro()" eh responsavel por iniciar o tabuleiro, conforme as
	// regras do jogo
	public void gerarTabuleiro() {

		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {

				Casa casa = new Casa((x + y) % 2 == 0, x, y);
				this.grid[y][x] = casa;

				grupoDeCasas.getChildren().add(casa);

				Peca peca = null;

				if (y <= 2 && (x + y) % 2 != 0) {
					peca = criarPeca(this.pecasEscuras, CorPeca.ESCURA, x, y);
					this.grid[y][x].setPeca(peca);
					this.grid[y][x].setOcupada(true);
				}
				if (y >= 5 && (x + y) % 2 != 0) {
					peca = criarPeca(this.pecasClaras, CorPeca.CLARA, x, y);
					this.grid[y][x].setPeca(peca);
					this.grid[y][x].setOcupada(true);
				}

				if (peca != null) {
					casa.setPeca(peca);
					grupoDePecas.getChildren().add(peca);
				}
			}
		}
	}

	/*
	 * VERIFICA QUANTAS PECAS AINDA ESTAO NO TABULEIRO DEPENDENDO DA COR
	 * ESCOLHIDA
	 */
	public int quantidadePecas(CorPeca cor) {
		int quantidade = 0;

		for (int x = 0; x < this.grid.length; x++) {
			for (int y = 0; y < this.grid.length; y++) {
				if (this.grid[x][y].isOcupada()) {
					if (this.grid[x][y].getPeca().getCor().equals(cor)) {
						quantidade++;
					}
				}
			}
		}

		return quantidade;
	}

	/* Avalia se ainda ha movimentos possiveis */
	public boolean imobilizacaoPecas(int numeroDeJogadas) {
		boolean imobilizado = false;
		CorPeca cor;

		this.numeroDeJogadas++;

		if (numeroDeJogadas % 2 != 0) {
			cor = CorPeca.CLARA;

			if (this.quantidadePecasEscuras == 1) {
				for (int i = 0; i < this.grid.length; i++) {
					for (int j = 0; j < this.grid.length; j++) {
						if (this.grid[i][j].isOcupada()) {
							if (!this.grid[i][j].getPeca().getCor().equals(cor)) {
								try {
									if (i - 1 >= 0 && j + 1 < this.grid.length) {
										imobilizado = !avaliarMovimento(i, j, i - 1, j + 1);

										if (imobilizado) {
											if (i - 1 >= 0 && j - 1 >= 0) {
												imobilizado = !avaliarMovimento(i, j, i - 1, j - 1);
												if (imobilizado) {
													this.vencedor = this.jogador1;
												}
												this.numeroDeJogadas--;
												return imobilizado;
											}
										}
										this.numeroDeJogadas--;
										return imobilizado;
									}
								} catch (MovimentoInvalidoException e) {

								}
							}
						}
					}
				}
			}

		} else {
			cor = CorPeca.ESCURA;

			if (this.quantidadePecasClaras == 1) {
				for (int i = 0; i < this.grid.length; i++) {
					for (int j = 0; j < this.grid.length; j++) {
						if (this.grid[i][j].isOcupada()) {
							if (!this.grid[i][j].getPeca().getCor().equals(cor)) {
								try {
									if (i - 1 >= 0 && j + 1 < this.grid.length) {
										imobilizado = !avaliarMovimento(i, j, i - 1, j + 1);

										if (imobilizado) {
											if (j - 1 >= 0) {
												imobilizado = !avaliarMovimento(i, j, i - 1, j - 1);
												if (imobilizado) {
													this.vencedor = this.jogador2;
												}
												this.numeroDeJogadas--;
												return imobilizado;
											}
										}
										this.numeroDeJogadas--;
										return imobilizado;

									}
								} catch (MovimentoInvalidoException e) {

								}
							}
						}
					}
				}
			}
		}

		for (int x = 0; x < this.grid.length; x++) {
			for (int y = 0; y < this.grid.length; y++) {
				if (this.grid[x][y].isOcupada()) {
					if (this.grid[x][y].getPeca().getCor().equals(cor)) {
						if (cor.equals(CorPeca.ESCURA)) {
							if (x + 1 < this.grid.length) {
								// Verifica se ha movimento com a peca normal
								try {
									if (y + 1 < this.grid.length) {
										// Avalia movimento com a Peca
										imobilizado = (!avaliarMovimento(x, y, x + 1, y + 1));
									}
								} catch (MovimentoInvalidoException e) {
									System.out.println("imobilizacao - movimento invalido!");
								}

								if (imobilizado == false) {
									this.numeroDeJogadas--;
									return imobilizado;
								}

								try {
									if (y - 1 >= 0) {
										// Avalia movimento com a Peca
										imobilizado = (!avaliarMovimento(x, y, x + 1, y - 1));
									}
								} catch (MovimentoInvalidoException e) {
									System.err.println("imobilizacao - movimento invalido!");
								}

								if (imobilizado == false) {
									this.numeroDeJogadas--;
									return imobilizado;
								}
							}
						} else {
							if (x - 1 > 0) {
								try {
									if (y + 1 < this.grid.length) {
										// Avalia movimento com a Peca
										imobilizado = (!avaliarMovimento(x, y, x - 1, y + 1));
									}
								} catch (MovimentoInvalidoException e) {
									System.err.println("imobilizacao - movimento invalido!");
								}

								if (imobilizado == false) {
									this.numeroDeJogadas--;
									return imobilizado;
								}

								try {
									if (y - 1 >= 0) {
										// Avalia movimento com a Peca
										imobilizado = (!avaliarMovimento(x, y, x - 1, y - 1));
									}
								} catch (MovimentoInvalidoException e) {
									System.out.println("imobilizacao - movimento invalido!");
								}

								if (imobilizado == false) {
									this.numeroDeJogadas--;
									return imobilizado;
								}
							}
						}
					}
				}
			}
		}

		this.numeroDeJogadas--;

		return imobilizado;
	}

	/* CRIA DAMA */
	public void criarDamas() {

		for (int y = 0; y < this.grid.length; y++) {
			if (this.grid[0][y].isOcupada()) {
				if (!verificaPeca(0, y)) {
					if (this.grid[0][y].getPeca().getCor().equals(CorPeca.CLARA)) {
						this.dama = new Dama(this.grid[0][y].getPeca().getJogador(), CorPeca.CLARA, 0, y);

						this.dama.setDamaValida(true);

						grupoDePecas.getChildren().remove(this.grid[0][y].getPeca());

						this.grid[0][y].setPeca(this.dama);
						this.grid[0][y].setOcupada(true);

						this.grid[0][y].getPeca().move(y, 0);

						this.grid[0][y].setPeca(eventoOnMouse(this.grid[0][y].getPeca()));

						grupoDePecas.getChildren().add((this.grid[0][y].getPeca()));

					}
				}
			}
			if (this.grid[7][y].isOcupada()) {
				if (!verificaPeca(7, y)) {
					if (this.grid[7][y].getPeca().getCor().equals(CorPeca.ESCURA)) {
						this.dama = new Dama(this.grid[7][y].getPeca().getJogador(), CorPeca.ESCURA, 7, y);

						this.dama.setDamaValida(true);

						grupoDePecas.getChildren().remove(this.grid[7][y].getPeca());

						this.grid[7][y].setPeca(this.dama);
						this.grid[7][y].setOcupada(true);

						this.grid[7][y].getPeca().move(y, 7);

						this.grid[7][y].setPeca(eventoOnMouse(this.grid[7][y].getPeca()));
						grupoDePecas.getChildren().add((this.grid[7][y].getPeca()));
					}
				}
			}
		}
	}

	/* VERIFICA SE A PECA EH UMA DAMA */
	public boolean verificaPeca(int inicialX, int inicialY) {
		boolean ehDama = false;

		// AVALIA SE A PECA E DAMA OU PEDRA
		/*
		 * if (!this.grid[inicialX][inicialY].isOcupada()) { } else { if
		 * (this.grid[inicialX][inicialY].getDama() != null) { if
		 * (this.grid[inicialX][inicialY].getDama().isDamaValida()) { ehDama =
		 * true; } } }
		 */

		if (!this.grid[inicialX][inicialY].isOcupada()) {
		} else {
			if (this.grid[inicialX][inicialY].getPeca() instanceof Dama) {
				ehDama = true;
			}
		}

		return ehDama;
	}

	/* VERIFICA SE O MOVIMENTO DA DAMA PODE SER EFETUADO */
	public boolean avaliarMovimentoDama(int inicialX, int inicialY, int finalX, int finalY) {
		boolean movimentoValido = false;
		CorPeca corInicial;

		if (!this.grid[inicialX][inicialY].isOcupada()) {

		} else {
			if (this.numeroDeJogadas % 2 == 0) {
				corInicial = CorPeca.CLARA;
			} else {
				corInicial = CorPeca.ESCURA;
			}

			if (this.grid[inicialX][inicialY].getPeca().getCor().equals(corInicial)) {
				for (int x = 1; x < this.grid.length; x++) {
					if (inicialX < finalX) {
						if (inicialY < finalY) {
							if (inicialX + x < this.grid.length) {
								if (inicialY + x < this.grid.length) {
									if (!this.grid[inicialX + x][inicialY + x].isOcupada()) {
										if (this.grid[inicialX + x][inicialY + x] == this.grid[finalX][finalY]) {
											if (this.grid[inicialX + x][inicialY + x].isValida()) {
												if (!this.grid[finalX][finalY].isOcupada()) {
													movimentoValido = true;
												}
											}
										}
									} else if (this.grid[inicialX + x][inicialY + x].isOcupada()) {
										return false;
									}
								}
							}
						} else {
							if (inicialY - x >= 0) {
								if (inicialX + x < this.grid.length) {
									if (!this.grid[inicialX + x][inicialY - x].isOcupada()) {
										if (this.grid[inicialX + x][inicialY - x] == this.grid[finalX][finalY]) {
											if (this.grid[inicialX + x][inicialY - x].isValida()) {
												if (!this.grid[finalX][finalY].isOcupada()) {
													movimentoValido = true;
												}
											}
										}
									} else if (this.grid[inicialX + x][inicialY - x].isOcupada()) {
										return false;
									}
								}
							}

						}
					} else {
						if (inicialX - x >= 0) {
							if (inicialY < finalY) {
								if (inicialY + x < this.grid.length) {
									if (!this.grid[inicialX - x][inicialY + x].isOcupada()) {
										if (this.grid[inicialX - x][inicialY + x] == this.grid[finalX][finalY]) {
											if (this.grid[inicialX - x][inicialY + x].isValida()) {
												if (!this.grid[finalX][finalY].isOcupada()) {
													movimentoValido = true;
												}
											}
										}
									} else if (this.grid[inicialX - x][inicialY + x].isOcupada()) {
										return false;
									}
								}
							}
							if (inicialY - x >= 0) {
								if (!this.grid[inicialX - x][inicialY - x].isOcupada()) {
									if (this.grid[inicialX - x][inicialY - x] == this.grid[finalX][finalY]) {
										if (this.grid[inicialX - x][inicialY - x].isValida()) {
											if (!this.grid[finalX][finalY].isOcupada()) {
												movimentoValido = true;
											}
										}
									}
								} else if (this.grid[inicialX - x][inicialY - x].isOcupada()) {
									return false;
								}

							}
						}
					}
				}
			}
		}

		return movimentoValido;

	}

	/* VERIFICA SE O MOVIMENTO QUE O USUARIO ESCOLHEU PODE SER EFETUADO */
	public void executarMovimentoDama(int inicialX, int inicialY, int finalX, int finalY) {

		this.grid[finalX][finalY].setPeca(this.grid[inicialX][inicialY].getPeca());
		this.grid[finalX][finalY].setOcupada(true);

		this.grid[finalX][finalY].getPeca().move(finalY, finalX);

		this.grid[inicialX][inicialY].setOcupada(false);
		this.grid[inicialX][inicialY].setPeca(null);
	}

	/* VERIFICA SE EH POSSIVEL CAPTURAR COM A DAMA */
	public boolean avaliarCapturaDama(int inicialX, int inicialY, CorPeca corInicial)
			throws MovimentoInvalidoException {

		boolean captura = false;

		if (!this.grid[inicialX][inicialY].isOcupada()) {
			throw new MovimentoInvalidoException("Nao tem Peca na posicao inicial");
		} else {
			for (int x = 1; x < this.grid.length; x++) {
				if (inicialX + x + 1 < this.grid.length) {
					if (inicialY + x + 1 < this.grid.length) {
						if (this.grid[inicialX + x][inicialY + x].isOcupada()) {
							if (!this.grid[inicialX + x][inicialY + x].getPeca().getCor().equals(corInicial)) {
								if (!this.grid[inicialX + x + 1][inicialY + x + 1].isOcupada()) {

									this.capturaDama[0] = inicialX;
									this.capturaDama[1] = inicialY;
									this.capturaDama[2] = inicialX + x + 1;
									this.capturaDama[3] = inicialY + x + 1;

									return captura = true;

								} else if (this.grid[inicialX + x + 1][inicialY + x + 1].isOcupada()) {
									return captura;
								}
							}
						}
					}
					if (inicialY - x - 1 >= 0) {
						if (this.grid[inicialX + x][inicialY - x].isOcupada()) {
							if (!this.grid[inicialX + x][inicialY - x].getPeca().getCor().equals(corInicial)) {
								if (!this.grid[inicialX + x + 1][inicialY - x - 1].isOcupada()) {

									this.capturaDama[0] = inicialX;
									this.capturaDama[1] = inicialY;
									this.capturaDama[2] = inicialX + x + 1;
									this.capturaDama[3] = inicialY - x - 1;

									return captura = true;
								} else if (this.grid[inicialX + x + 1][inicialY - x - 1].isOcupada()) {
									return captura;
								}
							}
						}
					}
				}

				if (inicialX - x - 1 >= 0) {
					if (inicialY + x + 1 < this.grid.length) {
						if (this.grid[inicialX - x][inicialY + x].isOcupada()) {
							if (!this.grid[inicialX - x][inicialY + x].getPeca().getCor().equals(corInicial)) {
								if (!this.grid[inicialX - x - 1][inicialY + x + 1].isOcupada()) {

									this.capturaDama[0] = inicialX;
									this.capturaDama[1] = inicialY;
									this.capturaDama[2] = inicialX - x - 1;
									this.capturaDama[3] = inicialY + x + 1;

									return captura = true;
								} else if (this.grid[inicialX - x - 1][inicialY + x + 1].isOcupada()) {
									return captura;
								}
							}
						}
					}

					if (inicialY - x - 1 >= 0) {
						if (this.grid[inicialX - x][inicialY - x].isOcupada()) {
							if (!this.grid[inicialX - x][inicialY - x].getPeca().getCor().equals(corInicial)) {
								if (!this.grid[inicialX - x - 1][inicialY - x - 1].isOcupada()) {

									this.capturaDama[0] = inicialX;
									this.capturaDama[1] = inicialY;
									this.capturaDama[2] = inicialX - x - 1;
									this.capturaDama[3] = inicialY - x - 1;

									return captura = true;
								} else if (this.grid[inicialX - x - 1][inicialY - x - 1].isOcupada()) {
									return captura;
								}
							}
						}
					}
				}
			}

		}
		return captura;

	}

	/* VERIFICA SE A CAPTURA QUE O USUARIO ESCOLHEU PODE SER EFETUADA */
	public boolean capturarDaDama(int inicialX, int inicialY, int finalX, int finalY)
			throws MovimentoInvalidoException {
		boolean captura = false;
		CorPeca corInicial;

		if (!this.grid[inicialX][inicialY].isOcupada()) {
			throw new MovimentoInvalidoException("Nao tem Peca na posicao inicial");
		} else {

			if (this.numeroDeJogadas % 2 == 0)
				corInicial = CorPeca.CLARA;
			else
				corInicial = CorPeca.ESCURA;

			for (int x = 1; x < this.grid.length; x++) {
				if (inicialX < finalX) {
					if (inicialY < finalY) {
						if (inicialX + x < this.grid.length) {
							if (inicialY + x < this.grid.length) {
								if (this.grid[inicialX + x][inicialY + x].isOcupada()) {
									if (!this.grid[inicialX + x][inicialY + x].getPeca().getCor().equals(corInicial)) {
										for (int y = 1; y < this.grid.length; y++) {
											if (inicialX + x + y < this.grid.length
													&& inicialY + x + y < this.grid.length) {
												if (this.grid[inicialX + x + y][inicialY + x
														+ y] == this.grid[finalX][finalY]) {
													if (!this.grid[inicialX + x + y][inicialY + x + y].isOcupada()) {
														executaCaptura(inicialX, inicialY, inicialX + x, inicialY + x,
																finalX, finalY);
														return captura = true;
													} else {
														return captura = false;
													}
												} else {
													if (this.grid[inicialX + x + y][inicialY + x + y].isOcupada()) {
														return captura = false;
													}
												}
											}
										}
									}
								}
							}
						}
					} else {
						if (inicialX + x < this.grid.length && inicialY - x >= 0) {
							if (this.grid[inicialX + x][inicialY - x].isOcupada()) {
								if (!this.grid[inicialX + x][inicialY - x].getPeca().getCor().equals(corInicial)) {
									for (int y = 1; y < this.grid.length; y++) {
										if (inicialX + x + y < this.grid.length
												&& inicialY - x - y < this.grid.length) {
											if (this.grid[inicialX + x + y][inicialY - x
													- y] == this.grid[finalX][finalY]) {
												if (!this.grid[inicialX + x + y][inicialY - x - y].isOcupada()) {
													executaCaptura(inicialX, inicialY, inicialX + x, inicialY - x,
															finalX, finalY);
													return captura = true;
												}
											} else {
												if (this.grid[inicialX + x + y][inicialY + x + y].isOcupada()) {
													return captura = false;
												}
											}
										}
									}
								}
							}
						}
					}

				} else {
					if (inicialY < finalY) {
						if (inicialX - x >= 0 && inicialY + x < this.grid.length) {
							if (this.grid[inicialX - x][inicialY + x].isOcupada()) {
								if (!this.grid[inicialX - x][inicialY + x].getPeca().getCor().equals(corInicial)) {
									for (int y = 1; y < this.grid.length; y++) {
										if (inicialX - x - y >= 0 && inicialY + x + y < this.grid.length) {
											if (this.grid[inicialX - x - y][inicialY + x
													+ y] == this.grid[finalX][finalY]) {
												if (!this.grid[inicialX - x - y][inicialY + x + y].isOcupada()) {
													executaCaptura(inicialX, inicialY, inicialX - x, inicialY + x,
															finalX, finalY);
													return captura = true;
												}
											} else {
												if (this.grid[inicialX - x - y][inicialY + x + y].isOcupada()) {
													return captura = false;
												}
											}
										}
									}
								}
							}
						}
					} else {
						if (inicialX - x >= 0 && inicialY - x >= 0) {
							if (this.grid[inicialX - x][inicialY - x].isOcupada()) {
								if (!this.grid[inicialX - x][inicialY - x].getPeca().getCor().equals(corInicial)) {
									for (int y = 1; y < this.grid.length; y++) {
										if (inicialX - x - y >= 0 && inicialY - x - y < this.grid.length) {
											if (this.grid[inicialX - x - y][inicialY - x
													- y] == this.grid[finalX][finalY]) {
												if (!this.grid[inicialX - x - y][inicialY - x - y].isOcupada()) {
													executaCaptura(inicialX, inicialY, inicialX - x, inicialY - x,
															finalX, finalY);
													return captura = true;
												}
											} else {
												if (this.grid[inicialX - x - y][inicialY - x - y].isOcupada()) {
													return captura = false;
												}
											}
										}
									}
								}
							}
						}
					}

				}
			}
		}

		return captura;
	}

	public boolean avaliarCapturaComboDama(int inicialX, int inicialY) {
		boolean captura = false;
		CorPeca corInicial;

		if (this.numeroDeJogadas % 2 == 0) {
			corInicial = CorPeca.CLARA;
		} else {
			corInicial = CorPeca.ESCURA;
		}
		/*
		 * if (this.grid[inicialX][inicialY].isOcupada()) { for (int x = 1; x <
		 * this.grid.length; x++) { if (inicialX + x < this.grid.length) { if
		 * (inicialY + x < this.grid.length) { if (this.grid[inicialX +
		 * x][inicialY + x].isOcupada()) { if (!this.grid[inicialX + x][inicialY
		 * + x].getPeca().getCor().equals(corInicial)) { if (inicialX + x + 1 <
		 * this.grid.length) { if (!this.grid[inicialX + x + 1][inicialY + x +
		 * 1].isOcupada()) { return captura = true; } } } } } if (inicialY - x
		 * >= 0) { if (this.grid[inicialX + x][inicialY - x].isOcupada()) { if
		 * (!this.grid[inicialX + x][inicialY -
		 * x].getPeca().getCor().equals(corInicial)) { if (inicialX + x + 1 <
		 * this.grid.length) { if (inicialY - x - 1 >= 0) { if
		 * (!this.grid[inicialX + x + 1][inicialY - x - 1].isOcupada()) { return
		 * captura = true; } } } } } } }
		 * 
		 * if (inicialX - x - 1 >= 0) { if (inicialY + x + 1 < this.grid.length)
		 * { if (this.grid[inicialX - x][inicialY + x].isOcupada()) { if
		 * (!this.grid[inicialX - x][inicialY +
		 * x].getPeca().getCor().equals(corInicial)) { if (!this.grid[inicialX -
		 * x - 1][inicialY + x + 1].isOcupada()) { return captura = true; } } }
		 * }
		 * 
		 * if (inicialY - x - 1 >= 0) { if (this.grid[inicialX - x][inicialY -
		 * x].isOcupada()) { if (!this.grid[inicialX - x][inicialY -
		 * x].getPeca().getCor().equals(corInicial)) { if (!this.grid[inicialX -
		 * x - 1][inicialY - x - 1].isOcupada()) { return captura = true; } } }
		 * } } }
		 * 
		 * }
		 */

		for (int x = 1; x < this.grid.length; x++) {
			if (inicialX + x + 1 < this.grid.length) {
				if (inicialY + x + 1 < this.grid.length) {
					if (this.grid[inicialX + x][inicialY + x].isOcupada()) {
						if (!this.grid[inicialX + x][inicialY + x].getPeca().getCor().equals(corInicial)) {
							if (!this.grid[inicialX + x + 1][inicialY + x + 1].isOcupada()) {
								return captura = true;
							}
						}
					}
				}
				if (inicialY - x - 1 >= 0) {
					if (this.grid[inicialX + x][inicialY - x].isOcupada()) {
						if (!this.grid[inicialX + x][inicialY - x].getPeca().getCor().equals(corInicial)) {
							if (!this.grid[inicialX + x + 1][inicialY - x - 1].isOcupada()) {
								return captura = true;
							}
						}
					}
				}
			}

			if (inicialX - x - 1 >= 0) {
				if (inicialY + x + 1 < this.grid.length) {
					if (this.grid[inicialX - x][inicialY + x].isOcupada()) {
						if (!this.grid[inicialX - x][inicialY + x].getPeca().getCor().equals(corInicial)) {
							if (!this.grid[inicialX - x - 1][inicialY + x + 1].isOcupada()) {
								return captura = true;
							}
						}
					}
				}

				if (inicialY - x - 1 >= 0) {
					if (this.grid[inicialX - x][inicialY - x].isOcupada()) {
						if (!this.grid[inicialX - x][inicialY - x].getPeca().getCor().equals(corInicial)) {
							if (!this.grid[inicialX - x - 1][inicialY - x - 1].isOcupada()) {
								return captura = true;
							}
						}
					}
				}
			}
		}

		return captura;
	}

	public boolean jogar(int inicialX, int inicialY, int finalX, int finalY) throws MovimentoInvalidoException {
		boolean jogadaValida = false;
		boolean existeCapturaDama = false;
		boolean existeCapturaPeca = false;

		System.out.println("X0 = " + inicialX);
		System.out.println("Y0 = " + inicialY);
		System.out.println("X1 = " + finalX);
		System.out.println("Y1 = " + finalY);

		if (inicialX < 0 || inicialX > 7) {
			throw new MovimentoInvalidoException("inicialX = " + inicialX + " eh invalido!");
		} else if (inicialY < 0 || inicialY > 7) {
			throw new MovimentoInvalidoException("inicialY = " + inicialY + " eh invalido!");
		} else if (finalX < 0 || finalX > 7) {
			throw new MovimentoInvalidoException("finalX = " + finalX + "  eh invalido!");
		} else if (finalY < 0 || finalY > 7) {
			throw new MovimentoInvalidoException("finalY = " + finalY + "  eh invalido!");
		} else {

			boolean dama = verificaPeca(inicialX, inicialY);

			if (avaliarTabuleiroDama(this.numeroDeJogadas)) {
				existeCapturaDama = true;
			}

			if (avaliarTabuleiro(this.numeroDeJogadas)) {
				existeCapturaPeca = true;
			}

			if (existeCapturaPeca || existeCapturaDama) {
				if (dama && existeCapturaDama) {
					this.cont = 0;

					/* Captura da Dama */
					// capDama
					if (capturarDaDama(inicialX, inicialY, finalX, finalY)) {
						jogadaValida = true;
					} else {
						this.grid[inicialX][inicialY].getPeca().abortaMovimento();
					}

					if (jogadaValida == true) {
						if (avaliarCapturaComboDama(finalX, finalY)) {
							jogadaValida = false;
							this.cont = 0;
						}
					}

					/* A JOGADA FOI VALIDA ? */
					if (jogadaValida) {
						/* RESETA O NUMERO DE JOGADAS CONSECUTIVAS */
						this.contadorJogadas = 0;
						this.cont = 0;
					} else {
						this.cont++;
						if (this.cont % 2 != 0 && this.cont > 1) {
							System.out.println("\nOps! Já viu que pode capturar?\n");
						} else if (this.cont % 2 == 0 && this.cont > 1) {
							System.out.println("\nCaptura Invalida! Por favor, tente novamente!\n");
						}

					}
				}
				if (!dama) {
					this.cont = 0;

					if (capturarDaPeca(inicialX, inicialY, finalX, finalY)) {
						jogadaValida = true;

					} else {
						this.grid[inicialX][inicialY].getPeca().abortaMovimento();
					}

					if (jogadaValida == true) {
						if (avaliarCapturaCombo(finalX, finalY)) {
							jogadaValida = false;
							this.cont = 0;
						}
					}

					/* A JOGADA FOI VALIDA ? */
					if (jogadaValida) {
						/* RESETA O NUMERO DE JOGADAS CONSECUTIVAS */
						this.contadorJogadas = 0;
						this.cont = 0;
					} else {
						this.cont++;
						if (this.cont % 2 != 0 && this.cont > 1) {
							System.out.println("\nOps! Já viu que pode capturar?\n");
						} else if (this.cont % 2 == 0 && this.cont > 1) {
							System.out.println("\nCaptura Invalida! Por favor, tente novamente!\n");
						}

					}
				}
			} else {
				if (dama) {
					/* Movimento da Dama */
					try {
						if (avaliarMovimentoDama(inicialX, inicialY, finalX, finalY)) {

							executarMovimentoPeca(inicialX, inicialY, finalX, finalY);

							jogadaValida = true;

							/* AUMENTA O NUMERO DE JOGADAS CONSECUTIVAS */
							this.contadorJogadas++;
						} else {
							this.grid[inicialX][inicialY].getPeca().abortaMovimento();
						}

						if (jogadaValida == false) {
							System.out.println("\n\nMovimento da Dama Invalido!");
						}

					} catch (MovimentoInvalidoException e) {
						System.out.println("");
					}
				} else {
					/* MOVIMENTO DA PECA NORMAL */
					if (tratarMovimentoPecaNormal(inicialX, inicialY, finalX, finalY)) {

						/* Executa movimento normal */
						executarMovimentoPeca(inicialX, inicialY, finalX, finalY);

						jogadaValida = true;

						/* RESETA O NUMERO DE JOGADAS CONSECUTIVAS */
						this.contadorJogadas = 0;

					} else {
						System.out.println("\nMovimento Invalido!\n");
					}
				}
			}
		}
		return jogadaValida;
	}

	public boolean tratarMovimentoPecaNormal(int inicialX, int inicialY, int finalX, int finalY) {
		boolean mov = false;
		try {
			if (avaliarMovimento(inicialX, inicialY, finalX, finalY)) {
				mov = true;
			} else {
				this.grid[inicialX][inicialY].getPeca().abortaMovimento();
			}
		} catch (MovimentoInvalidoException e) {

		}
		return mov;
	}

}
