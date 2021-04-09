package br.gov.pa.prodepa.nucleopa.domain.service;

import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;

import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaFisicaBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.port.PessoaFisicaRepository;
import br.gov.pa.prodepa.pae.common.domain.exception.DomainException;

public class PessoaFisicaDomainService implements PessoaFisicaService {

	private final PessoaFisicaRepository repository;
	
	public PessoaFisicaDomainService(PessoaFisicaRepository repository) {
		super();
		this.repository = repository;
	}

	public List<PessoaFisicaBasicDto> buscarPessoaFisicaBasicoDtoPorId(Set<Long> ids) {
		List<PessoaFisicaBasicDto> list = repository.buscarPessoaFisicaBasicoDtoPorIds(ids);
		checkIfAllExists(ids, list, (e,id) -> e.getId().equals(id));
		return list;
	}
	
	private <T> void checkIfAllExists(Set<Long> ids, List<T> list, BiPredicate<T, Long> predicate) {
		DomainException de = new DomainException();
		
		ids.stream().forEach( id -> {
			boolean anyMatch = list.stream().anyMatch(e -> predicate.test(e, id));
			if(!anyMatch) {
				System.out.println("Nenhuma pessoa fisica com o id " + id + " foi encontrada.");
				de.addError("Nenhuma pessoa fisica com o id " + id + " foi encontrada.");
			}
		});
		
		de.throwException();
	}
}
