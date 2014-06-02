/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distributedapplication;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aklil This class simulates an Entity bean with JPA Used to test Soap
 * JAX-WS in spring MVC
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order implements Serializable {

    @XmlAttribute(required = true) //can be used to override the default configration of the JAXB on each attribute.
    private String orderId;

    private double invoice;

    private int itemNumber;

    private Date shippingDate;

    //default constructor is needed
    public Order() {
    }

    public Order(String orderId, double invoice, int itemNumber) {

        this.orderId = orderId;
        this.invoice = invoice;
        this.itemNumber = itemNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getInvoice() {
        return invoice;
    }

    public void setInvoice(double invoice) {
        this.invoice = invoice;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    @Override
    public String toString() {
        return " orderId:" + orderId
                + " itemNumber:" + itemNumber
                + " invoice:" + invoice
                + " shippingDate:" + shippingDate;
    }

}
