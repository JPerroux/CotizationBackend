
package com.rest.cotization.wsdl.cotiza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for wsbcucotizacionesin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsbcucotizacionesin"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Moneda" type="{Cotiza}ArrayOfint"/&gt;
 *         &lt;element name="FechaDesde" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="FechaHasta" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
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
@XmlType(name = "wsbcucotizacionesin", propOrder = {
    "moneda",
    "fechaDesde",
    "fechaHasta",
    "grupo"
})
public class Wsbcucotizacionesin {

    @XmlElement(name = "Moneda", required = true)
    protected ArrayOfint moneda;
    @XmlElement(name = "FechaDesde", required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaDesde;
    @XmlElement(name = "FechaHasta", required = true, nillable = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaHasta;
    @XmlElement(name = "Grupo")
    protected byte grupo;

    /**
     * Gets the value of the moneda property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfint }
     *     
     */
    public ArrayOfint getMoneda() {
        return moneda;
    }

    /**
     * Sets the value of the moneda property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfint }
     *     
     */
    public void setMoneda(ArrayOfint value) {
        this.moneda = value;
    }

    /**
     * Gets the value of the fechaDesde property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaDesde() {
        return fechaDesde;
    }

    /**
     * Sets the value of the fechaDesde property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaDesde(XMLGregorianCalendar value) {
        this.fechaDesde = value;
    }

    /**
     * Gets the value of the fechaHasta property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHasta() {
        return fechaHasta;
    }

    /**
     * Sets the value of the fechaHasta property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHasta(XMLGregorianCalendar value) {
        this.fechaHasta = value;
    }

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
