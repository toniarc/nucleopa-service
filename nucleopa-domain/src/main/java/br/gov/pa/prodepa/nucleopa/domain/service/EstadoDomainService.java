package br.gov.pa.prodepa.nucleopa.domain.service;

import java.util.List;

import br.gov.pa.prodepa.nucleopa.domain.dto.EstadoBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.port.EstadoRepository;

public class EstadoDomainService implements EstadoService {

	private final EstadoRepository estadoRepository;
	
	public EstadoDomainService(EstadoRepository estadoRepository) {
		super();
		this.estadoRepository = estadoRepository;
	}

	public List<EstadoBasicDto> buscarTodosOsEstados(){
		return estadoRepository.buscarTodosEstados();
	}
}
