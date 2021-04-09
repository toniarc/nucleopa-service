package br.gov.pa.prodepa.nucleopa.domain.port;

import java.util.List;
import java.util.Set;

import br.gov.pa.prodepa.nucleopa.domain.dto.OrgaoBasicDto;

public interface OrgaoRepository {

	List<OrgaoBasicDto> buscarOrgaoBasicoDtoPorIds(Set<Long> ids);

}
