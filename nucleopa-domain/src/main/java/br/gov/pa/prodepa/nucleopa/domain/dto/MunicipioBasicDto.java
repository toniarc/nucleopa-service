package br.gov.pa.prodepa.nucleopa.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MunicipioBasicDto {

	private Long id;
	private String nome;
	private String codigoIbge;
	private EstadoBasicDto estado;
	
	public MunicipioBasicDto() {
	}

	public MunicipioBasicDto(Long id, String nome, String codigoIbge, Long estadoId, String estadoNome, String estadoUf, String estadoCodigoIbge) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigoIbge = codigoIbge;
		this.estado = new EstadoBasicDto(estadoId, estadoNome, estadoUf, estadoCodigoIbge);
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
		MunicipioBasicDto other = (MunicipioBasicDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
