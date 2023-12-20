//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.09.28 at 04:41:49 PM CEST 
//


package com.example;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DocumentId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="DocumentType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ExternalId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="RefDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Parameters" type="{java:hu.westel.estore.onlineif.bean}DocumentDescription" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="DocumentUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentData", namespace = "java:hu.westel.estore.onlineif.bean", propOrder = {
    "documentId",
    "documentType",
    "externalId",
    "refDate",
    "parameters",
    "documentUrl",
    "version"
})
public class DocumentData {

    @XmlElement(name = "DocumentId", namespace = "java:hu.westel.estore.onlineif.bean", required = true, nillable = true)
    protected String documentId;
    @XmlElement(name = "DocumentType", namespace = "java:hu.westel.estore.onlineif.bean", required = true, nillable = true)
    protected String documentType;
    @XmlElement(name = "ExternalId", namespace = "java:hu.westel.estore.onlineif.bean", required = true, nillable = true)
    protected String externalId;
    @XmlElement(name = "RefDate", namespace = "java:hu.westel.estore.onlineif.bean", required = true, nillable = true)
    protected String refDate;
    @XmlElement(name = "Parameters", namespace = "java:hu.westel.estore.onlineif.bean", nillable = true)
    protected List<DocumentDescription> parameters;
    @XmlElement(name = "DocumentUrl", namespace = "java:hu.westel.estore.onlineif.bean", required = true, nillable = true)
    protected String documentUrl;
    @XmlElement(name = "Version", namespace = "java:hu.westel.estore.onlineif.bean", required = true, nillable = true)
    protected String version;

    /**
     * Gets the value of the documentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * Sets the value of the documentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentId(String value) {
        this.documentId = value;
    }

    /**
     * Gets the value of the documentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * Sets the value of the documentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentType(String value) {
        this.documentType = value;
    }

    /**
     * Gets the value of the externalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * Sets the value of the externalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalId(String value) {
        this.externalId = value;
    }

    /**
     * Gets the value of the refDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefDate() {
        return refDate;
    }

    /**
     * Sets the value of the refDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefDate(String value) {
        this.refDate = value;
    }

    /**
     * Gets the value of the parameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentDescription }
     * 
     * 
     */
    public List<DocumentDescription> getParameters() {
        if (parameters == null) {
            parameters = new ArrayList<DocumentDescription>();
        }
        return this.parameters;
    }

    /**
     * Gets the value of the documentUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentUrl() {
        return documentUrl;
    }

    /**
     * Sets the value of the documentUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentUrl(String value) {
        this.documentUrl = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
