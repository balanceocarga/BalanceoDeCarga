
package com.balanceador.monitor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.balanceador.monitor package. 
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

    private final static QName _EjecutarProceso_QNAME = new QName("http://monitor.balanceador.com/", "ejecutarProceso");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.balanceador.monitor
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EjecutarProceso }
     * 
     */
    public EjecutarProceso createEjecutarProceso() {
        return new EjecutarProceso();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EjecutarProceso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monitor.balanceador.com/", name = "ejecutarProceso")
    public JAXBElement<EjecutarProceso> createEjecutarProceso(EjecutarProceso value) {
        return new JAXBElement<EjecutarProceso>(_EjecutarProceso_QNAME, EjecutarProceso.class, null, value);
    }

}
