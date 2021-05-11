package br.gov.pa.prodepa.nucleopa.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrgaoBasicDto {

	private Long id;
	private String nome;
	private String sigla;
	private String cnpj;

	public OrgaoBasicDto() {
	}
	
	public OrgaoBasicDto(Long id, String nome, String sigla) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}
	
	public OrgaoBasicDto(Long id, String nome, String sigla, String cnpj) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.cnpj = cnpj;
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
		OrgaoBasicDto other = (OrgaoBasicDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
