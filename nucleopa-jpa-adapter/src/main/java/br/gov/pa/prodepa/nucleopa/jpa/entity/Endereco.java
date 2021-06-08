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
import javax.persistence.OneToOne;
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
@Table(name = "endereco", schema = "nucleopa")
@SequenceGenerator(name = "sg_endereco", sequenceName = "sq_endereco", initialValue = 1, allocationSize = 1)
public class Endereco {

	@Id
	@GeneratedValue(generator = "sg_endereco", strategy = GenerationType.SEQUENCE)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pessoa", nullable = false)
	private PessoaEntity pessoa;

	@Column(length = 100)
	private String logradouro;

	@Column(length = 15)
	private String numero;

	@Column(length = 150)
	private String complemento;

	@Column(length = 9)
	private String cep;

	@ManyToOne
	@JoinColumn(name = "id_estado")
	private EstadoEntity estado;

	@ManyToOne
	@JoinColumn(name = "id_municipio")
	private Municipio municipio;

	@Column(length = 100)
	private String bairro;

	@Column(name = "obs", length = 300)
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}