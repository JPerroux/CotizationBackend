package com.rest.cotization;

//import java.time.LocalDate;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.rest.cotization.dtos.DataCotizationInDTO;
import com.rest.cotization.service.CotizationService;

@SpringBootApplication
public class CotizationApplication implements CommandLineRunner {

	@Autowired
	CotizationService cotizationService;
	
	//private static Logger logger = LoggerFactory.getLogger(CotizationApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CotizationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		logger.info("Todos");
		cotizationService.getNombreMonedas(0).forEach(moneda -> {logger.info("codigo: "+ moneda.getCodigo()+ " name: "+ moneda.getNombre()); });
		
		logger.info("Internacionales");
		cotizationService.getNombreMonedas(1).forEach(moneda -> {logger.info("codigo: "+ moneda.getCodigo()+ " name: "+ moneda.getNombre()); });
		
		logger.info("Locales");
		cotizationService.getNombreMonedas(2).forEach(moneda -> {logger.info("codigo: "+ moneda.getCodigo()+ " name: "+ moneda.getNombre()); });
		
		
		
		String res = cotizationService.getUltimoCierre();
		logger.info("fecha: " + res);*/
		/*
		DataCotizationInDTO entrada = new DataCotizationInDTO();		
		entrada.setFechaDesde("2021-05-28");
		entrada.setFechaHasta("2021-05-28");
		entrada.setGrupo(0);
		short[] monedas =  {(short)9700, (short)9800, (short)9900};
		entrada.setMonedas(monedas);
		
		cotizationService.getCotization(entrada).forEach(data -> {logger.info("nombre: "+data.getNombre()+ "cotizacion: "+data.getTcc());});
		
		*/
		/*
		String fecha1 = "2021-05-28";
		String fecha2 = "2021-05-28";

		LocalDate inicio = LocalDate.parse(fecha1);
		LocalDate fin = LocalDate.parse(fecha2);
		
		System.out.println(inicio.isEqual(fin));*/
	}

}
