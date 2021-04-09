package br.gov.pa.prodepa.nucleopa.jpa.entity;

public enum TipoAdministracao {

	DIRETA  (0, "Administração Direta"),
	INDIRETA(1, "Administração Indireta");

	private int codigo;
	private String descricao;

	private TipoAdministracao(int codigo, String descricao) {
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
