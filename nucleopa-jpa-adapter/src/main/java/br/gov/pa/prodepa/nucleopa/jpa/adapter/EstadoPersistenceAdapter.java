package br.gov.pa.prodepa.nucleopa.jpa.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.pa.prodepa.nucleopa.domain.dto.EstadoBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.port.EstadoRepository;
import br.gov.pa.prodepa.nucleopa.jpa.repository.EstadoJpaRepository;

@Component
public class EstadoPersistenceAdapter implements EstadoRepository{

	private final EstadoJpaRepository repository;
	
	@Autowired
	public EstadoPersistenceAdapter(EstadoJpaRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<EstadoBasicDto> buscarTodosEstados() {
		return repository.buscarTodosEstados();
	}

}
