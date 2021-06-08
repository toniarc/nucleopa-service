package br.gov.pa.prodepa.nucleopa.domain.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Telefone {

	private Long id;
	private Pessoa pessoa;
	private TipoTelefone tipo;
	private String ddd;
	private String numero;
	private String observacao;
	private Boolean principal;
	private Date dataManutencao;
	private Long idUsuarioManutencao;
	private Long idAplicacaoManutencao;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
