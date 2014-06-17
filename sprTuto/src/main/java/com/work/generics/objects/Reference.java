package com.work.generics.objects;

public class Reference {
   private String ssoToken;

   public String getSsoToken() {
      return ssoToken;
   }

   public void setSsoToken(String ssoToken) {
      this.ssoToken = ssoToken;
   }
   
   @Override
   public String toString() {
      return "Reference [ssoToken=" + ssoToken + "]";
   }   
}
