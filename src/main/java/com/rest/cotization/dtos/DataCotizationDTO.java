package com.rest.cotization.dtos;

import java.time.LocalDate;

import javax.xml.datatype.XMLGregorianCalendar;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataCotizationDTO {
	
	private LocalDate fecha;
	private short moneda;
	private String nombre; 	
	private String codigoISO;
	private String emisor;
	private double tcc;
	private double tcv;
	private double arbact;
	private byte formaArbitrar;
	
	public DataCotizationDTO(XMLGregorianCalendar fecha, short moneda, String nombre, String codigoISO, String emisor,
			double tcc, double tcv, double arbact, byte formaArbitrar) {
		this.fecha = LocalDate.of(fecha.getYear(), fecha.getMonth(), fecha.getDay());
		this.moneda = moneda;
		this.nombre = nombre;
		this.codigoISO = codigoISO;
		this.emisor = emisor;
		this.tcc = tcc;
		this.tcv = tcv;
		this.arbact = arbact;
		this.formaArbitrar = formaArbitrar;
	}
}