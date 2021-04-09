package br.gov.pa.prodepa.nucleopa.domain.port;

import java.util.List;
import java.util.Set;

import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaFisicaBasicDto;

public interface PessoaFisicaRepository {

	List<PessoaFisicaBasicDto> buscarPessoaFisicaBasicoDtoPorIds(Set<Long> ids);

}
