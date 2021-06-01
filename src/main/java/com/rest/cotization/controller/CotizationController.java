package com.rest.cotization.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.cotization.dtos.DataCotizationDTO;
import com.rest.cotization.dtos.DataCotizationInDTO;
import com.rest.cotization.dtos.MonedaDTO;
import com.rest.cotization.service.CotizationService;
import com.rest.cotization.util.MessageDTO;

@RestController
@RequestMapping("/cotization")
@CrossOrigin
public class CotizationController {

	@Autowired
	CotizationService cotizationService;
	
	Logger logger = LoggerFactory.getLogger(CotizationController.class);
	
	@GetMapping("/cierre")
	public ResponseEntity<?> getUltimoCierre() {
		
		String res = "";
		try{
			res = cotizationService.getUltimoCierre();
			
		} catch(Exception e) {
			logger.error("Error al obtener fecha de cierre de las cotizaciones: " + e);
			return new ResponseEntity<MessageDTO>(new MessageDTO("Error al obtener fecha de cierre de las cotizaciones"), HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
	
	
	@GetMapping("/monedas/{grupo}")
	public ResponseEntity<?> getMonedas(@PathVariable("grupo") short grupo) {
		
		List<MonedaDTO> res = new ArrayList<MonedaDTO>();
		try {
			if (grupo >= 0 && grupo < 3)
				res = cotizationService.getNombreMonedas(grupo);
			else
				return new ResponseEntity<MessageDTO>(new MessageDTO("Codigo incorrecto"), HttpStatus.BAD_REQUEST);
			
		} catch(Exception e) {
			logger.error("Error al obtener las monedas de las que hay informacion: " + e);
			return new ResponseEntity<MessageDTO>(new MessageDTO("Error al obtener las monedas de las que hay informacion"), HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<List<MonedaDTO>>(res, HttpStatus.OK);
	}
	
	// Formato de la fecha yyyy-MM-dd, tipo de dato de grupo y codigo de moneda es short
	@PostMapping("cotizaciones")
	public ResponseEntity<?> getCotizaciones(@RequestBody DataCotizationInDTO monedas) {
		
		List<DataCotizationDTO> res = new ArrayList<DataCotizationDTO>();
		try {
			res = cotizationService.getCotization(monedas);
			
		}catch(Exception e) {
			logger.error("Error al obtener la cotizacion de las monedas: " + e);
			return new ResponseEntity<MessageDTO>(new MessageDTO("Error: " + e.getMessage()), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<DataCotizationDTO>>(res, HttpStatus.OK);
	}
}