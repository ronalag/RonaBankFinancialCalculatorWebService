//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.15 at 03:51:00 PM EDT 
//


package com.ronalag.ronabank.webservice.financialcalculators;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="amortization" type="{http://ronalag.com/ronabank/webservice/financialcalculators}amortizationRange"/>
 *         &lt;element name="downPayment" type="{http://ronalag.com/ronabank/webservice/financialcalculators}positiveDecimal"/>
 *         &lt;element name="interestRate" type="{http://ronalag.com/ronabank/webservice/financialcalculators}percentage"/>
 *         &lt;element name="purchasePrice" type="{http://ronalag.com/ronabank/webservice/financialcalculators}positiveDecimal"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "getMonthlyPaymentRequest")
public class GetMonthlyPaymentRequest {

    protected int amortization;
    @XmlElement(required = true)
    protected BigDecimal downPayment;
    @XmlElement(required = true)
    protected BigDecimal interestRate;
    @XmlElement(required = true)
    protected BigDecimal purchasePrice;

    /**
     * Gets the value of the amortization property.
     * 
     */
    public int getAmortization() {
        return amortization;
    }

    /**
     * Sets the value of the amortization property.
     * 
     */
    public void setAmortization(int value) {
        this.amortization = value;
    }

    /**
     * Gets the value of the downPayment property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDownPayment() {
        return downPayment;
    }

    /**
     * Sets the value of the downPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDownPayment(BigDecimal value) {
        this.downPayment = value;
    }

    /**
     * Gets the value of the interestRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInterestRate() {
        return interestRate;
    }

    /**
     * Sets the value of the interestRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInterestRate(BigDecimal value) {
        this.interestRate = value;
    }

    /**
     * Gets the value of the purchasePrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Sets the value of the purchasePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPurchasePrice(BigDecimal value) {
        this.purchasePrice = value;
    }

}
