package com.example.Roller;

import jakarta.servlet.jsp.tagext.*;
import jakarta.servlet.jsp.*;

import java.io.IOException;


public class HelloTag extends SimpleTagSupport {
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print("Hello");
    }
}
