package br.gov.pa.prodepa.nucleopa.rest.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaJuridicaBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.service.PessoaJuridicaService;

@RestController
@RequestMapping("/pessoas-juridicas")
public class PessoaJuridicaController {

	private final PessoaJuridicaService service;
	
	@Autowired
	public PessoaJuridicaController(PessoaJuridicaService service) {
		super();
		this.service = service;
	}

	@GetMapping()
	public String teste() {
		return "teste";
	}
	
	@GetMapping("/formato-basico")
	public List<PessoaJuridicaBasicDto> buscarPessoaJuridicaBasicoDtoPorId(@RequestParam(value="ids", required = true) Set<Long> ids) {
		return service.buscarPessoaJuridicaBasicoDtoPorId(ids);
	}
}
