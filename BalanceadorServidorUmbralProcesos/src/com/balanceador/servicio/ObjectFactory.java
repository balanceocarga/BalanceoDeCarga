
package com.balanceador.servicio;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.balanceador.servicio package. 
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

    private final static QName _ActulizarEstadoServidor_QNAME = new QName("http://servicio.balanceador.com/", "actulizarEstadoServidor");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.balanceador.servicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ActulizarEstadoServidor }
     * 
     */
    public ActulizarEstadoServidor createActulizarEstadoServidor() {
        return new ActulizarEstadoServidor();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActulizarEstadoServidor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio.balanceador.com/", name = "actulizarEstadoServidor")
    public JAXBElement<ActulizarEstadoServidor> createActulizarEstadoServidor(ActulizarEstadoServidor value) {
        return new JAXBElement<ActulizarEstadoServidor>(_ActulizarEstadoServidor_QNAME, ActulizarEstadoServidor.class, null, value);
    }

}
