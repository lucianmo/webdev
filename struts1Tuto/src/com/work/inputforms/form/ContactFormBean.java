package com.work.inputforms.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ContactFormBean extends ActionForm {

   private String firstName = "First name";
   private String lastName = "Last name";
   private String email = "user@host";
   private String faxNumber = "xxx-yyy-zzzz";
   private String[] defaultValues =
     { firstName, lastName, email, faxNumber };
   private String warning = "";

   public String getFirstName() {
     return(firstName);
   }

   public void setFirstName(String firstName) {
     this.firstName = firstName;
   }

   public String getLastName() {
     return(lastName);
   }

   public void setLastName(String lastName) {
     this.lastName = lastName;
   }

   public String getEmail() {
     return(email);
   }

   public void setEmail(String email) {
     this.email = email;
   }

   public String getFaxNumber() {
     return(faxNumber);
   }

   public void setFaxNumber(String faxNumber) {
     this.faxNumber = faxNumber;
   }

   public String getWarning() {
     return(warning);
   }

   public void setWarning(String baseWarning) {
     this.warning =
       "<H2><FONT COLOR=RED>Missing or invalid " +
       baseWarning + "!</FONT></H2>";
   }

   public void clearWarning() {
     warning = "";
   }

   // The reset method below is ONLY needed if you make
   // the bean session-scoped. See the section on validation
   // for more details.

   public void reset(ActionMapping mapping,
                     HttpServletRequest request) {
     clearWarning();
   }

   public boolean isMissing(String value) {
     if ((value == null) || (value.trim().equals(""))) {
       return(true);
     } else {
       for(int i=0; i<defaultValues.length; i++) {
         if (value.equals(defaultValues[i])) {
           return(true);
         }
       }
       return(false);
     }
   }
}
