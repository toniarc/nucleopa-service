package br.gov.pa.prodepa.nucleopa.jpa.adapter;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaJuridicaBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.port.PessoaJuridicaRepository;
import br.gov.pa.prodepa.nucleopa.jpa.repository.PessoaJuridicaJpaRepository;

@Component
public class PessoaJuridicaPersistenceAdapter implements PessoaJuridicaRepository {

	private final PessoaJuridicaJpaRepository repository;
	
	@Autowired
	public PessoaJuridicaPersistenceAdapter(PessoaJuridicaJpaRepository repository) {
		super();
		this.repository = repository;
	}

	public List<PessoaJuridicaBasicDto> buscarPessoaJuridicaBasicoDtoPorIds(Set<Long> ids) {
		return repository.buscarPessoaJuridicaBasicoDtoPorIds(ids);
	}

}
