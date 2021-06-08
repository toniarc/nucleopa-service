package br.gov.pa.prodepa.nucleopa.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.gov.pa.prodepa.nucleopa.domain.dto.EstadoBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.dto.MunicipioBasicDto;
import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaFisicaRequestDto;
import br.gov.pa.prodepa.nucleopa.domain.port.EstadoRepository;
import br.gov.pa.prodepa.nucleopa.domain.port.MunicipioRepository;
import br.gov.pa.prodepa.nucleopa.domain.port.PessoaFisicaRepository;
import br.gov.pa.prodepa.nucleopa.domain.port.ValidationUtils;
import br.gov.pa.prodepa.pae.common.domain.exception.DomainException;

public class PessoaFisicaValidator {

	private final PessoaFisicaRequestDto dto;

	private DomainException de = new DomainException();

	private final PessoaFisicaRepository repository;

	private final ValidationUtils validationUtils;
	
	public PessoaFisicaValidator(PessoaFisicaRequestDto dto, PessoaFisicaRepository repository, ValidationUtils validationUtils) {
		this.dto = dto;
		this.repository = repository;
		this.validationUtils = validationUtils;
	}

	public static PessoaFisicaValidator getInstance(PessoaFisicaRequestDto dto, PessoaFisicaRepository repository, ValidationUtils validationUtils) {
		return new PessoaFisicaValidator(dto, repository, validationUtils);
	}

	public PessoaFisicaValidator validarCamposObrigatorios() {
		
		if(dto.getAplicacaoManutencaoPessoaId() == null){
			de.addError("Campo 'idAplicacaoManutencao' deve ser informado.");
		}
		
		if(dto.getSexo() == null){
			de.addError("Campo 'Sexo' deve ser informado.");
		}
		
		// Nome
		if (dto.getNome() != null && dto.getNome().trim().length() == 0) {
			de.addError("Campo 'Nome' deve ser informado.");
		}
		
		// CPF
		if (dto.getCpf() != null && dto.getCpf().trim().length() == 0) {
			de.addError("Campo 'CPF' deve ser informado.");
		} 
		
		return this;
	}

	public PessoaFisicaValidator validar() {
		de.throwException();
		return this;
	}

	public PessoaFisicaValidator validarSeCpfJaEstaCadastrado() {
		if (dto.getCpf() != null && repository.verificarSeCpfJaEstaCadastrado(dto.getId(), dto.getCpf())) {
			de.addError("Este CPF já está sendo utilizado.");
		}
		return this;
	}

	public PessoaFisicaValidator validarSeCpfEValido() {
		if(!validationUtils.ehCpfValido(dto.getCpf())) {
			de.addError("Cpf inválido.");
		}
		return this;
	}

	public PessoaFisicaValidator checarSeEstadoInformadoExiste(EstadoRepository estadoRepository) {
		EstadoBasicDto estado = estadoRepository.buscarPorId(dto.getEstadoId());
		if(estado == null || estado.getId() == null) {
			de.addError("O estado informado não existe.");
		}
		return this;
	}
	
	public PessoaFisicaValidator chacarSeMunicipioInformadoExiste(MunicipioRepository municipioRepository) {
		MunicipioBasicDto municipio = municipioRepository.buscarPorId(dto.getMunicipioId());
		if(municipio == null || municipio.getId() == null) {
			de.addError("O município informado não existe.");
		}
		return this;
	}

	public PessoaFisicaValidator validarFormatoTelefone() {
		if(dto.getTelefone() == null) {
			return this;
		}
		
		Pattern pattern = Pattern.compile("\\(\\d{2}\\)9[\\d]{8}");
		Matcher matcher = pattern.matcher(dto.getTelefone());
		if(!matcher.matches()) {
			de.addError("Formato de telefone inválido. (Ex: (91)999999999 )");
		}
		return this;
	}
	
	public PessoaFisicaValidator validarFormatoEmail() {
		
		if(dto.getEmail() == null) {
			return this;
		}
		
		Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
		Matcher matcher = pattern.matcher(dto.getEmail());
		if(!matcher.matches()) {
			de.addError("Formato de e-mail inválido. (Ex: teste@examplo.com)");
		}
		return this;
	}

	public PessoaFisicaValidator validarFormatoCep() {
		if(dto.getEnderecoCep() == null) {
			return this;
		}
		
		Pattern pattern = Pattern.compile("[\\d]{8}");
		Matcher matcher = pattern.matcher(dto.getEnderecoCep());
		if(!matcher.matches()) {
			de.addError("Formato de cep inválido. (Ex: 66000000)");
		}
		return this;
	}

}
