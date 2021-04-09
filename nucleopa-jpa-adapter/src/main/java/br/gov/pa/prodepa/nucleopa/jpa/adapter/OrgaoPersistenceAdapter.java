package br.gov.pa.prodepa.nucleopa.jpa.adapter;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.pa.prodepa.nucleopa.domain.dto.OrgaoBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.port.OrgaoRepository;
import br.gov.pa.prodepa.nucleopa.jpa.repository.OrgaoJpaRepository;

@Component
public class OrgaoPersistenceAdapter implements OrgaoRepository{

	private OrgaoJpaRepository repository;
	
	@Autowired
	public OrgaoPersistenceAdapter(OrgaoJpaRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<OrgaoBasicDto> buscarOrgaoBasicoDtoPorIds(Set<Long> ids) {
		return repository.buscarOrgaoBasicoDtoPorIds(ids);
	}

}
