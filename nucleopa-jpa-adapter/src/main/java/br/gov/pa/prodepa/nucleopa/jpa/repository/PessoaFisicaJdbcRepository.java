package br.gov.pa.prodepa.nucleopa.jpa.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import br.gov.pa.prodepa.nucleopa.domain.dto.PessoaFisicaBasicDto;

@Component
public class PessoaFisicaJdbcRepository {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public List<PessoaFisicaBasicDto> buscarPessoaFisicaBasicoDtoPorNomeOuCpf(String nome, String  cpf, int pageNumber, int pageSize) {
		
		Map<String,Object> params = new HashMap<>();
		
		params.put("pageNumber", pageNumber * pageSize);
		params.put("pageSize", pageSize);
		
		params.put("nome", nome);
		params.put("cpf", cpf);
		
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValues(params);
		
		var sql = new StringBuilder();
		
		sql.append(" select p.id as id, p.nome as nome, pf.cpf as cpf ");
		sql.append(" from nucleopa.pessoa p ");
		sql.append(" inner join nucleopa.pessoa_fisica pf on pf.id = p.id ");
		sql.append(" where ");
		
		if(nome != null && !nome.isEmpty()) {
			sql.append("( :nome is null or p.nome_fonetico like public.fc_fon_fonetizar( cast(:nome as text) ) || '%' ) ");
		}
		
		if(cpf != null && !cpf.isEmpty()) {
			sql.append(" and ( :cpf is null or pf.cpf = cast(:cpf as text) ) ");
		}
		
		sql.append(" order by p.nome ");
		sql.append(" limit :pageSize offset :pageNumber");
		
		return namedParameterJdbcTemplate.query(
				  sql.toString(), namedParameters, (rs, rowNum) ->
					  PessoaFisicaBasicDto.builder()
					  	.id(rs.getLong(1))
					  	.nome(rs.getString(2))
					  	.cpf(rs.getString(3))
					  .build()
					);
	}
	
	public Long contarPessoaFisicaBasicoDtoPorNomeOuCpf(String nome, String  cpf) {
		
		Map<String,Object> params = new HashMap<>();
		params.put("nome", nome);
		params.put("cpf", cpf);
		
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValues(params);
		
		var sql = new StringBuilder();
		
		sql.append(" select count(*) ");
		sql.append(" from nucleopa.pessoa p ");
		sql.append(" inner join nucleopa.pessoa_fisica pf on pf.id = p.id ");
		sql.append(" where ");
		
		if(nome != null && !nome.isEmpty()) {
			sql.append("( :nome is null or p.nome_fonetico like public.fc_fon_fonetizar( cast(:nome as text) ) || '%' ) ");
		}
		
		if(cpf != null && !cpf.isEmpty()) {
			sql.append(" and ( :cpf is null or pf.cpf = cast(:cpf as text) ) ");
		}
		
		return namedParameterJdbcTemplate.queryForObject(
				  sql.toString(), namedParameters, (rs, rowNum) -> rs.getLong(1) );
	}
	
}
