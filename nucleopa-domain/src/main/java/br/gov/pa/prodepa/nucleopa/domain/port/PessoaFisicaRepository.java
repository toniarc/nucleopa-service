package br.gov.pa.prodepa.nucleopa.domain.port;

import java.util.List;
import java.util.Set;

import br.gov.pa.prodepa.nucleopa.domain.dto.ConsultaPaginaDto;
import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaFisicaBasicDto;

public interface PessoaFisicaRepository {

	List<PessoaFisicaBasicDto> buscarPessoaFisicaBasicoDtoPorIds(Set<Long> ids);

	public ConsultaPaginaDto<PessoaFisicaBasicDto> buscarPessoaFisicaBasicoDtoPorNomeOuCpf(String nome, String cpf, int pageNumber, int pageSize);

	boolean verificarSeCpfJaEstaCadastrado(Long id, String cpf);

}
