package br.gov.pa.prodepa.nucleopa.jpa.entity;

public enum TipoPessoa {

	FISICA  (0, "Pessoa Física"),
	JURIDICA(1, "Pessoa Jurídica"),
	GENERICA(2, "Inscrição Genérica");

	private int codigo;
	private String descricao;

	private TipoPessoa(int codigo, String descricao) {
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
