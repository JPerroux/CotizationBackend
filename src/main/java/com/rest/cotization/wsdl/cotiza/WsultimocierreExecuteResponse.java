
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
 *         &lt;element name="Salida" type="{Cotiza}wsultimocierreout"/&gt;
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
@XmlRootElement(name = "wsultimocierre.ExecuteResponse")
public class WsultimocierreExecuteResponse {

    @XmlElement(name = "Salida", required = true)
    protected Wsultimocierreout salida;

    /**
     * Gets the value of the salida property.
     * 
     * @return
     *     possible object is
     *     {@link Wsultimocierreout }
     *     
     */
    public Wsultimocierreout getSalida() {
        return salida;
    }

    /**
     * Sets the value of the salida property.
     * 
     * @param value
     *     allowed object is
     *     {@link Wsultimocierreout }
     *     
     */
    public void setSalida(Wsultimocierreout value) {
        this.salida = value;
    }

}
