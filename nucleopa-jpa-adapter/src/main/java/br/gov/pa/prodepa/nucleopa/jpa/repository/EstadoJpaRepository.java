package br.gov.pa.prodepa.nucleopa.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.pa.prodepa.nucleopa.domain.dto.EstadoBasicDto;
import br.gov.pa.prodepa.nucleopa.jpa.entity.EstadoEntity;

@Repository
public interface EstadoJpaRepository extends JpaRepository<EstadoEntity, Long> {

	@Query(" select new br.gov.pa.prodepa.nucleopa.domain.dto.EstadoBasicDto(e.id, e.descricao, e.uf, e.codigoIbge) "
			+ " from EstadoEntity e "
			+ " order by e.descricao ")
	List<EstadoBasicDto> buscarTodosEstados();

}
