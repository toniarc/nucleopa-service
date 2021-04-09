package br.gov.pa.prodepa.nucleopa.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pessoa_fisica", schema = "nucleopa")
public class PessoaFisica {

	@Id
	private Long id;
	
	@Column(length = 11, nullable = false)
	private String cpf;

	@Enumerated
	@Column(name = "id_sexo")
	private Sexo sexo;

	@Column(nullable = false)
	private Integer versao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manut")
	private Date dataManutencao;

	@Column(name = "id_usuario_manut")
	private Long idUsuarioManutencao;

	@Column(name = "id_aplicacao_manut")
	private Long idAplicacaoManutencao;

	@Column(name = "codigo_operacao_manut", length = 20)
	private String codigoOperacao;
	
	@OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Pessoa pessoa;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
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
		PessoaFisica other = (PessoaFisica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}
	
	
}
