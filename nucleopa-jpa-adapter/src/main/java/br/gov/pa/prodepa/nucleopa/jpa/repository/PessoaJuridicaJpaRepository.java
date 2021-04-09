package br.gov.pa.prodepa.nucleopa.jpa.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaJuridicaBasicDto;
import br.gov.pa.prodepa.nucleopa.jpa.entity.PessoaJuridica;

@Repository
public interface PessoaJuridicaJpaRepository extends JpaRepository<PessoaJuridica, Long>{

	@Query(" select new br.gov.pa.prodepa.nucleopa.domain.dto.PessoaJuridicaBasicDto(p.id, p.nome) "
			+ " from PessoaJuridica pj "
			+ " join pj.pessoa p "
			+ " where p.id in(:ids) ")
	List<PessoaJuridicaBasicDto> buscarPessoaJuridicaBasicoDtoPorIds(@Param("ids") Set<Long> ids);

}
