package br.gov.pa.prodepa.nucleopa.rest.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.pa.prodepa.nucleopa.domain.dto.MunicipioBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.service.MunicipioService;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {

	@Autowired
	private MunicipioService service;
	
	@GetMapping("/formato-basico")
	public List<MunicipioBasicDto> buscarMunicipiosBasicoDtoPorIds(@RequestParam(value="ids", required = true) Set<Long> ids) {
		return service.buscarMunicipiosBasicoDtoPorId(ids);
	}
	
	@GetMapping("/formato-basico/id/{id}")
	public MunicipioBasicDto buscarMunicipiosBasicoDtoPorId(@PathVariable("id") Long id) {
		return service.buscarPorId(id);
	}
	
	@GetMapping("/formato-basico/codigo-ibge/{codigo}")
	public MunicipioBasicDto buscarMunicipiosBasicoDtoPorCodigoIbge(@PathVariable("codigo") String codigo) {
		return service.buscarPorCodigoIbge(codigo);
	}
	
	@GetMapping("/formato-basico/estado/{id}")
	public List<MunicipioBasicDto> buscarMunicipiosBasicoDtoPorEstado(@PathVariable("id") Long id) {
		return service.buscarPorEstadoId(id);
	}
	
	@GetMapping("/formato-basico/estado/codigo-ibge/{codigo}")
	public List<MunicipioBasicDto> buscarMunicipiosBasicoDtoPorCodigoIbgeDoEstado(@PathVariable("codigo") String codigo) {
		return service.buscarPorCodigoIbgeDoEstado(codigo);
	}
}
