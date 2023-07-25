package com.example.Roller;

import jakarta.servlet.jsp.tagext.*;
import jakarta.servlet.jsp.*;

import java.io.IOException;


public class HelloTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("Hello, this is a custom JSP tag!");
        } catch (Exception e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }
}
