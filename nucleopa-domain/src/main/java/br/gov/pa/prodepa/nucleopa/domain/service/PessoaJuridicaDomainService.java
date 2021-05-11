package br.gov.pa.prodepa.nucleopa.domain.service;

import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;

import br.gov.pa.prodepa.nucleopa.domain.dto.ConsultaPaginaDto;
import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaJuridicaBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.port.PessoaJuridicaRepository;
import br.gov.pa.prodepa.pae.common.domain.exception.DomainException;

public class PessoaJuridicaDomainService implements PessoaJuridicaService {

	private final PessoaJuridicaRepository repository;
	
	public PessoaJuridicaDomainService(PessoaJuridicaRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public ConsultaPaginaDto<PessoaJuridicaBasicDto> buscarPessoaJuridicaBasicoDtoPorNomeOuCnpj(String nome, String cnpj, int pageNumber, int pageSize) {
		
		if( (nome == null || nome.trim().length() == 0) &&
				(cnpj == null || cnpj.trim().length() == 0)) {
			throw new DomainException("Informe o nome e/ou o cpf.");
		}
		
		if(cnpj != null && cnpj.length() != 14) {
			throw new DomainException("O cnpj deve conter 14 digitos");
		}
		
		if(nome != null && nome.length() < 3) {
			throw new DomainException("O nome deve conter no mínimo 3 letras");
		}
		
		return repository.buscarPessoaJuridicaBasicoDtoPorNomeOuCpf(nome, cnpj, pageNumber, pageSize);
	}
	
	@Override
	public List<PessoaJuridicaBasicDto> buscarPessoaJuridicaBasicoDtoPorId(Set<Long> ids) {
		List<PessoaJuridicaBasicDto> list = repository.buscarPessoaJuridicaBasicoDtoPorIds(ids);
		checkIfAllExists(ids, list, (e,id) -> e.getId().equals(id));
		return list;
	}
	
	private <T> void checkIfAllExists(Set<Long> ids, List<T> list, BiPredicate<T, Long> predicate) {
		DomainException de = new DomainException();
		
		ids.stream().forEach( id -> {
			boolean anyMatch = list.stream().anyMatch(e -> predicate.test(e, id));
			if(!anyMatch) {
				System.out.println("Nenhuma pessoa juridica com o id " + id + " foi encontrada.");
				de.addError("Nenhuma pessoa juridica com o id " + id + " foi encontrada.");
			}
		});
		
		de.throwException();
	}
}
