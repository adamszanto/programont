//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.09.15 at 10:34:26 AM CEST 
//


package com.example;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TimeZone complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeZone"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RawOffset" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Default" type="{java:java.util}TimeZone"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeZone", namespace = "java:java.util", propOrder = {
    "rawOffset",
    "id",
    "_default"
})
public class TimeZone {

    @XmlElement(name = "RawOffset", namespace = "java:java.util")
    protected int rawOffset;
    @XmlElement(name = "ID", namespace = "java:java.util", required = true, nillable = true)
    protected String id;
    @XmlElement(name = "Default", namespace = "java:java.util", required = true, nillable = true)
    protected TimeZone _default;

    /**
     * Gets the value of the rawOffset property.
     * 
     */
    public int getRawOffset() {
        return rawOffset;
    }

    /**
     * Sets the value of the rawOffset property.
     * 
     */
    public void setRawOffset(int value) {
        this.rawOffset = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the default property.
     * 
     * @return
     *     possible object is
     *     {@link TimeZone }
     *     
     */
    public TimeZone getDefault() {
        return _default;
    }

    /**
     * Sets the value of the default property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeZone }
     *     
     */
    public void setDefault(TimeZone value) {
        this._default = value;
    }

}
