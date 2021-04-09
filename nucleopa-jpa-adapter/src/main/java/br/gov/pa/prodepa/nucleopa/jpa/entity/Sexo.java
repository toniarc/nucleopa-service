package br.gov.pa.prodepa.nucleopa.jpa.entity;

public enum Sexo {

	MASCULINO(0, "Masculino"),
	FEMININO (1, "Feminino");

	private int codigo;
	private String descricao;

	private Sexo(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}
}
