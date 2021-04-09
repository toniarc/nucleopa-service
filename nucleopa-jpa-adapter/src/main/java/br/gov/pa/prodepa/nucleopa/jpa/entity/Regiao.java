package br.gov.pa.prodepa.nucleopa.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "regiao", schema = "nucleopa")
@SequenceGenerator(name = "sg_regiao", sequenceName = "sq_regiao", allocationSize = 1, initialValue = 1)
public class Regiao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sg_regiao")
	private Long id;

	@Column(length = 100, nullable = false)
	private String descricao;

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
		Regiao other = (Regiao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
