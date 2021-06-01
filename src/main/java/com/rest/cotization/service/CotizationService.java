package com.rest.cotization.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rest.cotization.CotizationApplication;
import com.rest.cotization.dtos.DataCotizationDTO;
import com.rest.cotization.dtos.DataCotizationInDTO;
import com.rest.cotization.dtos.MonedaDTO;
import com.rest.cotization.wsdl.cotiza.ArrayOfint;
import com.rest.cotization.wsdl.cotiza.Datoscotizaciones;
import com.rest.cotization.wsdl.cotiza.DatoscotizacionesDato;
import com.rest.cotization.wsdl.cotiza.Wsbcucotizaciones;
import com.rest.cotization.wsdl.cotiza.WsbcucotizacionesExecute;
import com.rest.cotization.wsdl.cotiza.WsbcucotizacionesExecuteResponse;
import com.rest.cotization.wsdl.cotiza.WsbcucotizacionesSoapPort;
import com.rest.cotization.wsdl.cotiza.Wsbcucotizacionesin;
import com.rest.cotization.wsdl.cotiza.Wsbcucotizacionesout;
import com.rest.cotization.wsdl.cotiza.Wsbcumonedas;
import com.rest.cotization.wsdl.cotiza.WsbcumonedasExecute;
import com.rest.cotization.wsdl.cotiza.WsbcumonedasExecuteResponse;
import com.rest.cotization.wsdl.cotiza.WsbcumonedasSoapPort;
import com.rest.cotization.wsdl.cotiza.Wsmonedasin;
import com.rest.cotization.wsdl.cotiza.Wsmonedasout;
import com.rest.cotization.wsdl.cotiza.WsmonedasoutLinea;
import com.rest.cotization.wsdl.cotiza.Wsultimocierre;
import com.rest.cotization.wsdl.cotiza.WsultimocierreExecuteResponse;
import com.rest.cotization.wsdl.cotiza.WsultimocierreSoapPort;
import com.rest.cotization.wsdl.cotiza.Wsultimocierreout;

@Service
public class CotizationService {

	Logger logger = LoggerFactory.getLogger(CotizationApplication.class);
	boolean valid = true;

	// Regresa fecha de ultimo cierre
	public String getUltimoCierre() throws Exception {
		try {
			Wsultimocierre cierre = new Wsultimocierre();
			WsultimocierreSoapPort port = cierre.getWsultimocierreSoapPort();
			WsultimocierreExecuteResponse resp = port.execute(null);
			Wsultimocierreout out = resp.getSalida();
			return out.getFecha().toString();
		} catch (Exception e) {
			logger.error("Ocurrio un error: ", e);
			throw e;
		}
	}

	// Regresa el codigo y el nombre se las monedas,
	// como dato de entrada requiere el grupo 1-mercado internacional
	// 2-mercado local, 0-ambos
	public List<MonedaDTO> getNombreMonedas(int grupo) throws Exception {

		List<MonedaDTO> res = new ArrayList<MonedaDTO>();
		Wsbcumonedas monedas = new Wsbcumonedas();
		WsbcumonedasSoapPort port = monedas.getWsbcumonedasSoapPort();

		try {

			Wsmonedasin in = new Wsmonedasin();
			in.setGrupo((byte) grupo);

			WsbcumonedasExecute param = new WsbcumonedasExecute();
			param.setEntrada(in);

			WsbcumonedasExecuteResponse resp = port.execute(param);
			Wsmonedasout out = resp.getSalida();

			List<WsmonedasoutLinea> list = out.getWsmonedasoutLinea();
			list.forEach(moneda -> res.add(new MonedaDTO(moneda.getCodigo(), moneda.getNombre())));

		} catch (Exception e) {
			throw e;
		}
		return res;
	}

