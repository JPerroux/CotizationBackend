
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
 *         &lt;element name="Entrada" type="{Cotiza}wsmonedasin"/&gt;
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
    "entrada"
})
@XmlRootElement(name = "wsbcumonedas.Execute")
public class WsbcumonedasExecute {

    @XmlElement(name = "Entrada", required = true)
    protected Wsmonedasin entrada;

    /**
     * Gets the value of the entrada property.
     * 
     * @return
     *     possible object is
     *     {@link Wsmonedasin }
     *     
     */
    public Wsmonedasin getEntrada() {
        return entrada;
    }

    /**
     * Sets the value of the entrada property.
     * 
     * @param value
     *     allowed object is
     *     {@link Wsmonedasin }
     *     
     */
    public void setEntrada(Wsmonedasin value) {
        this.entrada = value;
    }

}
