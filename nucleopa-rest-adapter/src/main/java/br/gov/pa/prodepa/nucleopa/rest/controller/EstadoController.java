package br.gov.pa.prodepa.nucleopa.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.pa.prodepa.nucleopa.domain.dto.EstadoBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	private EstadoService service;

	@Autowired
	public EstadoController(EstadoService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public List<EstadoBasicDto> buscarTodosOsEstados() {
		return service.buscarTodosOsEstados();
	}
	
}
