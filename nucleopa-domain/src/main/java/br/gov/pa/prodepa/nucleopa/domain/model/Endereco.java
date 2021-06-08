package br.gov.pa.prodepa.nucleopa.domain.model;

import java.util.Date;

import br.gov.pa.prodepa.nucleopa.domain.dto.EstadoBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.dto.MunicipioBasicDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {

	private Long id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	private EstadoBasicDto estado;
	private MunicipioBasicDto municipio;
	private String bairro;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
