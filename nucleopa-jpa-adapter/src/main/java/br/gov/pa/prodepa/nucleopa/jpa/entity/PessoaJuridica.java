package br.gov.pa.prodepa.nucleopa.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "pessoa_juridica", schema = "nucleopa")
public class PessoaJuridica {

	@Id
	private Long id;
	
	@Column(length = 14, nullable = false)
	private String cnpj;

	@Column(name = "nome_fantasia", length = 200)
	private String nomeFantasia;

	@Column(name = "nome_fantasia_fonetico", length = 400)
	private String nomeFantasiaFonetico;

	@OneToOne(mappedBy = "pessoaJuridica", fetch = FetchType.LAZY, optional = true)
	private Orgao orgao;

	@Column(nullable = false)
	private Integer versao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manut")
	private Date dataManutencao;
	
	@Column(name = "id_usuario_manut")
	private Long idUsuarioManutencao;
	
	@Column(name = "id_aplicacao_manut")
	private Long idAplicacaoManutencao;

	@Column(name ="codigo_operacao_manut", length = 20)
	private String codigoOperacao;
	
	@OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private PessoaEntity pessoa;

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
		PessoaJuridica other = (PessoaJuridica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
