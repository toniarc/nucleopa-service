package br.gov.pa.prodepa.nucleopa.domain.service;

import java.util.List;
import java.util.Set;

import br.gov.pa.prodepa.nucleopa.domain.dto.ConsultaPaginaDto;
import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaJuridicaBasicDto;

public interface PessoaJuridicaService {

	List<PessoaJuridicaBasicDto> buscarPessoaJuridicaBasicoDtoPorId(Set<Long> ids);

	ConsultaPaginaDto<PessoaJuridicaBasicDto> buscarPessoaJuridicaBasicoDtoPorNomeOuCnpj(String nome, String cnpj,
			int pageNumber, int pageSize);

}
