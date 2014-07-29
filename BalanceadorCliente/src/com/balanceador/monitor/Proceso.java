
package com.balanceador.monitor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for proceso complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="proceso">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="prioridad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tiempoEstimado" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="usoCpu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usoMemoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "proceso", propOrder = {
    "descripcion",
    "id",
    "prioridad",
    "tiempoEstimado",
    "usoCpu",
    "usoMemoria"
})
public class Proceso {

    protected String descripcion;
    protected int id;
    protected int prioridad;
    protected int tiempoEstimado;
    protected String usoCpu;
    protected String usoMemoria;

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the prioridad property.
     * 
     */
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * Sets the value of the prioridad property.
     * 
     */
    public void setPrioridad(int value) {
        this.prioridad = value;
    }

    /**
     * Gets the value of the tiempoEstimado property.
     * 
     */
    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    /**
     * Sets the value of the tiempoEstimado property.
     * 
     */
    public void setTiempoEstimado(int value) {
        this.tiempoEstimado = value;
    }

    /**
     * Gets the value of the usoCpu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsoCpu() {
        return usoCpu;
    }

    /**
     * Sets the value of the usoCpu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsoCpu(String value) {
        this.usoCpu = value;
    }

    /**
     * Gets the value of the usoMemoria property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsoMemoria() {
        return usoMemoria;
    }

    /**
     * Sets the value of the usoMemoria property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsoMemoria(String value) {
        this.usoMemoria = value;
    }

}
