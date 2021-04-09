package br.gov.pa.prodepa.nucleopa.jpa.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaFisicaBasicDto;
import br.gov.pa.prodepa.nucleopa.jpa.entity.PessoaFisica;

@Repository
public interface PessoaFisicaJpaRepository extends JpaRepository<PessoaFisica, Long>{

	@Query(" select new br.gov.pa.prodepa.nucleopa.domain.dto.PessoaFisicaBasicDto(p.id, p.nome) "
			+ " from PessoaFisica pf "
			+ " join pf.pessoa p "
			+ " where p.id in(:ids) ")
	List<PessoaFisicaBasicDto> buscarPessoaFisicaBasicoDtoPorIds(@Param("ids") Set<Long> ids);

}
