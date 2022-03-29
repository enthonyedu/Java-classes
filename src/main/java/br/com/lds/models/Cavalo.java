package br.com.lds.models;

public class Cavalo extends Animal {
	public Cavalo(String nome) {

		setId(getIdUnico());
		setNome(nome);

		incrementarIdUnico();

	}

}
