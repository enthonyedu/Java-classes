package br.com.lds.models;

public class Girafa extends Animal {

	public Girafa(String nome) {

		setId(getIdUnico());
		setNome(nome);

		incrementarIdUnico();

	}

}
