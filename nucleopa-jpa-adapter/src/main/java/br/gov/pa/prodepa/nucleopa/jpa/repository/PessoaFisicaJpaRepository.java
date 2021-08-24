package br.gov.pa.prodepa.nucleopa.jpa.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaFisicaBasicDto;
import br.gov.pa.prodepa.nucleopa.jpa.entity.PessoaFisicaEntity;

@Repository
public interface PessoaFisicaJpaRepository extends JpaRepository<PessoaFisicaEntity, Long>{

	@Query("select p.id as id , p.nome as nome, pf.cpf as cpf "
			+ " from PessoaFisicaEntity pf "
			+ " join pf.pessoa p "
			+ " where p.id in(:ids) "
			+ " order by p.id ")
	List<PessoaFisicaBasicDto> buscarPessoaFisicaBasicoDtoPorIds(@Param("ids") Set<Long> ids);

	Long countByIdNotAndCpf(Long id, String cpf);

}
