//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.10.28 a las 06:30:39 PM CDT 
//


package com.pr.gfce.exchange.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PrimarySimbol" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SecundarySimbol" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "primarySimbol",
    "secundarySimbol"
})
@XmlRootElement(name = "CurrenciRequest")
public class CurrenciRequest {

    @XmlElement(name = "PrimarySimbol", required = true)
    protected String primarySimbol;
    @XmlElement(name = "SecundarySimbol", required = true)
    protected String secundarySimbol;

    /**
     * Obtiene el valor de la propiedad primarySimbol.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimarySimbol() {
        return primarySimbol;
    }

    /**
     * Define el valor de la propiedad primarySimbol.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimarySimbol(String value) {
        this.primarySimbol = value;
    }

    /**
     * Obtiene el valor de la propiedad secundarySimbol.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecundarySimbol() {
        return secundarySimbol;
    }

    /**
     * Define el valor de la propiedad secundarySimbol.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecundarySimbol(String value) {
        this.secundarySimbol = value;
    }

}
