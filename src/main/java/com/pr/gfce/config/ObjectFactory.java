//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.10.28 a las 05:55:41 PM CDT 
//


package com.pr.gfce.config;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FlowControls }
     * 
     */
    public FlowControls createFlowControls() {
        return new FlowControls();
    }

    /**
     * Create an instance of {@link FlowControls.FlowControl }
     * 
     */
    public FlowControl createFlowControlsFlowControl() {
        return new FlowControl();
    }

    /**
     * Create an instance of {@link FlowControls.FlowControl.Converter }
     * 
     */
    public Converter createFlowControlsFlowControlConverter() {
        return new Converter();
    }

    /**
     * Create an instance of {@link FlowControls.FlowControl.RestCall }
     * 
     */
    public RestCall createFlowControlsFlowControlRestCall() {
        return new RestCall();
    }
    
    public Step createFlowControlsFlowControlStep() {
        return new Step();
    }

    /**
     * Create an instance of {@link FlowControls.FlowControl.Response }
     * 
     */
    public Response createFlowControlsFlowControlResponse() {
        return new Response();
    }

}
