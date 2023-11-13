package br.com.poli.seltonheitor.damas.jogo;

public interface JogoInterface {

	public abstract boolean verificaEmpate();

	public abstract boolean isFimDeJogo();

	public abstract void contaTempo();

	public abstract long tempoDeJogo();

	public abstract void iniciarPartida(String nomeUm, String nomeDois);

}
