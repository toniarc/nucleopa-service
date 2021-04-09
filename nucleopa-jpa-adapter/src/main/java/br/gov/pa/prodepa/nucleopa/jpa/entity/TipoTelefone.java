package br.gov.pa.prodepa.nucleopa.jpa.entity;

public enum TipoTelefone {

	COMERCIAL  (0, "Comercial"),
	RESIDENCIAL(1, "Residencial"),
	CELULAR    (2, "Celular"),
	FAX        (3, "Fax");

	private int codigo;
	private String descricao;

	private TipoTelefone(int codigo, String descricao) {
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
