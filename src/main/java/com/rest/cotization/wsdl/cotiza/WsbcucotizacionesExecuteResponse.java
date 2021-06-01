
package com.rest.cotization.wsdl.cotiza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Salida" type="{Cotiza}wsbcucotizacionesout"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "salida"
})
@XmlRootElement(name = "wsbcucotizaciones.ExecuteResponse")
public class WsbcucotizacionesExecuteResponse {

    @XmlElement(name = "Salida", required = true)
    protected Wsbcucotizacionesout salida;

    /**
     * Gets the value of the salida property.
     * 
     * @return
     *     possible object is
     *     {@link Wsbcucotizacionesout }
     *     
     */
    public Wsbcucotizacionesout getSalida() {
        return salida;
    }

    /**
     * Sets the value of the salida property.
     * 
     * @param value
     *     allowed object is
     *     {@link Wsbcucotizacionesout }
     *     
     */
    public void setSalida(Wsbcucotizacionesout value) {
        this.salida = value;
    }

}
