package br.gov.pa.prodepa.nucleopa.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaJuridicaBasicDto {

	private Long id;
	private String nome;

	public PessoaJuridicaBasicDto() {
	}

	public PessoaJuridicaBasicDto(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

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
		PessoaJuridicaBasicDto other = (PessoaJuridicaBasicDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
