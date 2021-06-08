package br.gov.pa.prodepa.nucleopa.domain.port;

import java.util.List;

import br.gov.pa.prodepa.nucleopa.domain.dto.EstadoBasicDto;

public interface EstadoRepository {

	List<EstadoBasicDto> buscarTodosEstados();

	EstadoBasicDto buscarPorId(Long estadoId);

}
