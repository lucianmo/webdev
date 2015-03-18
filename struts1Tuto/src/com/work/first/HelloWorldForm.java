package com.work.first;

import org.apache.struts.action.ActionForm;

/**
 * Struts Action Form to hold the “hello world” data
 * 
 */
public class HelloWorldForm extends ActionForm {

   String message;
   
   public String getMessage() {
      return message;
   }
 
   public void setMessage(String message) {
      this.message = message;
   }
}
