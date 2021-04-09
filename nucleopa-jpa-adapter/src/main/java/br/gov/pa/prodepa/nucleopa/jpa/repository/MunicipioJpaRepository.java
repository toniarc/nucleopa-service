package br.gov.pa.prodepa.nucleopa.jpa.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.gov.pa.prodepa.nucleopa.domain.dto.MunicipioBasicDto;
import br.gov.pa.prodepa.nucleopa.jpa.entity.Municipio;

@Repository
public interface MunicipioJpaRepository extends JpaRepository<Municipio, Long>{

	@Query(" select new br.gov.pa.prodepa.nucleopa.domain.dto.MunicipioBasicDto(m.id, m.descricao, m.codigoIbge, e.id, e.descricao, e.uf, e.codigoIbge) "
			+ " from Municipio m "
			+ " join m.estado e "
			+ " where m.id in (:ids) ")
	List<MunicipioBasicDto> buscarMunicipioBasicoDtoPorIds(@Param("ids") Set<Long> ids);

}
