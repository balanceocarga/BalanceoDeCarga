
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

    private final static QName _ObtenerProcesamientoMemoriaOciosoResponse_QNAME = new QName("http://monitor.balanceador.com/", "obtenerProcesamientoMemoriaOciosoResponse");
    private final static QName _AcceptResponse_QNAME = new QName("http://monitor.balanceador.com/", "acceptResponse");
    private final static QName _ObtenerProcesamientoMemoriaOcioso_QNAME = new QName("http://monitor.balanceador.com/", "obtenerProcesamientoMemoriaOcioso");
    private final static QName _ObtenerProceso_QNAME = new QName("http://monitor.balanceador.com/", "obtenerProceso");
    private final static QName _ObtenerProcesoResponse_QNAME = new QName("http://monitor.balanceador.com/", "obtenerProcesoResponse");
    private final static QName _Accept_QNAME = new QName("http://monitor.balanceador.com/", "accept");
    private final static QName _EjecutarProceso_QNAME = new QName("http://monitor.balanceador.com/", "ejecutarProceso");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.balanceador.monitor
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerProcesamientoMemoriaOcioso }
     * 
     */
    public ObtenerProcesamientoMemoriaOcioso createObtenerProcesamientoMemoriaOcioso() {
        return new ObtenerProcesamientoMemoriaOcioso();
    }

    /**
     * Create an instance of {@link CpuUsageSnapshot }
     * 
     */
    public CpuUsageSnapshot createCpuUsageSnapshot() {
        return new CpuUsageSnapshot();
    }

    /**
     * Create an instance of {@link Accept }
     * 
     */
    public Accept createAccept() {
        return new Accept();
    }

    /**
     * Create an instance of {@link ObtenerProcesamientoMemoriaOciosoResponse }
     * 
     */
    public ObtenerProcesamientoMemoriaOciosoResponse createObtenerProcesamientoMemoriaOciosoResponse() {
        return new ObtenerProcesamientoMemoriaOciosoResponse();
    }

    /**
     * Create an instance of {@link EjecutarProceso }
     * 
     */
    public EjecutarProceso createEjecutarProceso() {
        return new EjecutarProceso();
    }

    /**
     * Create an instance of {@link ObtenerProcesoResponse }
     * 
     */
    public ObtenerProcesoResponse createObtenerProcesoResponse() {
        return new ObtenerProcesoResponse();
    }

    /**
     * Create an instance of {@link Proceso }
     * 
     */
    public Proceso createProceso() {
        return new Proceso();
    }

    /**
     * Create an instance of {@link AcceptResponse }
     * 
     */
    public AcceptResponse createAcceptResponse() {
        return new AcceptResponse();
    }

    /**
     * Create an instance of {@link Datos }
     * 
     */
    public Datos createDatos() {
        return new Datos();
    }

    /**
     * Create an instance of {@link ObtenerProceso }
     * 
     */
    public ObtenerProceso createObtenerProceso() {
        return new ObtenerProceso();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerProcesamientoMemoriaOciosoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monitor.balanceador.com/", name = "obtenerProcesamientoMemoriaOciosoResponse")
    public JAXBElement<ObtenerProcesamientoMemoriaOciosoResponse> createObtenerProcesamientoMemoriaOciosoResponse(ObtenerProcesamientoMemoriaOciosoResponse value) {
        return new JAXBElement<ObtenerProcesamientoMemoriaOciosoResponse>(_ObtenerProcesamientoMemoriaOciosoResponse_QNAME, ObtenerProcesamientoMemoriaOciosoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcceptResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monitor.balanceador.com/", name = "acceptResponse")
    public JAXBElement<AcceptResponse> createAcceptResponse(AcceptResponse value) {
        return new JAXBElement<AcceptResponse>(_AcceptResponse_QNAME, AcceptResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerProcesamientoMemoriaOcioso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monitor.balanceador.com/", name = "obtenerProcesamientoMemoriaOcioso")
    public JAXBElement<ObtenerProcesamientoMemoriaOcioso> createObtenerProcesamientoMemoriaOcioso(ObtenerProcesamientoMemoriaOcioso value) {
        return new JAXBElement<ObtenerProcesamientoMemoriaOcioso>(_ObtenerProcesamientoMemoriaOcioso_QNAME, ObtenerProcesamientoMemoriaOcioso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerProceso }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monitor.balanceador.com/", name = "obtenerProceso")
    public JAXBElement<ObtenerProceso> createObtenerProceso(ObtenerProceso value) {
        return new JAXBElement<ObtenerProceso>(_ObtenerProceso_QNAME, ObtenerProceso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerProcesoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monitor.balanceador.com/", name = "obtenerProcesoResponse")
    public JAXBElement<ObtenerProcesoResponse> createObtenerProcesoResponse(ObtenerProcesoResponse value) {
        return new JAXBElement<ObtenerProcesoResponse>(_ObtenerProcesoResponse_QNAME, ObtenerProcesoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Accept }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://monitor.balanceador.com/", name = "accept")
    public JAXBElement<Accept> createAccept(Accept value) {
        return new JAXBElement<Accept>(_Accept_QNAME, Accept.class, null, value);
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
