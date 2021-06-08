package br.gov.pa.prodepa.nucleopa.domain.model;

import java.util.Date;
import java.util.List;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
public class Pessoa {

	private Long id;
	private String nome;
	private List<Endereco> enderecos;
	private List<Telefone> telefones;
	private List<Email> emails;

	private TipoPessoa tipoPessoa;
	private Boolean ehFornecedor;
	private Boolean ehOrgao;
	private Integer versaoPessoa;
	private Date dataManutencaoPessoa;
	private Long idUsuarioManutencaoPessoa;
	private Long idAplicacaoManutencaoPessoa;
	private String codigoOperacaoPessoa;
}
