package br.gov.pa.prodepa.nucleopa.domain.port;

import java.util.List;
import java.util.Set;

import br.gov.pa.prodepa.nucleopa.domain.dto.MunicipioBasicDto;

public interface MunicipioRepository {

	List<MunicipioBasicDto> buscarMunicipioBasicoDtoPorIds(Set<Long> ids);

	MunicipioBasicDto buscarPorCodigoIbge(String codigo);

	MunicipioBasicDto buscarPorId(Long id);

	List<MunicipioBasicDto> buscarPorEstadoId(Long id);

	List<MunicipioBasicDto> buscarPorCodigoIbgeDoEstado(String codigo);

}
