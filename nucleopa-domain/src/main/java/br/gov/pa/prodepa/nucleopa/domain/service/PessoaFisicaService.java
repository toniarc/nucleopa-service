package br.gov.pa.prodepa.nucleopa.domain.service;

import java.util.List;
import java.util.Set;

import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaFisicaBasicDto;

public interface PessoaFisicaService {

	List<PessoaFisicaBasicDto> buscarPessoaFisicaBasicoDtoPorId(Set<Long> ids);

}
