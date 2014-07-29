
package com.balanceador.monitor.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "obtenerProcesoResponse", namespace = "http://monitor.balanceador.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerProcesoResponse", namespace = "http://monitor.balanceador.com/")
public class ObtenerProcesoResponse {

    @XmlElement(name = "return", namespace = "")
    private com.balanceador.monitor.Proceso _return;

    /**
     * 
     * @return
     *     returns Proceso
     */
    public com.balanceador.monitor.Proceso getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.balanceador.monitor.Proceso _return) {
        this._return = _return;
    }

}
