package br.gov.pa.prodepa.nucleopa.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PessoaFisicaBasicDto {

	private Long id;
	private String nome;
	private String cpf;
	
	/*
	Long getId();
	String getNome();
	String getCpf();
	*/
	
}