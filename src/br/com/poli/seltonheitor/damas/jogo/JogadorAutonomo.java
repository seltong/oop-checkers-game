package br.com.poli.seltonheitor.damas.jogo;

import br.com.poli.seltonheitor.damas.enums.CorPeca;
import br.com.poli.seltonheitor.damas.excecoes.MovimentoInvalidoException;
import br.com.poli.seltonheitor.damas.jogador.Jogador;

public class JogadorAutonomo extends Jogador implements AutoPlayer {

	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;

	private Jogo jogo;
	private Dama dama;
	private Casa[][] tabuleiro1;

	public JogadorAutonomo(String nome) {
		super(nome);
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	private void capturasClara(boolean jogadaValida, boolean existeCapturaDama, boolean existeCapturaPeca,
			int[] pecaInicial, int finalX, int finalY) {

		if (existeCapturaDama) {
			pecaInicial[0] = this.jogo.getTabuleiro().getCapturaDama()[0];
			pecaInicial[1] = this.jogo.getTabuleiro().getCapturaDama()[1];
			finalX = this.jogo.getTabuleiro().getCapturaDama()[2];
			finalY = this.jogo.getTabuleiro().getCapturaDama()[3];

			try {
				if (this.jogo.getTabuleiro().jogar(pecaInicial[0], pecaInicial[1], finalX, finalY)) {
					jogadaValida = true;
					this.jogo.getTabuleiro().setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() + 1);
				} else {
					pecaInicial[0] = this.jogo.getTabuleiro().getCapturaPeca()[0];
					pecaInicial[1] = this.jogo.getTabuleiro().getCapturaPeca()[1];
					finalX = this.jogo.getTabuleiro().getCapturaPeca()[2];
					finalY = this.jogo.getTabuleiro().getCapturaPeca()[3];

					if (this.jogo.getTabuleiro().jogar(pecaInicial[0], pecaInicial[1], finalX, finalY)) {
						jogadaValida = true;
						this.jogo.getTabuleiro().setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() + 1);
					}
				}
			} catch (MovimentoInvalidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (existeCapturaPeca) {
			System.out.println("Captura!!");

			pecaInicial[0] = this.jogo.getTabuleiro().getCapturaPeca()[0];
			pecaInicial[1] = this.jogo.getTabuleiro().getCapturaPeca()[1];
			finalX = this.jogo.getTabuleiro().getCapturaPeca()[2];
			finalY = this.jogo.getTabuleiro().getCapturaPeca()[3];

			try {
				if (this.jogo.getTabuleiro().jogar(pecaInicial[0], pecaInicial[1], finalX, finalY)) {
					jogadaValida = true;
					this.jogo.getTabuleiro().setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() + 1);
				} else {
					pecaInicial[0] = this.jogo.getTabuleiro().getCapturaPeca()[0];
					pecaInicial[1] = this.jogo.getTabuleiro().getCapturaPeca()[1];
					finalX = this.jogo.getTabuleiro().getCapturaPeca()[2];
					finalY = this.jogo.getTabuleiro().getCapturaPeca()[3];

					if (this.jogo.getTabuleiro().jogar(pecaInicial[0], pecaInicial[1], finalX, finalY)) {
						jogadaValida = true;
						this.jogo.getTabuleiro().setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() + 1);
					}
				}
			} catch (MovimentoInvalidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void capturasEscura(boolean jogadaValida, boolean existeCapturaDama, boolean existeCapturaPeca,
			int[] pecaInicial, int finalX, int finalY) {

		if (existeCapturaDama) {
			pecaInicial[0] = this.jogo.getTabuleiro().getCapturaDama()[0];
			pecaInicial[1] = this.jogo.getTabuleiro().getCapturaDama()[1];
			finalX = this.jogo.getTabuleiro().getCapturaDama()[2];
			finalY = this.jogo.getTabuleiro().getCapturaDama()[3];

			try {
				if (this.jogo.getTabuleiro().jogar(pecaInicial[0], pecaInicial[1], finalX, finalY)) {
					jogadaValida = true;
					this.jogo.getTabuleiro().setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() + 1);
				} else {
					pecaInicial[0] = this.jogo.getTabuleiro().getCapturaPeca()[0];
					pecaInicial[1] = this.jogo.getTabuleiro().getCapturaPeca()[1];
					finalX = this.jogo.getTabuleiro().getCapturaPeca()[2];
					finalY = this.jogo.getTabuleiro().getCapturaPeca()[3];

					if (this.jogo.getTabuleiro().jogar(pecaInicial[0], pecaInicial[1], finalX, finalY)) {
						jogadaValida = true;
						this.jogo.getTabuleiro().setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() + 1);
					}
				}
			} catch (MovimentoInvalidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (existeCapturaPeca) {
			pecaInicial[0] = this.jogo.getTabuleiro().getCapturaPeca()[0];
			pecaInicial[1] = this.jogo.getTabuleiro().getCapturaPeca()[1];
			finalX = this.jogo.getTabuleiro().getCapturaPeca()[2];
			finalY = this.jogo.getTabuleiro().getCapturaPeca()[3];

			try {
				if (this.jogo.getTabuleiro().jogar(pecaInicial[0], pecaInicial[1], finalX, finalY)) {
					jogadaValida = true;
					this.jogo.getTabuleiro().setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() + 1);
				} else {
					pecaInicial[0] = this.jogo.getTabuleiro().getCapturaPeca()[0];
					pecaInicial[1] = this.jogo.getTabuleiro().getCapturaPeca()[1];
					finalX = this.jogo.getTabuleiro().getCapturaPeca()[2];
					finalY = this.jogo.getTabuleiro().getCapturaPeca()[3];

					if (this.jogo.getTabuleiro().jogar(pecaInicial[0], pecaInicial[1], finalX, finalY)) {
						jogadaValida = true;
						this.jogo.getTabuleiro().setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() + 1);
					}
				}
			} catch (MovimentoInvalidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void movimentosEscura(boolean jogadaValida, boolean existeCapturaDama, boolean existeCapturaPeca,
			int[] pecaInicial, int finalX, int finalY, int numeroDeJogadas) {
		pecaInicial = procuraPeca(numeroDeJogadas);

		finalX = 1;

		if (pecaInicial[1] == 0) {
			finalY = 1;
		} else if (pecaInicial[1] == 7) {
			finalY = -1;
		} else {
			finalY = (int) Math.random();
			if (finalY < 0.5)
				finalY = -1;
			else
				finalY = 1;
		}

		try {
			if (this.jogo.getTabuleiro().jogar(pecaInicial[0], pecaInicial[1], pecaInicial[0] + finalX,
					pecaInicial[1] + finalY)) {
				jogadaValida = true;
				this.jogo.getTabuleiro().setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() + 1);
			} else {
				try {
					if (this.jogo.getTabuleiro().jogar(pecaInicial[0], pecaInicial[1], pecaInicial[0] + finalX,
							pecaInicial[1] - finalY)) {
						jogadaValida = true;
						this.jogo.getTabuleiro().setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() + 1);
					}
				} catch (MovimentoInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (MovimentoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void movimentosClara(boolean jogadaValida, boolean existeCapturaDama, boolean existeCapturaPeca,
			int[] pecaInicial, int finalX, int finalY, int numeroDeJogadas) {
		pecaInicial = procuraPeca(this.jogo.getTabuleiro().getNumeroDeJogadas());

		finalX = 1;
		finalY = 0;

		if (pecaInicial[1] == 0) {
			finalY = 1;
		} else if (pecaInicial[1] == 7) {
			finalY = -1;
		} else {
			finalY = (int) Math.random();
			if (finalY < 0.5)
				finalY = -1;
			else
				finalY = 1;
		}

		try {
			if (this.jogo.getTabuleiro().jogar(pecaInicial[0], pecaInicial[1], pecaInicial[0] - finalX,
					pecaInicial[1] + finalY)) {
				jogadaValida = true;
				this.jogo.getTabuleiro().setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() + 1);
			} else {
				try {
					if (this.jogo.getTabuleiro().jogar(pecaInicial[0], pecaInicial[1], pecaInicial[0] - finalX,
							pecaInicial[1] - finalY)) {
						jogadaValida = true;
						this.jogo.getTabuleiro().setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() + 1);
					}
				} catch (MovimentoInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (MovimentoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean jogarAuto(Jogo jogo) {
		// TODO Auto-generated method stub
		boolean jogadaValida = false, existeCapturaDama = false, existeCapturaPeca = false;
		int pecaInicial[] = new int[2], finalX = 0, finalY = 0, numeroDeJogadas;

		this.jogo = jogo;

		this.jogo.getTabuleiro().criarDamas();

		numeroDeJogadas = this.jogo.getTabuleiro().getNumeroDeJogadas();

		if (numeroDeJogadas % 2 == 0) {
			if (this.jogo.getJogador1() instanceof JogadorAutonomo) {
				if (this.jogo.getTabuleiro().avaliarTabuleiroDama(numeroDeJogadas)) {
					existeCapturaDama = true;
				}

				if (this.jogo.getTabuleiro().avaliarTabuleiro(numeroDeJogadas)) {
					existeCapturaPeca = true;
				}

				if (existeCapturaPeca || existeCapturaDama) {
					capturasClara(jogadaValida, existeCapturaDama, existeCapturaPeca, pecaInicial, finalX, finalY);

				} else {
					movimentosClara(jogadaValida, existeCapturaDama, existeCapturaPeca, pecaInicial, finalX, finalY,
							numeroDeJogadas);
				}
			}

		} else {
			if (this.jogo.getJogador2() instanceof JogadorAutonomo) {
				if (this.jogo.getTabuleiro().avaliarTabuleiroDama(numeroDeJogadas)) {
					existeCapturaDama = true;
				}

				if (this.jogo.getTabuleiro().avaliarTabuleiro(numeroDeJogadas)) {
					existeCapturaPeca = true;
				}

				if (existeCapturaPeca || existeCapturaDama) {
					capturasEscura(jogadaValida, existeCapturaDama, existeCapturaPeca, pecaInicial, finalX, finalY);

				} else {
					movimentosEscura(jogadaValida, existeCapturaDama, existeCapturaPeca, pecaInicial, finalX, finalY,
							numeroDeJogadas);
				}
			}
		}

		return jogadaValida;
	}

	@Override
	public Jogador vencedor() {
		// TODO Auto-generated method stub
		return null;
	}

	private int[] procuraPeca(int jogadas) {
		int saida[] = new int[2];
		CorPeca cor;

		if (jogadas % 2 == 0) {
			cor = CorPeca.CLARA;
		} else {
			cor = CorPeca.ESCURA;
		}

		for (int x = 0; x < this.jogo.getTabuleiro().getGrid().length; x++) {
			for (int y = 0; y < this.jogo.getTabuleiro().getGrid().length; y++) {
				if (this.jogo.getTabuleiro().getGrid()[x][y].isOcupada()) {
					if (this.jogo.getTabuleiro().getGrid()[x][y].getPeca().getCor().equals(cor)) {
						try {
							if (avaliarMovimento(x, y, cor)) {
								saida[0] = x;
								saida[1] = y;

								return saida;
							}
						} catch (MovimentoInvalidoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}

		return saida;
	}

	public boolean avaliarMovimento(int inicialX, int inicialY, CorPeca cor) throws MovimentoInvalidoException {
		boolean movimentoValido = false;

		if (!this.jogo.getTabuleiro().getGrid()[inicialX][inicialY].isOcupada()) {

		} else {
			if (this.jogo.getTabuleiro().getNumeroDeJogadas() % 2 != 0 && CorPeca.ESCURA.equals(cor)) {
				if (this.jogo.getTabuleiro().getGrid()[inicialX][inicialY].getPeca().getCor().equals(cor)) {
					if (inicialX + 1 < this.jogo.getTabuleiro().getGrid().length) {
						if (inicialY + 1 < this.jogo.getTabuleiro().getGrid().length) {
							if (!this.jogo.getTabuleiro().getGrid()[inicialX + 1][inicialY + 1].isOcupada()) {
								return movimentoValido = true;
							}
						}
						if (inicialY - 1 >= 0) {
							if (!this.jogo.getTabuleiro().getGrid()[inicialX + 1][inicialY - 1].isOcupada()) {
								return movimentoValido = true;
							}
						}
					}
				}
			} else if (this.jogo.getTabuleiro().getNumeroDeJogadas() % 2 == 0 && CorPeca.CLARA.equals(cor)) {
				if (inicialX - 1 >= 0) {
					if (inicialY + 1 < this.jogo.getTabuleiro().getGrid().length) {
						if (!this.jogo.getTabuleiro().getGrid()[inicialX - 1][inicialY + 1].isOcupada()) {
							return movimentoValido = true;
						}
					}
					if (inicialY - 1 >= 0) {
						if (!this.jogo.getTabuleiro().getGrid()[inicialX - 1][inicialY - 1].isOcupada()) {
							return movimentoValido = true;
						}
					}
				}
			}
		}
		return movimentoValido;

	}

	public void avaliaMelhorJogada(int contadorJogadas) {
		CorPeca cor;

		if (contadorJogadas % 2 == 0)
			cor = CorPeca.CLARA;
		else
			cor = CorPeca.ESCURA;

		for (int x = 0; x < this.jogo.getTabuleiro().getGrid().length; x++) {
			for (int y = 0; y < this.jogo.getTabuleiro().getGrid().length; y++) {
				if (this.tabuleiro1[x][y].isOcupada()) {
					if (this.tabuleiro1[x][y].getPeca().getCor().equals(cor)) {
						// this.tabuleiro1[x][y].
					}
				}
			}
		}
	}

	/* Avalia se ainda ha movimentos possiveis */
	public boolean imobilizacaoPecas(int numeroDeJogadas) {
		boolean imobilizado = false;
		CorPeca cor;

		this.jogo.getTabuleiro().setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() + 1);

		if (numeroDeJogadas % 2 != 0) {
			cor = CorPeca.CLARA;

			if (this.jogo.getTabuleiro().getQuantidadePecasEscuras() == 1) {
				for (int i = 0; i < WIDTH; i++) {
					for (int j = 0; j < HEIGHT; j++) {
						if (!this.jogo.getTabuleiro().getGrid()[i][j].getPeca().equals(null)) {
							if (!this.jogo.getTabuleiro().getGrid()[i][j].getPeca().getCor().equals(cor)) {
								try {
									if (i - 1 >= 0 && j + 1 < WIDTH) {
										imobilizado = !this.jogo.getTabuleiro().avaliarMovimento(i, j, i - 1, j + 1);

										if (imobilizado) {
											if (i - 1 >= 0 && j - 1 >= 0) {
												imobilizado = !this.jogo.getTabuleiro().avaliarMovimento(i, j, i - 1,
														j - 1);
												if (imobilizado) {
													this.jogo.getTabuleiro()
															.setVencedor(this.jogo.getTabuleiro().getJogador1());
												}
												return imobilizado;
											}
										}

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

			if (this.jogo.getTabuleiro().getQuantidadePecasClaras() == 1) {
				for (int i = 0; i < WIDTH; i++) {
					for (int j = 0; j < HEIGHT; j++) {
						if (!this.jogo.getTabuleiro().getGrid()[i][j].getPeca().equals(null)) {
							if (!this.jogo.getTabuleiro().getGrid()[i][j].getCor().equals(cor)) {
								try {
									if (i - 1 >= 0 && j + 1 < WIDTH) {
										imobilizado = !this.jogo.getTabuleiro().avaliarMovimento(i, j, i - 1, j + 1);

										if (imobilizado) {
											if (j - 1 >= 0) {
												imobilizado = !this.jogo.getTabuleiro().avaliarMovimento(i, j, i - 1,
														j - 1);
												if (imobilizado) {
													this.jogo.getTabuleiro()
															.setVencedor(this.jogo.getTabuleiro().getJogador2());
												}
												return imobilizado;
											}
										}

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

		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				if (!this.jogo.getTabuleiro().getGrid()[x][y].equals(null)) {
					if (this.jogo.getTabuleiro().getGrid()[x][y].getCor().equals(cor)) {
						if (cor.equals(CorPeca.ESCURA)) {
							if (x + 1 < HEIGHT) {
								// Verifica se ha movimento com a peca normal
								try {
									if (y + 1 < WIDTH) {
										// Avalia movimento com a Peca
										imobilizado = (!this.jogo.getTabuleiro().avaliarMovimento(x, y, x + 1, y + 1));
									}
								} catch (MovimentoInvalidoException e) {
									System.out.println("imobilizacao - movimento invalido!");
								}

								if (imobilizado == false) {
									this.jogo.getTabuleiro()
											.setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() - 1);
									return imobilizado;
								}

								try {
									if (y - 1 >= 0) {
										// Avalia movimento com a Peca
										imobilizado = (!this.jogo.getTabuleiro().avaliarMovimento(x, y, x + 1, y - 1));
									}
								} catch (MovimentoInvalidoException e) {
									System.err.println("imobilizacao - movimento invalido!");
								}

								if (imobilizado == false) {
									this.jogo.getTabuleiro()
											.setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() - 1);
									return imobilizado;
								}
							}
						} else {
							if (x - 1 > 0) {
								try {
									if (y + 1 < WIDTH) {
										// Avalia movimento com a Peca
										imobilizado = (!this.jogo.getTabuleiro().avaliarMovimento(x, y, x - 1, y + 1));
									}
								} catch (MovimentoInvalidoException e) {
									System.err.println("imobilizacao - movimento invalido!");
								}

								if (imobilizado == false) {
									this.jogo.getTabuleiro()
											.setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() - 1);
									return imobilizado;
								}

								try {
									if (y - 1 >= 0) {
										// Avalia movimento com a Peca
										imobilizado = (!this.jogo.getTabuleiro().avaliarMovimento(x, y, x - 1, y - 1));
									}
								} catch (MovimentoInvalidoException e) {
									System.out.println("imobilizacao - movimento invalido!");
								}

								if (imobilizado == false) {
									this.jogo.getTabuleiro()
											.setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() - 1);
									return imobilizado;
								}
							}
						}
					}
				}
			}
		}

		this.jogo.getTabuleiro().setNumeroDeJogadas(this.jogo.getTabuleiro().getNumeroDeJogadas() - 1);

		return imobilizado;
	}

	/* VERIFICA SE A PECA EH UMA DAMA */
	public boolean verificaPeca(int inicialX, int inicialY) {
		boolean ehDama = false;
		if (!this.jogo.getTabuleiro().getGrid()[inicialX][inicialY].isOcupada()) {
		} else {
			if (this.jogo.getTabuleiro().getGrid()[inicialX][inicialY].getPeca() instanceof Dama) {
				ehDama = true;
			}
		}

		return ehDama;
	}

}
