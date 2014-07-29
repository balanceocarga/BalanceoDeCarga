
package com.balanceador.monitor.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "accept", namespace = "http://monitor.balanceador.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accept", namespace = "http://monitor.balanceador.com/")
public class Accept {

    @XmlElement(name = "arg0", namespace = "")
    private com.vladium.utils.SystemInformation.CPUUsageSnapshot arg0;

    /**
     * 
     * @return
     *     returns CPUUsageSnapshot
     */
    public com.vladium.utils.SystemInformation.CPUUsageSnapshot getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(com.vladium.utils.SystemInformation.CPUUsageSnapshot arg0) {
        this.arg0 = arg0;
    }

}
