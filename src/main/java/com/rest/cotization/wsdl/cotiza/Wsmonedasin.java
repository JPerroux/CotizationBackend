
package com.rest.cotization.wsdl.cotiza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsmonedasin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsmonedasin"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Grupo" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsmonedasin", propOrder = {
    "grupo"
})
public class Wsmonedasin {

    @XmlElement(name = "Grupo")
    protected byte grupo;

    /**
     * Gets the value of the grupo property.
     * 
     */
    public byte getGrupo() {
        return grupo;
    }

    /**
     * Sets the value of the grupo property.
     * 
     */
    public void setGrupo(byte value) {
        this.grupo = value;
    }

}
