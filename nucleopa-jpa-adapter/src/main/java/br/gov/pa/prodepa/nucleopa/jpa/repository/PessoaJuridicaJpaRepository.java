package br.gov.pa.prodepa.nucleopa.jpa.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaJuridicaBasicDto;
import br.gov.pa.prodepa.nucleopa.jpa.entity.PessoaJuridica;

@Repository
public interface PessoaJuridicaJpaRepository extends JpaRepository<PessoaJuridica, Long>{

	@Query(" select p.id as id, pj.nomeFantasia as nome, pj.cnpj as cnpj "
			+ " from PessoaJuridica pj "
			+ " join pj.pessoa p "
			+ " where p.id in(:ids) ")
	List<PessoaJuridicaBasicDto> buscarPessoaJuridicaBasicoDtoPorIds(@Param("ids") Set<Long> ids);

	@Query(value="select p.id as id, pj.nome_fantasia as nome, pj.cnpj as cnpj "
			+ "from nucleopa.pessoa p "
			+ "inner join nucleopa.pessoa_juridica pj on pj.id = p.id "
			+ "where (cast(:nome as text) is null or pj.nome_fantasia_fonetico like public.fc_fon_fonetizar(cast(:nome as text)) || '%' ) "
			+ "and   (cast(:cnpj as text) is null or pj.cnpj = cast(:cnpj as text)) "
			+ "order by pj.nome_fantasia ",
			nativeQuery = true)
	Page<PessoaJuridicaBasicDto> buscarPessoaJuridicaBasicoDtoPorNomeOuCpf(@Param("nome") String nome, @Param("cnpj") String cnpj, Pageable page);

}
