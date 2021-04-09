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

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orgao", schema = "nucleopa")
public class Orgao {

	@Id
	@Column(name = "id_orgao")
	private Long id;

	@OneToOne()
	@JoinColumn(name = "id_orgao")
	@MapsId
	private PessoaJuridica pessoaJuridica;

	@Column(length = 100)
	private String sigla;

	@Column(name = "id_orgao_adabas", length = 5)
	private String codigoAdabas;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_ato_legal")
	private Date dataAtoLegal;

	@Column(name="numero_ato_legal", length = 100)
	private String numeroAtoLegal;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "vigencia")
	private Date dataVigencia;

	@Enumerated
	@Column(name = "id_tipo_administracao")
	private TipoAdministracao tipoAdministracao;

	@Enumerated
	@Column(nullable = false, columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_ato_legal_extincao")
	private Date dataAtoLegalExtincao;

	@Column(name="numero_ato_legal_extincao", length = 100)
	private String numeroAtoLegalExtincao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "vigencia_extincao")
	private Date dataVigenciaExtincao;

	@Column(nullable = false)
	private Integer versao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manut")
	private Date dataManutencao;

	@Column(name = "id_usuario_manut")
	private Long idUsuarioManutencao;

	@Column(name ="codigo_operacao_manut", length = 20)
	private String codigoOperacao;

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
		Orgao other = (Orgao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
