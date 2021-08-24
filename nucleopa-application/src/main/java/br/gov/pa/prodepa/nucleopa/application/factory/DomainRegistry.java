package br.gov.pa.prodepa.nucleopa.application.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.gov.pa.prodepa.nucleopa.domain.port.EstadoRepository;
import br.gov.pa.prodepa.nucleopa.domain.port.MunicipioRepository;
import br.gov.pa.prodepa.nucleopa.domain.port.OrgaoRepository;
import br.gov.pa.prodepa.nucleopa.domain.port.PessoaFisicaRepository;
import br.gov.pa.prodepa.nucleopa.domain.port.PessoaJuridicaRepository;
import br.gov.pa.prodepa.nucleopa.domain.port.ValidationUtils;
import br.gov.pa.prodepa.nucleopa.domain.service.EstadoDomainService;
import br.gov.pa.prodepa.nucleopa.domain.service.EstadoService;
import br.gov.pa.prodepa.nucleopa.domain.service.MunicipioDomainService;
import br.gov.pa.prodepa.nucleopa.domain.service.MunicipioService;
import br.gov.pa.prodepa.nucleopa.domain.service.OrgaoDomainService;
import br.gov.pa.prodepa.nucleopa.domain.service.OrgaoService;
import br.gov.pa.prodepa.nucleopa.domain.service.PessoaFisicaDomainService;
import br.gov.pa.prodepa.nucleopa.domain.service.PessoaFisicaService;
import br.gov.pa.prodepa.nucleopa.domain.service.PessoaJuridicaDomainService;
import br.gov.pa.prodepa.nucleopa.domain.service.PessoaJuridicaService;

@Configuration
public class DomainRegistry {

	@Autowired
	private ApplicationContext context;
	
	@Bean
	public PessoaFisicaService createPessoaFisicaService() {
		return new PessoaFisicaDomainService(
				context.getBean(PessoaFisicaRepository.class),
				context.getBean(ValidationUtils.class),
				context.getBean(EstadoRepository.class),
				context.getBean(MunicipioRepository.class)
			);
	}
	
	@Bean
	public PessoaJuridicaService createPessoaJuridicaService() {
		return new PessoaJuridicaDomainService(context.getBean(PessoaJuridicaRepository.class));
	}
	
	@Bean
	public OrgaoService createOrgaoService() {
		return new OrgaoDomainService(context.getBean(OrgaoRepository.class));
	}
	
	@Bean
	public MunicipioService createMunicipioService() {
		return new MunicipioDomainService(context.getBean(MunicipioRepository.class));
	}
	
	@Bean
	public EstadoService createEstadoService() {
		return new EstadoDomainService(context.getBean(EstadoRepository.class));
	}
}
