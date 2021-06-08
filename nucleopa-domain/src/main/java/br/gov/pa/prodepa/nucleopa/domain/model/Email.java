package br.gov.pa.prodepa.nucleopa.domain.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {

	private Long id;
	private Pessoa pessoa;
	private String email;
	private String descricao;
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
		Email other = (Email) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
