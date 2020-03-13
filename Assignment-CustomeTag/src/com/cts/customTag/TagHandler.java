package com.cts.customTag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagHandler extends TagSupport {
	@Override
	public int doStartTag() throws JspException {
		System.out.println("From doStartTag() method");

		JspWriter out = pageContext.getOut();

		try {
			out.write("<h1>" + new Date() + "</h1>");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	//	return EVAL_BODY_INCLUDE; //this will retrun 1 (but we use this variable), this includes value inside our defined tag and display on webpage 
	    return SKIP_BODY; //it skips content inside the tag
	}

	@Override
	public int doEndTag() throws JspException {
		System.out.println("From doEndTag() method");
		return EVAL_PAGE;

	}

}
