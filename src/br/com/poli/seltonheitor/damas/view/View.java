package br.com.poli.seltonheitor.damas.view;

import static br.com.poli.seltonheitor.damas.jogo.Tabuleiro.TAMANHO;

import java.util.Calendar;

import javax.swing.JOptionPane;

import br.com.poli.seltonheitor.damas.enums.Resultado;
import br.com.poli.seltonheitor.damas.jogo.JogadorAutonomo;
import br.com.poli.seltonheitor.damas.jogo.Jogo;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class View extends Application {

	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;
	public final int ESQUERDA_NOME = 50;
	public final int LARGURA_TELA = 600;
	public final int ALTURA_TELA = 500;

	private String nomeJogador1 = "";
	private String nomeJogador2 = "";
	private Jogo jogo;
	private JogadorAutonomo jogadorAuto = null;
	private int minutos = 0;
	private int segundos = 0;
	private int horas = 0;

	public Label lblTempo = new Label("Tempo da Partida: 00:00:00");
	public Button btnPlay = new Button("Play");

	public View() {

	}

	private Pane escolhaDePecas() {
		this.jogo = new Jogo();

		Group rdbCor = new Group();

		Pane tela = new Pane();
		Pane DadosJogador1 = new Pane();
		Pane DadosJogador2 = new Pane();

		Button btnConfirmar1 = new Button();
		Button btnConfirmar2 = new Button();

		TextField txtNome = new TextField();
		TextField txtNome2 = new TextField();

		DadosJogador1.getChildren().add(txtNome);
		DadosJogador1.getChildren().add(btnConfirmar1);

		DadosJogador2.getChildren().add(txtNome2);
		DadosJogador2.getChildren().add(btnConfirmar2);

		DadosJogador1.setVisible(false);
		DadosJogador2.setVisible(false);

		btnConfirmar1.setText("Confirmar");
		btnConfirmar1.relocate(115, 280);

		btnConfirmar2.setText("Confirmar");
		btnConfirmar2.relocate(115, 280);
		btnConfirmar2.setId("btnConf2");

		btnPlay.setText("Play");
		btnPlay.relocate(280, 400);
		btnPlay.setVisible(false);

		txtNome.setText("Digite seu nome");
		txtNome.relocate(ESQUERDA_NOME, 130);
		txtNome.setStyle("-fx-font-size: 16px;");
		txtNome.autosize();

		txtNome2.setText("Digite seu nome");
		txtNome2.relocate(ESQUERDA_NOME, 130);
		txtNome2.setStyle("-fx-font-size: 16px;");
		txtNome2.autosize();

		RadioButton rdbBranco = new RadioButton();
		rdbBranco.relocate(140, 450);

		RadioButton rdbPreto = new RadioButton();
		rdbPreto.relocate(140, 450);

		rdbCor.getChildren().add(rdbBranco);
		rdbCor.getChildren().add(rdbPreto);

		Pane branco = new Pane();
		branco.setStyle("-fx-background-color: white;");
		branco.relocate(0, 0);
		branco.setPrefSize(300, 500);
		branco.getChildren().add(rdbBranco);
		branco.getChildren().add(DadosJogador1);

		Pane preto = new Pane();
		preto.setStyle("-fx-background-color: black;");
		preto.relocate(300, 0);
		preto.setPrefSize(300, 500);
		preto.getChildren().add(rdbPreto);
		preto.getChildren().add(DadosJogador2);

		tela.getChildren().add(branco);
		tela.getChildren().add(preto);
		tela.getChildren().add(btnPlay);

		txtNome.setOnMouseClicked(e5 -> {
			txtNome.clear();
		});

		txtNome2.setOnMouseClicked(e4 -> {
			txtNome2.clear();
		});

		btnConfirmar1.setOnAction(e -> {
			this.nomeJogador1 = txtNome.getText();
			System.out.println(this.nomeJogador1);
			rdbBranco.setDisable(true);
			txtNome.setDisable(true);
			btnConfirmar1.setDisable(true);
			if (btnConfirmar1.isDisabled() && btnConfirmar2.isDisabled()) {
				btnPlay.setVisible(true);
			}
		});

		btnConfirmar2.setOnAction(e -> {
			this.nomeJogador2 = txtNome2.getText();
			System.out.println(this.nomeJogador2);
			rdbPreto.setDisable(true);
			txtNome2.setDisable(true);
			btnConfirmar2.setDisable(true);
			if (btnConfirmar1.isDisabled() && btnConfirmar2.isDisabled()) {
				btnPlay.setVisible(true);
			}
		});

		rdbBranco.setOnAction(e2 -> {
			if (rdbBranco.isSelected() && this.nomeJogador1 == "") {
				if (this.nomeJogador2 == "") {
					rdbPreto.setSelected(false);
					DadosJogador2.setVisible(false);
					txtNome2.setText("Digite seu nome");
				}
				DadosJogador1.setVisible(true);

			} else {
				DadosJogador1.setVisible(false);
			}
		});

		rdbPreto.setOnAction(e3 -> {
			if (rdbPreto.isSelected() && this.nomeJogador2 == "") {
				if (this.nomeJogador1 == "") {
					rdbBranco.setSelected(false);
					DadosJogador1.setVisible(false);
					txtNome.setText("Digite seu nome");
				}
				DadosJogador2.setVisible(true);

			} else {
				DadosJogador2.setVisible(false);
			}
		});

		return tela;
	}

	private Pane escolhaDePecas(int a) {
		this.jogo = new Jogo();

		Group rdbCor = new Group();

		Pane tela = new Pane();
		Pane DadosJogador1 = new Pane();
		Pane DadosJogador2 = new Pane();

		Button btnConfirmar1 = new Button();
		Button btnConfirmar2 = new Button();

		TextField txtNome = new TextField();
		TextField txtNome2 = new TextField();

		DadosJogador1.getChildren().add(txtNome);
		DadosJogador1.getChildren().add(btnConfirmar1);

		DadosJogador2.getChildren().add(txtNome2);
		DadosJogador2.getChildren().add(btnConfirmar2);

		DadosJogador1.setVisible(false);
		DadosJogador2.setVisible(false);

		btnConfirmar1.setText("Confirmar");
		btnConfirmar1.relocate(115, 280);

		btnConfirmar2.setText("Confirmar");
		btnConfirmar2.relocate(115, 280);
		btnConfirmar2.setId("btnConf2");

		btnPlay.setText("Play");
		btnPlay.relocate(280, 400);
		btnPlay.setVisible(false);

		txtNome.setText("Digite seu nome");
		txtNome.relocate(ESQUERDA_NOME, 130);
		txtNome.setStyle("-fx-font-size: 16px;");
		txtNome.autosize();

		txtNome2.setText("Digite seu nome");
		txtNome2.relocate(ESQUERDA_NOME, 130);
		txtNome2.setStyle("-fx-font-size: 16px;");
		txtNome2.autosize();

		RadioButton rdbBranco = new RadioButton();
		rdbBranco.relocate(140, 450);

		RadioButton rdbPreto = new RadioButton();
		rdbPreto.relocate(140, 450);

		rdbCor.getChildren().add(rdbBranco);
		rdbCor.getChildren().add(rdbPreto);

		Pane branco = new Pane();
		branco.setStyle("-fx-background-color: white;");
		branco.relocate(0, 0);
		branco.setPrefSize(300, 500);
		branco.getChildren().add(rdbBranco);
		branco.getChildren().add(DadosJogador1);

		Pane preto = new Pane();
		preto.setStyle("-fx-background-color: black;");
		preto.relocate(300, 0);
		preto.setPrefSize(300, 500);
		preto.getChildren().add(rdbPreto);
		preto.getChildren().add(DadosJogador2);

		tela.getChildren().add(branco);
		tela.getChildren().add(preto);
		tela.getChildren().add(btnPlay);

		txtNome.setOnMouseClicked(e5 -> {
			txtNome.clear();
		});

		txtNome2.setOnMouseClicked(e4 -> {
			txtNome2.clear();
		});

		btnConfirmar1.setOnAction(e -> {
			this.nomeJogador1 = txtNome.getText();
			this.nomeJogador2 = "Computador";

			System.out.println("Nome Jogador 1: " + this.nomeJogador1 + "\nNome Jogador 2: " + this.nomeJogador2);

			rdbBranco.setDisable(true);
			rdbPreto.setDisable(true);
			txtNome.setDisable(true);
			btnConfirmar1.setDisable(true);

			btnPlay.setVisible(true);
		});

		btnConfirmar2.setOnAction(e -> {
			this.nomeJogador2 = txtNome2.getText();
			this.nomeJogador1 = "Computador";

			System.out.println("Nome Jogador 1: " + this.nomeJogador1 + "\nNome Jogador 2: " + this.nomeJogador2);

			rdbPreto.setDisable(true);
			txtNome2.setDisable(true);
			btnConfirmar2.setDisable(true);

			btnPlay.setVisible(true);

		});

		rdbBranco.setOnAction(e2 -> {
			if (rdbBranco.isSelected() && this.nomeJogador1 == "") {
				if (this.nomeJogador2 == "") {
					rdbPreto.setSelected(false);
					DadosJogador2.setVisible(false);
					txtNome2.setText("Digite seu nome");
					btnPlay.setVisible(false);
				}
				DadosJogador1.setVisible(true);

			} else {
				DadosJogador1.setVisible(false);
			}
		});

		rdbPreto.setOnAction(e3 -> {
			if (rdbPreto.isSelected() && this.nomeJogador2 == "") {
				if (this.nomeJogador1 == "") {
					rdbBranco.setSelected(false);
					DadosJogador1.setVisible(false);
					txtNome.setText("Digite seu nome");
					btnPlay.setVisible(false);
				}
				DadosJogador2.setVisible(true);

			} else {
				DadosJogador2.setVisible(false);
			}
		});

		return tela;
	}

	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(WIDTH * TAMANHO, HEIGHT * TAMANHO);
		root.getChildren().addAll(this.jogo.getTabuleiro().getGrupoDeCasas(),
				this.jogo.getTabuleiro().getGrupoDePecas());

		return root;
	}

	private Pane jogo() {
		this.jogo.iniciarPartida(this.nomeJogador1, this.nomeJogador2);

		Pane jogo = new Pane();
		Pane geral = new Pane();
		Pane paneJogador1 = new Pane();
		Pane paneJogador2 = new Pane();
		Pane paneInfoJogo = new Pane();
		Pane dadosDoJogo = new Pane();

		Button desistirJogador1 = new Button("Desistir");
		Button desistirJogador2 = new Button("Desistir");

		Label lblVez1 = new Label("Sua vez!");
		Label lblVez2 = new Label("Sua vez!");
		Label lblJogador1 = new Label(this.jogo.getTabuleiro().getJogador1().getNome());
		Label lblJogador2 = new Label(this.jogo.getTabuleiro().getJogador2().getNome());
		Label lblQtdPecasClaras = new Label("Quantidade de Pecas: " + 12);
		Label lblQtdPecasEscuras = new Label("Quantidade de Pecas: " + 12);
		Label lblInfo = new Label("Informações do Jogo");

		Label lblNumeroDeJogadas = new Label("Numero de jogadas: " + 0);
		Label lblQtdTurSemCap = new Label("Quantidade de Turnos\nsem Captura: " + 0);

		geral.setMinWidth(900);

		jogo.setPrefSize(883, 642);
		jogo.setStyle("-fx-background-color: white; -fx-border-width:  2 2 2 2; -fx-border-style: solid;");

		paneJogador1.relocate(0, 470);
		paneJogador1.setPrefSize(241, 170);
		paneJogador1.setStyle("-fx-background-color: white; -fx-border-width:  2 0 0 2; -fx-border-style: solid;");

		paneJogador2.relocate(0, 0);
		paneJogador2.setPrefSize(241, 170);
		paneJogador2.setStyle("-fx-background-color: black; -fx-border-width:  2 0 0 2; -fx-border-style: solid;");

		paneInfoJogo.relocate(0, 170);
		paneInfoJogo.setPrefSize(241, 300);
		paneInfoJogo.setStyle("-fx-background-color: #f3f3f3; -fx-border-width: 2 0 0 2 ; -fx-border-style: solid;");

		dadosDoJogo.relocate(640, 0);
		dadosDoJogo.setPrefSize(200, 640);
		dadosDoJogo.setStyle("-fx-background-color: white;");

		lblJogador1.setFont(javafx.scene.text.Font.font("Arial", 18));
		lblJogador1.setStyle("-fx-font-weight: bold;");
		lblJogador1.relocate(30, 30);

		lblVez1.relocate(20, 130);
		lblVez1.setFont(javafx.scene.text.Font.font("Arial", 16));
		lblVez1.setStyle(" -fx-font-weight: bold;");

		desistirJogador1.setVisible(true);
		desistirJogador1.relocate(140, 130);
		desistirJogador1.setFont(javafx.scene.text.Font.font("Arial", 14));

		lblQtdPecasEscuras.setFont(javafx.scene.text.Font.font("Arial", 16));
		lblQtdPecasEscuras.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
		lblQtdPecasEscuras.relocate(20, 90);

		lblJogador2.setFont(javafx.scene.text.Font.font("Arial", 18));
		lblJogador2.relocate(30, 30);
		lblJogador2.setVisible(true);
		lblJogador2.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");

		lblVez2.relocate(20, 130);
		lblVez2.setVisible(false);
		lblVez2.setFont(javafx.scene.text.Font.font("Arial", 16));
		lblVez2.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");

		desistirJogador2.setVisible(false);
		desistirJogador2.relocate(140, 130);
		desistirJogador2.setFont(javafx.scene.text.Font.font("Arial", 14));

		lblQtdPecasClaras.setFont(javafx.scene.text.Font.font("Arial", 16));
		lblQtdPecasClaras.setStyle("-fx-font-weight: bold;");
		lblQtdPecasClaras.relocate(20, 90);

		lblInfo.setFont(javafx.scene.text.Font.font("Arial", 18));
		lblInfo.setStyle("-fx-font-weight: bold;");
		lblInfo.relocate(20, 40);

		lblQtdTurSemCap.setFont(javafx.scene.text.Font.font("Arial", 16));
		lblQtdTurSemCap.setStyle("-fx-font-weight: bold;");
		lblQtdTurSemCap.relocate(20, 120);

		lblTempo.setFont(javafx.scene.text.Font.font("Arial", 16));
		lblTempo.setStyle("-fx-font-weight: bold;");
		lblTempo.relocate(20, 180);

		lblNumeroDeJogadas.setFont(javafx.scene.text.Font.font("Arial", 16));
		lblNumeroDeJogadas.setStyle("-fx-font-weight: bold;");
		lblNumeroDeJogadas.relocate(20, 220);

		paneJogador1.getChildren().add(lblJogador1);
		paneJogador1.getChildren().add(lblQtdPecasClaras);
		paneJogador1.getChildren().add(desistirJogador1);
		paneJogador1.getChildren().add(lblVez1);

		paneJogador2.getChildren().add(lblJogador2);
		paneJogador2.getChildren().add(lblQtdPecasEscuras);
		paneJogador2.getChildren().add(desistirJogador2);
		paneJogador2.getChildren().add(lblVez2);

		paneInfoJogo.getChildren().add(lblQtdTurSemCap);
		paneInfoJogo.getChildren().add(lblTempo);
		paneInfoJogo.getChildren().add(lblNumeroDeJogadas);
		paneInfoJogo.getChildren().add(lblInfo);

		dadosDoJogo.getChildren().add(paneJogador2);
		dadosDoJogo.getChildren().add(paneJogador1);
		dadosDoJogo.getChildren().add(paneInfoJogo);

		jogo.getChildren().add(createContent());
		jogo.getChildren().add(dadosDoJogo);

		geral.getChildren().add(jogo);

		desistirJogador1.setOnAction(e -> {
			geral.setDisable(true);
			criaTelaDoFim();
		});

		desistirJogador2.setOnAction(e -> {
			geral.setDisable(true);
			criaTelaDoFim();
		});

		geral.setOnMouseClicked(e -> {
			lblQtdTurSemCap
					.setText("Quantidade de Turnos\nsem Captura: " + this.jogo.getTabuleiro().getContadorJogadas());
			lblQtdPecasClaras.setText("Quantidade de Pecas: " + this.jogo.getTabuleiro().getQuantidadePecasClaras());
			lblQtdPecasEscuras.setText("Quantidade de Pecas: " + this.jogo.getTabuleiro().getQuantidadePecasEscuras());

			lblNumeroDeJogadas.setText("Numero de jogadas: " + this.jogo.getTabuleiro().getNumeroDeJogadas());

			if (this.jogo.getTabuleiro().getNumeroDeJogadas() % 2 == 0) {
				desistirJogador2.setVisible(false);
				desistirJogador1.setVisible(true);

				lblVez2.setVisible(false);
				lblVez1.setVisible(true);
			} else {
				desistirJogador1.setVisible(false);
				desistirJogador2.setVisible(true);

				lblVez1.setVisible(false);
				lblVez2.setVisible(true);
			}

		});

		geral.setOnMouseMoved(e -> {
			lblNumeroDeJogadas.setText("Numero de jogadas: " + this.jogo.getTabuleiro().getNumeroDeJogadas());

			if (this.jogo.getTabuleiro().getNumeroDeJogadas() % 2 == 0) {
				desistirJogador2.setVisible(false);
				desistirJogador1.setVisible(true);

				lblVez2.setVisible(false);
				lblVez1.setVisible(true);
			} else {
				desistirJogador1.setVisible(false);
				desistirJogador2.setVisible(true);

				lblVez1.setVisible(false);
				lblVez2.setVisible(true);
			}

			if (this.jogo.isFimDeJogo()) {
				geral.setDisable(true);

				if (this.jogo.getResultado().equals(Resultado.COMVENCEDOR)) {
					System.out.println("\nParabens voce " + verificaVencedor() + " venceu!!");
					JOptionPane.showMessageDialog(null,
							"O jogo acabou! \nParabens " + verificaVencedor() + " , voce venceu!!\nDuração da Partida: "
									+ calculaTempo() + "\nNumero de Jogadas: "
									+ this.jogo.getTabuleiro().getNumeroDeJogadas(),
							"Parabens", 0);
				} else {
					JOptionPane.showMessageDialog(null, "Jogo empatado!!", "Empate", 1);
					System.out.println("\nJogo empatado!!");
				}

			} else {
				lblTempo.setText("Tempo da Partida: " + calculaTempo());

			}
		});

		return geral;
	}

	private Pane jogo(int a) {
		this.jogo.iniciarPartida(this.nomeJogador1, this.nomeJogador2);

		Pane jogo = new Pane();
		Pane geral = new Pane();
		Pane paneJogador1 = new Pane();
		Pane paneJogador2 = new Pane();
		Pane paneInfoJogo = new Pane();
		Pane dadosDoJogo = new Pane();

		Button desistirJogador1 = new Button("Desistir");
		Button desistirJogador2 = new Button("Desistir");

		Label lblVez1 = new Label("Sua vez!");
		Label lblVez2 = new Label("Sua vez!");
		Label lblJogador1 = new Label(this.jogo.getTabuleiro().getJogador1().getNome());
		Label lblJogador2 = new Label(this.jogo.getTabuleiro().getJogador2().getNome());
		Label lblQtdPecasClaras = new Label("Quantidade de Pecas: " + 12);
		Label lblQtdPecasEscuras = new Label("Quantidade de Pecas: " + 12);
		Label lblInfo = new Label("Informações do Jogo");

		Label lblNumeroDeJogadas = new Label("Numero de jogadas: " + 0);
		Label lblQtdTurSemCap = new Label("Quantidade de Turnos\nsem Captura: " + 0);

		geral.setMinWidth(900);

		jogo.setPrefSize(883, 642);
		jogo.setStyle("-fx-background-color: white; -fx-border-width:  2 2 2 2; -fx-border-style: solid;");

		paneJogador1.relocate(0, 470);
		paneJogador1.setPrefSize(241, 170);
		paneJogador1.setStyle("-fx-background-color: white; -fx-border-width:  2 0 0 2; -fx-border-style: solid;");

		paneJogador2.relocate(0, 0);
		paneJogador2.setPrefSize(241, 170);
		paneJogador2.setStyle("-fx-background-color: black; -fx-border-width:  2 0 0 2; -fx-border-style: solid;");

		paneInfoJogo.relocate(0, 170);
		paneInfoJogo.setPrefSize(241, 300);
		paneInfoJogo.setStyle("-fx-background-color: #f3f3f3; -fx-border-width: 2 0 0 2 ; -fx-border-style: solid;");

		dadosDoJogo.relocate(640, 0);
		dadosDoJogo.setPrefSize(200, 640);
		dadosDoJogo.setStyle("-fx-background-color: white;");

		lblJogador1.setFont(javafx.scene.text.Font.font("Arial", 18));
		lblJogador1.setStyle("-fx-font-weight: bold;");
		lblJogador1.relocate(30, 30);

		lblVez1.relocate(20, 130);
		lblVez1.setFont(javafx.scene.text.Font.font("Arial", 16));
		lblVez1.setStyle(" -fx-font-weight: bold;");

		desistirJogador1.setVisible(true);
		desistirJogador1.relocate(140, 130);
		desistirJogador1.setFont(javafx.scene.text.Font.font("Arial", 14));

		lblQtdPecasEscuras.setFont(javafx.scene.text.Font.font("Arial", 16));
		lblQtdPecasEscuras.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
		lblQtdPecasEscuras.relocate(20, 90);

		lblJogador2.setFont(javafx.scene.text.Font.font("Arial", 18));
		lblJogador2.relocate(30, 30);
		lblJogador2.setVisible(true);
		lblJogador2.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");

		lblVez2.relocate(20, 130);
		lblVez2.setVisible(false);
		lblVez2.setFont(javafx.scene.text.Font.font("Arial", 16));
		lblVez2.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");

		desistirJogador2.setVisible(false);
		desistirJogador2.relocate(140, 130);
		desistirJogador2.setFont(javafx.scene.text.Font.font("Arial", 14));

		lblQtdPecasClaras.setFont(javafx.scene.text.Font.font("Arial", 16));
		lblQtdPecasClaras.setStyle("-fx-font-weight: bold;");
		lblQtdPecasClaras.relocate(20, 90);

		lblInfo.setFont(javafx.scene.text.Font.font("Arial", 18));
		lblInfo.setStyle("-fx-font-weight: bold;");
		lblInfo.relocate(20, 40);

		lblQtdTurSemCap.setFont(javafx.scene.text.Font.font("Arial", 16));
		lblQtdTurSemCap.setStyle("-fx-font-weight: bold;");
		lblQtdTurSemCap.relocate(20, 120);

		lblTempo.setFont(javafx.scene.text.Font.font("Arial", 16));
		lblTempo.setStyle("-fx-font-weight: bold;");
		lblTempo.relocate(20, 180);

		lblNumeroDeJogadas.setFont(javafx.scene.text.Font.font("Arial", 16));
		lblNumeroDeJogadas.setStyle("-fx-font-weight: bold;");
		lblNumeroDeJogadas.relocate(20, 220);

		paneJogador1.getChildren().add(lblJogador1);
		paneJogador1.getChildren().add(lblQtdPecasClaras);
		paneJogador1.getChildren().add(desistirJogador1);
		paneJogador1.getChildren().add(lblVez1);

		paneJogador2.getChildren().add(lblJogador2);
		paneJogador2.getChildren().add(lblQtdPecasEscuras);
		paneJogador2.getChildren().add(desistirJogador2);
		paneJogador2.getChildren().add(lblVez2);

		paneInfoJogo.getChildren().add(lblQtdTurSemCap);
		paneInfoJogo.getChildren().add(lblTempo);
		paneInfoJogo.getChildren().add(lblNumeroDeJogadas);
		paneInfoJogo.getChildren().add(lblInfo);

		dadosDoJogo.getChildren().add(paneJogador2);
		dadosDoJogo.getChildren().add(paneJogador1);
		dadosDoJogo.getChildren().add(paneInfoJogo);

		jogo.getChildren().add(createContent());
		jogo.getChildren().add(dadosDoJogo);

		geral.getChildren().add(jogo);

		desistirJogador1.setOnAction(e -> {
			geral.setDisable(true);
			criaTelaDoFim();
		});

		desistirJogador2.setOnAction(e -> {
			geral.setDisable(true);
			criaTelaDoFim();
		});

		geral.setOnMouseClicked(e -> {
			lblQtdTurSemCap
					.setText("Quantidade de Turnos\nsem Captura: " + this.jogo.getTabuleiro().getContadorJogadas());
			lblQtdPecasClaras.setText("Quantidade de Pecas: " + this.jogo.getTabuleiro().getQuantidadePecasClaras());
			lblQtdPecasEscuras.setText("Quantidade de Pecas: " + this.jogo.getTabuleiro().getQuantidadePecasEscuras());

			lblNumeroDeJogadas.setText("Numero de jogadas: " + this.jogo.getTabuleiro().getNumeroDeJogadas());

			if (this.jogo.getTabuleiro().getNumeroDeJogadas() % 2 == 0) {
				desistirJogador2.setVisible(false);
				desistirJogador1.setVisible(true);

				lblVez2.setVisible(false);
				lblVez1.setVisible(true);
			} else {
				desistirJogador1.setVisible(false);
				desistirJogador2.setVisible(true);

				lblVez1.setVisible(false);
				lblVez2.setVisible(true);
			}

		});

		geral.setOnMouseMoved(e -> {
			lblNumeroDeJogadas.setText("Numero de jogadas: " + this.jogo.getTabuleiro().getNumeroDeJogadas());

			if (this.jogo.getTabuleiro().getNumeroDeJogadas() % 2 == 0) {
				desistirJogador2.setVisible(false);
				desistirJogador1.setVisible(true);

				lblVez2.setVisible(false);
				lblVez1.setVisible(true);
			} else {
				desistirJogador1.setVisible(false);
				desistirJogador2.setVisible(true);

				lblVez1.setVisible(false);
				lblVez2.setVisible(true);
			}

			if (this.jogo.isFimDeJogo()) {
				geral.setDisable(true);

				if (this.jogo.getResultado().equals(Resultado.COMVENCEDOR)) {
					System.out.println("\nParabens voce " + verificaVencedor() + " venceu!!");
					JOptionPane.showMessageDialog(null,
							"O jogo acabou! \nParabens " + verificaVencedor() + " , voce venceu!!\nDuração da Partida: "
									+ calculaTempo() + "\nNumero de Jogadas: "
									+ this.jogo.getTabuleiro().getNumeroDeJogadas(),
							"Parabens", 0);
				} else {
					JOptionPane.showMessageDialog(null, "Jogo empatado!!", "Empate", 1);
					System.out.println("\nJogo empatado!!");
				}

			} else {
				lblTempo.setText("Tempo da Partida: " + calculaTempo());

			}

			if (this.jogadorAuto == null) {
				if (this.jogo.getJogador1() instanceof JogadorAutonomo) {
					this.jogadorAuto = (JogadorAutonomo) this.jogo.getJogador1();
					this.jogadorAuto.jogarAuto(this.jogo);
					this.jogo = this.jogadorAuto.getJogo();
					this.jogadorAuto = null;
				} else if (this.jogo.getJogador2() instanceof JogadorAutonomo) {
					this.jogadorAuto = (JogadorAutonomo) this.jogo.getJogador2();
					this.jogadorAuto.jogarAuto(this.jogo);
					this.jogo = this.jogadorAuto.getJogo();
					this.jogadorAuto = null;
				}
			}
		});

		return geral;
	}

	private String verificaVencedor() {
		if (this.jogo.getTabuleiro().getQuantidadePecasClaras() < this.jogo.getTabuleiro()
				.getQuantidadePecasEscuras()) {
			return this.nomeJogador2;
		} else {
			return this.nomeJogador1;
		}
	}

	private Pane telaDoFim() {
		Pane tela = new Pane();

		tela.setPrefSize(400, 200);
		tela.setVisible(true);

		Label lblVencedor = new Label("Vencedor: " + verificaVencedor());
		Label lblTempo = new Label("Duração da Partida: " + calculaTempo());
		Label lblNumeroDeJogadas = new Label("Numero de Jogadas: " + this.jogo.getTabuleiro().getNumeroDeJogadas());
		Label lblOpcao = new Label("Deseja voltar ao inicio? ");

		lblVencedor.relocate(20, 20);
		lblVencedor.setVisible(true);
		lblVencedor.setText("Vencedor: ");
		lblVencedor.setStyle("fx-font-weight: bold;");
		lblVencedor.setFont(javafx.scene.text.Font.font("Arial", 16));

		lblTempo.relocate(20, 50);
		lblTempo.setVisible(true);
		lblTempo.setFont(javafx.scene.text.Font.font("Arial", 16));
		lblTempo.setStyle("fx-font-weight: bold;");

		lblNumeroDeJogadas.relocate(20, 80);
		lblNumeroDeJogadas.setVisible(true);
		lblNumeroDeJogadas.setFont(javafx.scene.text.Font.font("Arial", 16));
		lblNumeroDeJogadas.setStyle("fx-font-weight: bold;");

		lblOpcao.relocate(20, 120);
		lblOpcao.setVisible(true);
		lblOpcao.setStyle("fx-font-weight: bold;");
		lblOpcao.setFont(javafx.scene.text.Font.font("Arial", 16));

		tela.getChildren().add(lblVencedor);
		tela.getChildren().add(lblNumeroDeJogadas);
		tela.getChildren().add(lblOpcao);
		tela.getChildren().add(lblTempo);

		return tela;
	}

	private Stage criaTelaDoFim() {
		Stage fimStage = new Stage();

		Pane tela = telaDoFim();

		Scene telaFim = new Scene(tela);

		Button btnSim = new Button("Sim");
		Button btnNao = new Button("Não");

		btnSim.relocate(20, 160);
		btnSim.setFont(javafx.scene.text.Font.font("Arial", 16));

		btnNao.relocate(90, 160);
		btnNao.setFont(javafx.scene.text.Font.font("Arial", 16));

		tela.getChildren().add(btnSim);
		tela.getChildren().add(btnNao);

		btnSim.setOnAction(e -> {
			try {
				fimStage.close();
				Stage comeco = new Stage();
				start(comeco);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		fimStage.setTitle("Menu");
		fimStage.setScene(telaFim);
		fimStage.show();
		fimStage.setMinHeight(200);
		fimStage.setMinWidth(400);

		return fimStage;
	}

	private Pane menu(Stage primary) {
		Pane menu = new Pane();

		Button opcao1 = new Button(" Jogador vs Jogador ");
		Button opcao2 = new Button("Jogador vs Computador");

		opcao1.relocate(250, 180);
		opcao2.relocate(243, 240);

		menu.getChildren().addAll(opcao1, opcao2);

		opcao1.setOnAction(e -> {
			primary.close();

			Stage primaryStage = new Stage();
			Scene iniciarPartida = new Scene(escolhaDePecas());

			primaryStage.setTitle("Escolha a cor das suas pecas");
			primaryStage.setScene(iniciarPartida);
			primaryStage.show();
			primaryStage.setMinHeight(ALTURA_TELA);
			primaryStage.setMinWidth(LARGURA_TELA);

			btnPlay.setStyle("-fx-font-size: 16px;");

			btnPlay.setOnAction(e1 -> {
				Pane jogo = jogo();

				/*
				 * Image imgFundo = new Image("plano.jpg"); ImageView
				 * imgFundoView = new ImageView(imgFundo);
				 * 
				 * VBox box = new VBox(); box.getChildren().add(imgFundoView);
				 * box.setMinSize(200, 200);
				 * 
				 * jogo.getChildren().add(box);
				 */

				Scene scene = new Scene(jogo);
				primaryStage.setTitle("Daminhas do Zé");
				primaryStage.setScene(scene);
				primaryStage.show();

				primaryStage.setMinHeight(680);
				primaryStage.setMinWidth(660);
			});
		});

		opcao2.setOnAction(e -> {
			primary.close();

			Stage primaryStage = new Stage();
			Scene iniciarPartida = new Scene(escolhaDePecas(0));

			primaryStage.setTitle("Escolha a cor das suas pecas");
			primaryStage.setScene(iniciarPartida);
			primaryStage.show();
			primaryStage.setMinHeight(ALTURA_TELA);
			primaryStage.setMinWidth(LARGURA_TELA);

			btnPlay.setStyle("-fx-font-size: 16px;");

			btnPlay.setOnAction(e1 -> {
				Pane jogo = jogo(0);

				Scene scene = new Scene(jogo);
				primaryStage.setTitle("Daminhas do Zé");
				primaryStage.setScene(scene);
				primaryStage.show();

				primaryStage.setMinHeight(680);
				primaryStage.setMinWidth(660);
			});
		});

		return menu;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("Escolha a cor das suas pecas");
		Scene menu = new Scene(menu(primaryStage));
		primaryStage.setScene(menu);
		primaryStage.show();
		primaryStage.setMinHeight(400);
		primaryStage.setMinWidth(600);

	}

	private String calculaTempo() {
		String texto;

		this.jogo.setTempoFinal(Calendar.getInstance());
		this.segundos = (int) this.jogo.tempoDeJogo();

		if (this.segundos >= 60) {
			this.minutos = this.segundos / 60;
			this.horas = this.minutos / 60;

			this.segundos %= 60;
		}

		if (this.horas < 10) {
			texto = "0" + this.horas;
		} else {
			texto = "" + this.horas;
		}

		if (this.minutos < 10) {
			texto += ":0" + this.minutos;
		} else {
			texto += ":" + this.minutos;
		}

		if (this.segundos < 10) {
			texto += ":0" + this.segundos;
		} else {
			texto += ":" + this.segundos;
		}

		return texto;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
