package br.gov.pa.prodepa.nucleopa.domain.service;

import java.util.List;
import java.util.Set;

import br.gov.pa.prodepa.nucleopa.domain.dto.MunicipioBasicDto;

public interface MunicipioService {

	List<MunicipioBasicDto> buscarMunicipiosBasicoDtoPorId(Set<Long> ids);

}