	// Regresa la cotizacion de la moneda elegida en determinada fecha e informacion
	// adicional
	public List<DataCotizationDTO> getCotization(DataCotizationInDTO data) throws Exception {
		List<DataCotizationDTO> res = new ArrayList<DataCotizationDTO>();

		if (validateDataIn(data).equals(""))
			valid = true;
		else {
			Exception e = new Exception(validateDataIn(data));
			throw e;
		}

		if (valid) {

			try {

				XMLGregorianCalendar inicio = dateConvert(data.getFechaDesde());
				XMLGregorianCalendar fin = dateConvert(data.getFechaHasta());

				Wsbcucotizaciones cotizaciones = new Wsbcucotizaciones();
				WsbcucotizacionesSoapPort port = cotizaciones.getWsbcucotizacionesSoapPort();

				Wsbcucotizacionesin entrada = new Wsbcucotizacionesin();
				entrada.setGrupo((byte) data.getGrupo());
				entrada.setFechaDesde(inicio);
				entrada.setFechaHasta(fin);

				ArrayOfint array = new ArrayOfint();
				for (short moneda : data.getMonedas()) {
					array.getItem().add(moneda);
				}
				entrada.setMoneda(array);

				WsbcucotizacionesExecute param = new WsbcucotizacionesExecute();
				param.setEntrada(entrada);

				WsbcucotizacionesExecuteResponse response = port.execute(param);
				Wsbcucotizacionesout out = response.getSalida();

				if (out != null) {
					Datoscotizaciones dataCot = out.getDatoscotizaciones();
					List<DatoscotizacionesDato> list = dataCot.getDatoscotizacionesDato();
					list.forEach(cts -> {
						res.add(new DataCotizationDTO(cts.getFecha(), cts.getMoneda(), cts.getNombre(),
								cts.getCodigoISO(), cts.getEmisor(), cts.getTCC(), cts.getTCV(), cts.getArbAct(),
								cts.getFormaArbitrar()));
					});
				}

			} catch (Exception e) {
				throw e;
			}
		}
		return res;
	}

	private XMLGregorianCalendar dateConvert(String date) {

		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date inputDate = dateFormat.parse(date);

			GregorianCalendar c = new GregorianCalendar();
			c.setTime(inputDate);

			XMLGregorianCalendar outputDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

			return outputDate;

		} catch (ParseException | DatatypeConfigurationException e) {
			logger.error("Error", e.getMessage());
			return null;
		}
	}

	private String validateDataIn(DataCotizationInDTO data) throws Exception {
		String res = "";

		if (validateGroup(data.getGrupo()).equals("")
				&& validateDate(data.getFechaDesde(), data.getFechaHasta()).equals("")) {
			validateCodes(data.getGrupo(), data.getMonedas());
			return res;
		} else if (!validateGroup(data.getGrupo()).equals("")) {
			res = validateGroup(data.getGrupo());
		} else if (!validateDate(data.getFechaDesde(), data.getFechaHasta()).equals("")) {
			res = validateDate(data.getFechaDesde(), data.getFechaHasta());
		}
		return res;
	}

	private String validateDate(String fechaInicio, String fechaFinal) {
		String res = "";
		try {
			if (fechaInicio.isBlank() || fechaFinal.isBlank())
				res = "Las fechas no pueden ser vacías";
			else {
				LocalDate inicio = LocalDate.parse(fechaInicio);
				LocalDate fin = LocalDate.parse(fechaFinal);
				if (inicio.isAfter(fin)) {
					res = "La fecha final no puede ser anterior a la inicial";
				} else if (ChronoUnit.DAYS.between(inicio, fin) > 31) {
					res = "El rango máximo entre fechas es de 31  días";
				}
			}
		} catch (Exception e) {
			res = "El formato de fechas es incorrecto";
		}
		return res;
	}

	private String validateGroup(int grupo) {
		String res = "";
		if (!(0 <= grupo && grupo < 2)) {
			res = "Error en el grupo ingresado, el código no es válido";
		}
		return res;
	}

	private void validateCodes(int grupo, List<Short> monedas) throws Exception {
		List<Short> monedasHabilitadas = new ArrayList<Short>();

		try {
			getNombreMonedas(grupo).forEach(data -> monedasHabilitadas.add(data.getCodigo()));
			for (var moneda : monedas) {
				if (!monedasHabilitadas.contains(moneda))
					logger.warn("La moneda de código: " + moneda + " no existe o no pertenece al grupo seleccionado");
			}

		} catch (Exception e) {
			throw e;
		}
	}
}