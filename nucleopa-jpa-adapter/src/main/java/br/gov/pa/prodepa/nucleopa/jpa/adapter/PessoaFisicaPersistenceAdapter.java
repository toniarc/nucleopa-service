package br.gov.pa.prodepa.nucleopa.jpa.adapter;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaFisicaBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.port.PessoaFisicaRepository;
import br.gov.pa.prodepa.nucleopa.jpa.repository.PessoaFisicaJpaRepository;

@Component
public class PessoaFisicaPersistenceAdapter implements PessoaFisicaRepository {

	@Autowired
	private PessoaFisicaJpaRepository repository;
	
	public List<PessoaFisicaBasicDto> buscarPessoaFisicaBasicoDtoPorIds(Set<Long> ids) {
		return repository.buscarPessoaFisicaBasicoDtoPorIds(ids);
	}

}
