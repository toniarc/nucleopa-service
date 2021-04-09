package br.gov.pa.prodepa.nucleopa.domain.service;

import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;

import br.gov.pa.prodepa.nucleopa.domain.dto.MunicipioBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.port.MunicipioRepository;
import br.gov.pa.prodepa.pae.common.domain.exception.DomainException;

public class MunicipioDomainService implements MunicipioService {

	private final MunicipioRepository repository;
	
	public MunicipioDomainService(MunicipioRepository repository) {
		super();
		this.repository = repository;
	}

	public List<MunicipioBasicDto> buscarMunicipiosBasicoDtoPorId(Set<Long> ids) {
		List<MunicipioBasicDto> list = repository.buscarMunicipioBasicoDtoPorIds(ids);
		checkIfAllExists(ids, list, (e, id) -> e.getId().equals(id));
		return list;
	}
	
	private <T> void checkIfAllExists(Set<Long> ids, List<T> list, BiPredicate<T, Long> predicate) {
		DomainException de = new DomainException();
		
		ids.stream().forEach( id -> {
			boolean anyMatch = list.stream().anyMatch(e -> predicate.test(e, id));
			if(!anyMatch) {
				de.addError("Nenhum municipio com o id " + id + " foi encontrado.");
			}
		});
		
		de.throwException();
	}
}
