package com.work.inputforms.action;

import javax.servlet.http.HttpServletRequest;

import com.work.inputforms.form.ContactFormBean;

public class SignupAction2 extends SignupAction1 {

   protected void makeWarning(HttpServletRequest request, String message) {
      ContactFormBean contactFormBean = (ContactFormBean)request.getAttribute("contactFormBean");
      contactFormBean.setWarning(message);
   }
}
