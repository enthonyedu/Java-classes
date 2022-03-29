package br.com.lds.models;

public abstract class Animal {

	private int id;
	private String nome;

	private static int ID_UNICO = 0;

	protected void incrementarIdUnico() {
		ID_UNICO += 1;
	}

	public int getIdUnico() {
		return ID_UNICO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
