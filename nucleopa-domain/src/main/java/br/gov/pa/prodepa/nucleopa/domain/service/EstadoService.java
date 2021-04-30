package br.gov.pa.prodepa.nucleopa.domain.service;

import java.util.List;

import br.gov.pa.prodepa.nucleopa.domain.dto.EstadoBasicDto;

public interface EstadoService {

	List<EstadoBasicDto> buscarTodosOsEstados();

}
