package br.gov.pa.prodepa.nucleopa.domain.port;

import java.util.List;
import java.util.Set;

import br.gov.pa.prodepa.nucleopa.domain.dto.ConsultaPaginaDto;
import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaJuridicaBasicDto;

public interface PessoaJuridicaRepository {

	List<PessoaJuridicaBasicDto> buscarPessoaJuridicaBasicoDtoPorIds(Set<Long> ids);

	ConsultaPaginaDto<PessoaJuridicaBasicDto> buscarPessoaJuridicaBasicoDtoPorNomeOuCpf(String nome, String cnpj,
			int pageNumber, int pageSize);

}
