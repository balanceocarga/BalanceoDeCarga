
package com.balanceador.monitor;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for datos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="datos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="memoriaOciosa" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="procesamientoOcioso" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datos", propOrder = {
    "memoriaOciosa",
    "procesamientoOcioso"
})
public class Datos {

    protected BigDecimal memoriaOciosa;
    protected BigDecimal procesamientoOcioso;

    /**
     * Gets the value of the memoriaOciosa property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMemoriaOciosa() {
        return memoriaOciosa;
    }

    /**
     * Sets the value of the memoriaOciosa property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMemoriaOciosa(BigDecimal value) {
        this.memoriaOciosa = value;
    }

    /**
     * Gets the value of the procesamientoOcioso property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProcesamientoOcioso() {
        return procesamientoOcioso;
    }

    /**
     * Sets the value of the procesamientoOcioso property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProcesamientoOcioso(BigDecimal value) {
        this.procesamientoOcioso = value;
    }

}
