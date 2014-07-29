
package com.balanceador.monitor.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "obtenerProcesamientoMemoriaOciosoResponse", namespace = "http://monitor.balanceador.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerProcesamientoMemoriaOciosoResponse", namespace = "http://monitor.balanceador.com/")
public class ObtenerProcesamientoMemoriaOciosoResponse {

    @XmlElement(name = "return", namespace = "")
    private com.balanceador.dto.Datos _return;

    /**
     * 
     * @return
     *     returns Datos
     */
    public com.balanceador.dto.Datos getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.balanceador.dto.Datos _return) {
        this._return = _return;
    }

}
