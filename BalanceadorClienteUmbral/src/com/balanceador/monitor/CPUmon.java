
package com.balanceador.monitor;

import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "CPUmon", targetNamespace = "http://monitor.balanceador.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CPUmon {


    /**
     * 
     * @return
     *     returns com.balanceador.monitor.Datos
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerProcesamientoMemoriaOcioso", targetNamespace = "http://monitor.balanceador.com/", className = "com.balanceador.monitor.ObtenerProcesamientoMemoriaOcioso")
    @ResponseWrapper(localName = "obtenerProcesamientoMemoriaOciosoResponse", targetNamespace = "http://monitor.balanceador.com/", className = "com.balanceador.monitor.ObtenerProcesamientoMemoriaOciosoResponse")
    public Datos obtenerProcesamientoMemoriaOcioso();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "ejecutarProceso", targetNamespace = "http://monitor.balanceador.com/", className = "com.balanceador.monitor.EjecutarProceso")
    public void ejecutarProceso(
        @WebParam(name = "arg0", targetNamespace = "")
        List<String> arg0);

}
