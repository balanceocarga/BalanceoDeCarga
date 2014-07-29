
package com.balanceador.monitor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cpuUsageSnapshot complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cpuUsageSnapshot">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="m_time" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="m_CPUTime" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cpuUsageSnapshot", propOrder = {
    "mTime",
    "mcpuTime"
})
public class CpuUsageSnapshot {

    @XmlElement(name = "m_time")
    protected long mTime;
    @XmlElement(name = "m_CPUTime")
    protected long mcpuTime;

    /**
     * Gets the value of the mTime property.
     * 
     */
    public long getMTime() {
        return mTime;
    }

    /**
     * Sets the value of the mTime property.
     * 
     */
    public void setMTime(long value) {
        this.mTime = value;
    }

    /**
     * Gets the value of the mcpuTime property.
     * 
     */
    public long getMCPUTime() {
        return mcpuTime;
    }

    /**
     * Sets the value of the mcpuTime property.
     * 
     */
    public void setMCPUTime(long value) {
        this.mcpuTime = value;
    }

}
