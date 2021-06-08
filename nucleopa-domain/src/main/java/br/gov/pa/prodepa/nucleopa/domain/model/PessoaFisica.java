package br.gov.pa.prodepa.nucleopa.domain.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaFisica {

	private String cpf;
	private Sexo sexo;
	private Long aplicacaoManutencaoPessoaId;

	private Integer versao;
	private Date dataManutencao;
	private Long idUsuarioManutencao;
	private String codigoOperacao;
	private Pessoa pessoa;
	
}
