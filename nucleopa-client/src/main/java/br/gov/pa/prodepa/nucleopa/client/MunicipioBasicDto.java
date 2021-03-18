package br.gov.pa.prodepa.nucleopa.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MunicipioBasicDto {
	private Long id;
	private String nome;
}
