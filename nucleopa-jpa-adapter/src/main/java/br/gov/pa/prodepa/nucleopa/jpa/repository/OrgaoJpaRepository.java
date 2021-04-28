package br.gov.pa.prodepa.nucleopa.jpa.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.prodepa.nucleopa.domain.dto.OrgaoBasicDto;
import br.gov.pa.prodepa.nucleopa.jpa.entity.Orgao;

@Repository
public interface OrgaoJpaRepository extends JpaRepository<Orgao, Long>{

	@Query(" select new br.gov.pa.prodepa.nucleopa.domain.dto.OrgaoBasicDto(p.id, p.nome, o.sigla) "
			+ " from Orgao o "
			+ " join o.pessoaJuridica pj "
			+ " join pj.pessoa p "
			+ " where p.id in (:ids) "
			+ " and p.ehOrgao = true "
			+ " order by o.sigla ")
	List<OrgaoBasicDto> buscarOrgaoBasicoDtoPorIds(Set<Long> ids);

	@Query(" select new br.gov.pa.prodepa.nucleopa.domain.dto.OrgaoBasicDto(p.id, p.nome, o.sigla) "
			+ " from Orgao o "
			+ " join o.pessoaJuridica pj "
			+ " join pj.pessoa p "
			+ " where o.ativo = true "
			+ " and   p.ehOrgao = true"
			+ " order by o.sigla ")
	List<OrgaoBasicDto> buscarOrgaoTodosOrgaosAtivos();

}
