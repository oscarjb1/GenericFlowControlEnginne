/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pr.gfce.config;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 * <p>Clase Java para anonymous complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="Converter">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="outputVar" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RestCall">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="method" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="input" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="output" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="outputVar" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Response">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="responseVar" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="discriminator" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="complexDiscriminatorClass" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="cannonicalConverterClass" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="flowClass" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="inputType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"converterOrRestCallOrResponse"})
public class FlowControl {

    @XmlElements(value = {
        @XmlElement(name = "Converter", type = Converter.class)
        , @XmlElement(name = "RestCall", type = RestCall.class)
        , @XmlElement(name = "Response", type = Response.class)})
    protected List<Object> converterOrRestCallOrResponse;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "discriminator")
    protected String discriminator;
    @XmlAttribute(name = "complexDiscriminatorClass")
    protected String complexDiscriminatorClass;
    @XmlAttribute(name = "cannonicalConverterClass")
    protected String cannonicalConverterClass;
    @XmlAttribute(name = "flowClass")
    protected String flowClass;
    @XmlAttribute(name = "inputType")
    protected String inputType;

    /**
     * Gets the value of the converterOrRestCallOrResponse property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the converterOrRestCallOrResponse property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConverterOrRestCallOrResponse().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FlowControls.FlowControl.Converter }
     * {@link FlowControls.FlowControl.RestCall }
     * {@link FlowControls.FlowControl.Response }
     *
     *
     */
    public List<Object> getConverterOrRestCallOrResponse() {
        if (converterOrRestCallOrResponse == null) {
            converterOrRestCallOrResponse = new ArrayList<Object>();
        }
        return this.converterOrRestCallOrResponse;
    }

    /**
     * Obtiene el valor de la propiedad name.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad discriminator.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDiscriminator() {
        return discriminator;
    }

    /**
     * Define el valor de la propiedad discriminator.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDiscriminator(String value) {
        this.discriminator = value;
    }

    /**
     * Obtiene el valor de la propiedad complexDiscriminatorClass.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getComplexDiscriminatorClass() {
        return complexDiscriminatorClass;
    }

    /**
     * Define el valor de la propiedad complexDiscriminatorClass.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setComplexDiscriminatorClass(String value) {
        this.complexDiscriminatorClass = value;
    }

    /**
     * Obtiene el valor de la propiedad cannonicalConverterClass.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCannonicalConverterClass() {
        return cannonicalConverterClass;
    }

    /**
     * Define el valor de la propiedad cannonicalConverterClass.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCannonicalConverterClass(String value) {
        this.cannonicalConverterClass = value;
    }

    /**
     * Obtiene el valor de la propiedad flowClass.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFlowClass() {
        return flowClass;
    }

    /**
     * Define el valor de la propiedad flowClass.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFlowClass(String value) {
        this.flowClass = value;
    }

    /**
     * Obtiene el valor de la propiedad inputType.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInputType() {
        return inputType;
    }

    /**
     * Define el valor de la propiedad inputType.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInputType(String value) {
        this.inputType = value;
    }



    
}
