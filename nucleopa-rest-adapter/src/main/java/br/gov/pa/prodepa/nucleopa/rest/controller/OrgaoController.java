package br.gov.pa.prodepa.nucleopa.rest.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.pa.prodepa.nucleopa.domain.dto.OrgaoBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.service.OrgaoService;

@RestController
@RequestMapping("/orgaos")
public class OrgaoController {

	private final OrgaoService service;
	
	@Autowired
	public OrgaoController(OrgaoService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/formato-basico")
	public List<OrgaoBasicDto> buscarOrgaoBasicoDtoPorId(@RequestParam(value="ids", required = true) Set<Long> ids) {
		return service.buscarOrgaoBasicoDtoPorId(ids);
	}
	
	@GetMapping("/formato-basico/todos-orgaos-ativos")
	public List<OrgaoBasicDto> buscarOrgaoTodosOrgaosAtivos() {
		return service.buscarOrgaoTodosOrgaosAtivos();
	}
}
