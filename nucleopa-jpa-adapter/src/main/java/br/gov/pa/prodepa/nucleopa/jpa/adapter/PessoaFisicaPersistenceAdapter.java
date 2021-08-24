package br.gov.pa.prodepa.nucleopa.jpa.adapter;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.pa.prodepa.nucleopa.domain.dto.ConsultaPaginaDto;
import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaFisicaBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.port.PessoaFisicaRepository;
import br.gov.pa.prodepa.nucleopa.jpa.repository.PessoaFisicaJdbcRepository;
import br.gov.pa.prodepa.nucleopa.jpa.repository.PessoaFisicaJpaRepository;

@Component
public class PessoaFisicaPersistenceAdapter implements PessoaFisicaRepository {

	@Autowired
	private PessoaFisicaJpaRepository repository;
	
	@Autowired
	private PessoaFisicaJdbcRepository jdbcRepository;
	
	public List<PessoaFisicaBasicDto> buscarPessoaFisicaBasicoDtoPorIds(Set<Long> ids) {
		return repository.buscarPessoaFisicaBasicoDtoPorIds(ids);
	}

	@Override
	public ConsultaPaginaDto<PessoaFisicaBasicDto> buscarPessoaFisicaBasicoDtoPorNomeOuCpf(String nome, String cpf, int pageNumber, int pageSize) {
		
		List<PessoaFisicaBasicDto> list = jdbcRepository.buscarPessoaFisicaBasicoDtoPorNomeOuCpf(nome, cpf, pageNumber, pageSize);
		Long count = jdbcRepository.contarPessoaFisicaBasicoDtoPorNomeOuCpf(nome, cpf);
		
		int totalPages = (int) ((count / pageSize) + 1);
		
		return new ConsultaPaginaDto<PessoaFisicaBasicDto>( totalPages, count.intValue(), pageNumber,list);
	}

	@Override
	public boolean verificarSeCpfJaEstaCadastrado(Long id, String cpf) {
		if(id != null) {
			return repository.countByIdNotAndCpf(id, cpf) > 0;
		}
		return repository.countByIdNotAndCpf(-1L, cpf) > 0;
	}
}
