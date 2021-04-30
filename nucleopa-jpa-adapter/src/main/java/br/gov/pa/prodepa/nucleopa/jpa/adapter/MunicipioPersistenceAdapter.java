package br.gov.pa.prodepa.nucleopa.jpa.adapter;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.pa.prodepa.nucleopa.domain.dto.MunicipioBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.port.MunicipioRepository;
import br.gov.pa.prodepa.nucleopa.jpa.repository.MunicipioJpaRepository;

@Component
public class MunicipioPersistenceAdapter implements MunicipioRepository{

	private final MunicipioJpaRepository repository;

	@Autowired
	public MunicipioPersistenceAdapter(MunicipioJpaRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<MunicipioBasicDto> buscarMunicipioBasicoDtoPorIds(Set<Long> ids) {
		return repository.buscarMunicipioBasicoDtoPorIds(ids);
	}

	@Override
	public MunicipioBasicDto buscarPorCodigoIbge(String codigo) {
		return repository.buscarPorCodigoIbge(codigo);
	}

	@Override
	public MunicipioBasicDto buscarPorId(Long id) {
		return repository.buscarPorId(id);
	}

	@Override
	public List<MunicipioBasicDto> buscarPorEstadoId(Long id) {
		return repository.buscarMunicipioBasicoDtoPorEstado(id);
	}

	@Override
	public List<MunicipioBasicDto> buscarPorCodigoIbgeDoEstado(String codigo) {
		return repository.buscarPorCodigoIbgeDoEstado(codigo);
	}
	
}
