package com.work.formbeans.logic;

public class SuggestionBean {
   private String email;
   private String password;

   public SuggestionBean(String email, String password) {
     this.email = email;
     this.password = password;
   }
   
   public String getEmail() {
     return(email);
   }

   public String getPassword() {
     return(password);
   }
}
