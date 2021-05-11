package br.gov.pa.prodepa.nucleopa.domain.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaPaginaDto<T> {

	private int totalPages;
	private int totalElements;
	private int currentPage;
	private List<T> content;
	
	public ConsultaPaginaDto() {
	}
	
	public ConsultaPaginaDto(int totalPages, int totalElements, int currentPage, List<T> content) {
		super();
		this.totalPages = totalPages;
		this.totalElements = totalElements;
		this.content = content;
		this.currentPage = currentPage;
	}
	
}