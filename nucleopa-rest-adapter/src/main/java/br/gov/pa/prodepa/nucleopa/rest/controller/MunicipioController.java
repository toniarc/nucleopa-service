package br.gov.pa.prodepa.nucleopa.rest.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<MunicipioBasicDto> buscarMunicipiosBasicoDtoPorId(@RequestParam(value="ids", required = true) Set<Long> ids) {
		return service.buscarMunicipiosBasicoDtoPorId(ids);
	}
}
