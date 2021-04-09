package br.gov.pa.prodepa.nucleopa.domain.service;

import java.util.List;
import java.util.Set;

import br.gov.pa.prodepa.nucleopa.domain.dto.OrgaoBasicDto;

public interface OrgaoService {

	List<OrgaoBasicDto> buscarOrgaoBasicoDtoPorId(Set<Long> ids);

}
