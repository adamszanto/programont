//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.09.15 at 10:34:26 AM CEST 
//


package com.example;

import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListDocumentDataRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListDocumentDataRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DocumentType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Parameters" type="{java:hu.westel.estore.onlineif.bean}DocumentDescription" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Reason" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="RequestParameter" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="UserName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="OrderParam" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="OrderDirection" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MaxResults" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="DocumentGroup" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="FromDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="ToDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListDocumentDataRequest", namespace = "java:hu.westel.estore.onlineif.bean", propOrder = {
    "documentType",
    "parameters",
    "reason",
    "requestParameter",
    "userName",
    "orderParam",
    "orderDirection",
    "maxResults",
    "documentGroup",
    "fromDate",
    "toDate"
})
public class ListDocumentDataRequest {

    @XmlElement(name = "DocumentType", namespace = "java:hu.westel.estore.onlineif.bean", required = true, nillable = true)
    protected String documentType;
    @XmlElement(name = "Parameters", namespace = "java:hu.westel.estore.onlineif.bean", nillable = true)
    protected List<DocumentDescription> parameters;
    @XmlElement(name = "Reason", namespace = "java:hu.westel.estore.onlineif.bean", required = true, nillable = true)
    protected String reason;
    @XmlElement(name = "RequestParameter", namespace = "java:hu.westel.estore.onlineif.bean", required = true, nillable = true)
    protected String requestParameter;
    @XmlElement(name = "UserName", namespace = "java:hu.westel.estore.onlineif.bean", required = true, nillable = true)
    protected String userName;
    @XmlElement(name = "OrderParam", namespace = "java:hu.westel.estore.onlineif.bean", required = true, nillable = true)
    protected String orderParam;
    @XmlElement(name = "OrderDirection", namespace = "java:hu.westel.estore.onlineif.bean", required = true, nillable = true)
    protected String orderDirection;
    @XmlElement(name = "MaxResults", namespace = "java:hu.westel.estore.onlineif.bean", required = true, type = Integer.class, nillable = true)
    protected Integer maxResults;
    @XmlElement(name = "DocumentGroup", namespace = "java:hu.westel.estore.onlineif.bean", required = true, nillable = true)
    protected String documentGroup;
    @XmlElement(name = "FromDate", namespace = "java:hu.westel.estore.onlineif.bean", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fromDate;
    @XmlElement(name = "ToDate", namespace = "java:hu.westel.estore.onlineif.bean", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar toDate;

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
     * Gets the value of the parameters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
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
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * Gets the value of the requestParameter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestParameter() {
        return requestParameter;
    }

    /**
     * Sets the value of the requestParameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestParameter(String value) {
        this.requestParameter = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the orderParam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderParam() {
        return orderParam;
    }

    /**
     * Sets the value of the orderParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderParam(String value) {
        this.orderParam = value;
    }

    /**
     * Gets the value of the orderDirection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderDirection() {
        return orderDirection;
    }

    /**
     * Sets the value of the orderDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderDirection(String value) {
        this.orderDirection = value;
    }

    /**
     * Gets the value of the maxResults property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxResults() {
        return maxResults;
    }

    /**
     * Sets the value of the maxResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxResults(Integer value) {
        this.maxResults = value;
    }

    /**
     * Gets the value of the documentGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentGroup() {
        return documentGroup;
    }

    /**
     * Sets the value of the documentGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentGroup(String value) {
        this.documentGroup = value;
    }

    /**
     * Gets the value of the fromDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFromDate() {
        return fromDate;
    }

    /**
     * Sets the value of the fromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFromDate(XMLGregorianCalendar value) {
        this.fromDate = value;
    }

    /**
     * Gets the value of the toDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getToDate() {
        return toDate;
    }

    /**
     * Sets the value of the toDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setToDate(XMLGregorianCalendar value) {
        this.toDate = value;
    }

}
