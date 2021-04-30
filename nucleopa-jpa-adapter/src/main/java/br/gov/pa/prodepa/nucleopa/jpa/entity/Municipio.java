package br.gov.pa.prodepa.nucleopa.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "municipio", schema = "nucleopa")
@SequenceGenerator(name = "sg_municipio", sequenceName = "sq_municipio", initialValue = 1, allocationSize = 1)
public class Municipio {

	@Id
	@GeneratedValue(generator = "sg_municipio", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(length = 100, nullable = false)
	private String descricao;

	@Column(name = "descricao_fonetica", length = 200)
	private String descricaoFonetica;

	@Column(name ="codigo_ibge", length = 7)
	private String codigoIbge;

	@Column(name ="codigo_dne")
	private Integer codigoDne;

	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = false)
	private EstadoEntity estado;

	@Enumerated
	@Column(nullable = false, columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean ativo;

	@Column(nullable = false)
	private Integer versao;

	@Column(name = "id_usuario_manut")
	private Long idUsuarioManutencao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manut")
	private Date dataManutencao;

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
		Municipio other = (Municipio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}