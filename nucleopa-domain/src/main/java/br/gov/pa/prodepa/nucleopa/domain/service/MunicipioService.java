package br.gov.pa.prodepa.nucleopa.domain.service;

import java.util.List;
import java.util.Set;

import br.gov.pa.prodepa.nucleopa.domain.dto.MunicipioBasicDto;

public interface MunicipioService {

	List<MunicipioBasicDto> buscarMunicipiosBasicoDtoPorId(Set<Long> ids);

	MunicipioBasicDto buscarPorId(Long id);

	MunicipioBasicDto buscarPorCodigoIbge(String codigo);

	List<MunicipioBasicDto> buscarPorEstadoId(Long id);

	List<MunicipioBasicDto> buscarPorCodigoIbgeDoEstado(String codigo);

}
