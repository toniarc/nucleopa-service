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
@Table(name = "estado", schema = "nucleopa")
@SequenceGenerator(name = "sg_estado", sequenceName = "sq_estado", allocationSize = 1, initialValue = 1)
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sg_estado")
	private Long id;

	@Column(length = 100, nullable = false)
	private String descricao;

	@Column(name = "descricao_fonetica", length = 200)
	private String descricaoFonetica;

	@Column(length = 2, nullable = false)
	private String uf;

	@Column(name ="codigo_ibge", length = 2, nullable = false)
	private String codigoIbge;

	@ManyToOne
	@JoinColumn(name = "id_regiao", nullable = false)
	private Regiao regiao;

	@Enumerated
	@Column(name = "ativo", columnDefinition = "TINYINT")
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
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
