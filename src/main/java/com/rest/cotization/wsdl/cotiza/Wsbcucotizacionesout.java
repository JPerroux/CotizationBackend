
package com.rest.cotization.wsdl.cotiza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsbcucotizacionesout complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsbcucotizacionesout"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="respuestastatus" type="{Cotiza}respuestastatus"/&gt;
 *         &lt;element name="datoscotizaciones" type="{Cotiza}datoscotizaciones"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsbcucotizacionesout", propOrder = {
    "respuestastatus",
    "datoscotizaciones"
})
public class Wsbcucotizacionesout {

    @XmlElement(required = true)
    protected Respuestastatus respuestastatus;
    @XmlElement(required = true)
    protected Datoscotizaciones datoscotizaciones;

    /**
     * Gets the value of the respuestastatus property.
     * 
     * @return
     *     possible object is
     *     {@link Respuestastatus }
     *     
     */
    public Respuestastatus getRespuestastatus() {
        return respuestastatus;
    }

    /**
     * Sets the value of the respuestastatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Respuestastatus }
     *     
     */
    public void setRespuestastatus(Respuestastatus value) {
        this.respuestastatus = value;
    }

    /**
     * Gets the value of the datoscotizaciones property.
     * 
     * @return
     *     possible object is
     *     {@link Datoscotizaciones }
     *     
     */
    public Datoscotizaciones getDatoscotizaciones() {
        return datoscotizaciones;
    }

    /**
     * Sets the value of the datoscotizaciones property.
     * 
     * @param value
     *     allowed object is
     *     {@link Datoscotizaciones }
     *     
     */
    public void setDatoscotizaciones(Datoscotizaciones value) {
        this.datoscotizaciones = value;
    }

}
