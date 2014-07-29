
package com.balanceador.monitor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "balanceador", targetNamespace = "http://monitor.balanceador.com/", wsdlLocation = "http://192.168.0.19:8080/BalanceadorServidor/Balanceador?wsdl")
public class Balanceador
    extends Service
{

    private final static URL BALANCEADOR_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.balanceador.monitor.Balanceador.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.balanceador.monitor.Balanceador.class.getResource(".");
            url = new URL(baseUrl, "http://192.168.0.19:8080/BalanceadorServidor/Balanceador?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://192.168.0.19:8080/BalanceadorServidor/Balanceador?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        BALANCEADOR_WSDL_LOCATION = url;
    }

    public Balanceador(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Balanceador() {
        super(BALANCEADOR_WSDL_LOCATION, new QName("http://monitor.balanceador.com/", "balanceador"));
    }

    /**
     * 
     * @return
     *     returns CPUmon
     */
    @WebEndpoint(name = "balanceadorPort")
    public CPUmon getBalanceadorPort() {
        return super.getPort(new QName("http://monitor.balanceador.com/", "balanceadorPort"), CPUmon.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CPUmon
     */
    @WebEndpoint(name = "balanceadorPort")
    public CPUmon getBalanceadorPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://monitor.balanceador.com/", "balanceadorPort"), CPUmon.class, features);
    }

}
