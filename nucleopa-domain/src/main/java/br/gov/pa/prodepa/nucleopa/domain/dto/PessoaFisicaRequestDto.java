package br.gov.pa.prodepa.nucleopa.domain.dto;

import br.gov.pa.prodepa.nucleopa.domain.model.Sexo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaFisicaRequestDto {

	private Long id;
	private String nome;
	private String telefone;
	private String email;
	
	private String enderecoLogradouro;
	private String enderecoNumero;
	private String enderecoComplemento;
	private String enderecoCep;
	private String enderecoBairro;

	private Long estadoId;
	private Long municipioId;

	
	private Long aplicacaoManutencaoPessoaId;
	private Sexo sexo;
	private String cpf;
	
}
