package com.example.Roller;

import jakarta.servlet.jsp.tagext.*;
import jakarta.servlet.jsp.*;


public class CustomTableHeader extends TagSupport {

    private String label1;
    private String label2;
    private String label3;

    public void setLabel1(String label1) {
        this.label1 = label1;
    }

    public void setLabel2(String label2) {
        this.label2 = label2;
    }

    public void setLabel3(String label3) {
        this.label3 = label3;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<tr>");
            pageContext.getOut().write("<th>" + label1 + "</th>");
            pageContext.getOut().write("<th>" + label2 + "</th>");
            pageContext.getOut().write("<th>" + label3 + "</th>");
            pageContext.getOut().write("</tr>");

        } catch (Exception e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }
}
