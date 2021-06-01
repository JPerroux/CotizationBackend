package com.rest.cotization.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataCotizationInDTO {

	private List<Short> monedas;
	private String fechaDesde;
	private String fechaHasta;
	private int grupo;
}
