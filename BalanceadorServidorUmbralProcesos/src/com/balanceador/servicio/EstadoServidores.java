
package com.balanceador.servicio;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "EstadoServidores", targetNamespace = "http://servicio.balanceador.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EstadoServidores {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "actulizarEstadoServidor", targetNamespace = "http://servicio.balanceador.com/", className = "com.balanceador.servicio.ActulizarEstadoServidor")
    public void actulizarEstadoServidor(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
