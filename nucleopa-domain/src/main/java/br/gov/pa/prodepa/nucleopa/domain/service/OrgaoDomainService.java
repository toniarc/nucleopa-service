package br.gov.pa.prodepa.nucleopa.domain.service;

import java.util.List;
import java.util.Set;

import br.gov.pa.prodepa.nucleopa.domain.dto.OrgaoBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.port.OrgaoRepository;

public class OrgaoDomainService implements OrgaoService {

	private final OrgaoRepository repository;

	public OrgaoDomainService(OrgaoRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public List<OrgaoBasicDto> buscarOrgaoBasicoDtoPorId(Set<Long> ids) {
		return repository.buscarOrgaoBasicoDtoPorIds(ids);
	}
}
