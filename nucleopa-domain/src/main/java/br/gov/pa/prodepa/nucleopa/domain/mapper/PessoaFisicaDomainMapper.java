package br.gov.pa.prodepa.nucleopa.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaFisicaRequestDto;
import br.gov.pa.prodepa.nucleopa.domain.model.PessoaFisica;

@Mapper
public interface PessoaFisicaDomainMapper {

	PessoaFisicaDomainMapper INSTANCE = Mappers.getMapper( PessoaFisicaDomainMapper.class );
	
	PessoaFisica map(PessoaFisicaRequestDto dto);
}
