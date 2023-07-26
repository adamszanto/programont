package com.example.Roller;

import jakarta.servlet.jsp.tagext.*;
import jakarta.servlet.jsp.*;


public class CustomTable extends TagSupport {

    private String value1;
    private String value2;
    private String value3;

    private String label1;
    private String label2;
    private String label3;

    public String getLabel1() {
        return label1;
    }

    public void setLabel1(String label1) {
        this.label1 = label1;
    }

    public String getLabel2() {
        return label2;
    }

    public void setLabel2(String label2) {
        this.label2 = label2;
    }

    public String getLabel3() {
        return label3;
    }

    public void setLabel3(String label3) {
        this.label3 = label3;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<tr>");
            pageContext.getOut().write("<td>" + value1 + "</td>");
            pageContext.getOut().write("<td>" + value2 + CURRENCIES.CURRENCY_HUF + "</td>");
            pageContext.getOut().write("<td>" + value3 + "</td>");
            pageContext.getOut().write("</tr>");

        } catch (Exception e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }
}
