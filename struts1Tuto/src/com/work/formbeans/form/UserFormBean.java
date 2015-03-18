package com.work.formbeans.form;

import org.apache.struts.action.ActionForm;

public class UserFormBean extends ActionForm {

   private String email = "Missing address";
   private String password = "Missing password";
   
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   
}
