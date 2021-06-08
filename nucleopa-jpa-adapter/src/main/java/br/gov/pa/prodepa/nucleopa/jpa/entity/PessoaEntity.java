package br.gov.pa.prodepa.nucleopa.jpa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import br.gov.pa.prodepa.nucleopa.domain.model.TipoPessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pessoa", schema = "nucleopa")
@SequenceGenerator(name = "sg_pessoa", sequenceName = "sq_pessoa", initialValue = 1, allocationSize = 1)
public class PessoaEntity {

	@Id
	@GeneratedValue(generator = "sg_pessoa", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Enumerated
	@Column(name = "id_tipo_pessoa", nullable = false)
	private TipoPessoa tipoPessoa;

	@Column(length = 200, nullable = false)
	private String nome;

	@Column(name = "nome_fonetico", length = 400)
	private String nomeFonetico;

	@Column(name = "e_fornecedor", columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean ehFornecedor;

	@Enumerated
	@Column(name = "e_orgao", columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean ehOrgao;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Endereco> enderecos;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Telefone> telefones;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	@javax.persistence.OrderBy("email")
	private List<Email> emails;

	@Column(name = "versao", nullable = false)
	private Integer versaoPessoa;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_manut")
	private Date dataManutencaoPessoa;
	
	@Column(name = "id_usuario_manut")
	private Long idUsuarioManutencaoPessoa;
	
	@Column(name = "id_aplicacao_manut")
	private Long idAplicacaoManutencaoPessoa;
	
	@Column(name ="codigo_operacao_manut", length = 20)
	private String codigoOperacaoPessoa;

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
		PessoaEntity other = (PessoaEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}