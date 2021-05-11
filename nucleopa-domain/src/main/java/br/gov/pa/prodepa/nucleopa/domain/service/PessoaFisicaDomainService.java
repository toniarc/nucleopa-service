package br.gov.pa.prodepa.nucleopa.domain.service;

import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;

import br.gov.pa.prodepa.nucleopa.domain.dto.ConsultaPaginaDto;
import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaFisicaBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.port.PessoaFisicaRepository;
import br.gov.pa.prodepa.pae.common.domain.exception.DomainException;


public class PessoaFisicaDomainService implements PessoaFisicaService {

	private final PessoaFisicaRepository repository;
	
	public PessoaFisicaDomainService(PessoaFisicaRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public ConsultaPaginaDto<PessoaFisicaBasicDto> buscarPessoaFisicaBasicoDtoPorNomeOuCpf(String nome, String cpf, int pageNumber, int pageSize) {
		
		if( (nome == null || nome.trim().length() == 0) &&
				(cpf == null || cpf.trim().length() == 0)) {
			throw new DomainException("Informe o nome e/ou o cpf.");
		}
		
		if(cpf != null && cpf.length() != 11) {
			throw new DomainException("O cpf deve conter 11 digitos");
		}
		
		if(nome != null && nome.length() < 3) {
			throw new DomainException("O nome deve conter no mínimo 3 letras");
		}
		
		return repository.buscarPessoaFisicaBasicoDtoPorNomeOuCpf(nome, cpf, pageNumber, pageSize);
	}
	
	public List<PessoaFisicaBasicDto> buscarPessoaFisicaBasicoDtoPorId(Set<Long> ids) {
		List<PessoaFisicaBasicDto> list = repository.buscarPessoaFisicaBasicoDtoPorIds(ids);
		checkIfAllExists(ids, list, (e,id) -> e.getId().equals(id));
		return list;
	}
	
	private <T> void checkIfAllExists(Set<Long> ids, List<T> list, BiPredicate<T, Long> predicate) {
		DomainException de = new DomainException();
		
		ids.stream().forEach( id -> {
			boolean anyMatch = list.stream().anyMatch(e -> predicate.test(e, id));
			if(!anyMatch) {
				de.addError("Nenhuma pessoa fisica com o id " + id + " foi encontrada.");
			}
		});
		
		de.throwException();
	}
}
