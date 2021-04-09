package br.gov.pa.prodepa.nucleopa.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "telefone", schema = "nucleopa")
@SequenceGenerator(name = "sg_telefone", sequenceName = "sq_telefone", initialValue = 1, allocationSize = 1)
public class Telefone {

	@Id
	@GeneratedValue(generator = "sg_telefone", strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pessoa", nullable = false)
	private Pessoa pessoa;

	@Enumerated
	@Column(name = "id_tipo_telefone", nullable = false)
	private TipoTelefone tipo;

	@Column(name = "cd_ddd", length = 3)
	private String ddd;

	@Column(length = 15, nullable = false)
	private String numero;

	@Column(name = "obs", length = 200)
	private String observacao;

	@Enumerated
	@Column(nullable = false, columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean principal;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manut")
	private Date dataManutencao;
	
	@Column(name = "id_usuario_manut")
	private Long idUsuarioManutencao;
	
	@Column(name = "id_aplicacao_manut")
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