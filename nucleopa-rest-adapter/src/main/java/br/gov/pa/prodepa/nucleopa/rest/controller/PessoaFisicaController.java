package br.gov.pa.prodepa.nucleopa.rest.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaFisicaBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.service.PessoaFisicaService;

@RestController
@RequestMapping("/pessoas-fisicas")
public class PessoaFisicaController {

	private final PessoaFisicaService service;
	
	@Autowired
	public PessoaFisicaController(PessoaFisicaService service) {
		super();
		this.service = service;
	}

	@GetMapping()
	public String teste() {
		return "teste";
	}
	
	@GetMapping("/formato-basico")
	public List<PessoaFisicaBasicDto> buscarPessoaFisicaBasicoDtoPorId(@RequestParam(value="ids", required = true) Set<Long> ids) {
		return service.buscarPessoaFisicaBasicoDtoPorId(ids);
	}
}
