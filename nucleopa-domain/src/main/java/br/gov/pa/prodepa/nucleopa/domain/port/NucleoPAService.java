package br.gov.pa.prodepa.nucleopa.domain.port;

import java.util.List;
import java.util.Map;

public interface NucleoPAService {

	List<Map<String, String>> buscarTodosOsrgaosAtivos();

}
