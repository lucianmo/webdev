package com.work.inputforms.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.work.inputforms.form.ContactFormBean;
import com.work.inputforms.logic.MessageBean;

public class SignupAction1 extends Action {

   public ActionForward execute(ActionMapping mapping,
                                ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
                                      throws Exception {
      ContactFormBean userBean = (ContactFormBean)form;
      String firstName = userBean.getFirstName();
      String lastName = userBean.getLastName();
      String email = userBean.getEmail();
      String faxNumber = userBean.getFaxNumber();      
      
      if (userBean.isMissing(firstName)) {
         makeWarning(request, "first name");
         return(mapping.findForward("missing-value"));
         
       } else if (userBean.isMissing(lastName)) {
         makeWarning(request, "last name");
         return(mapping.findForward("missing-value"));
         
       } else if ((userBean.isMissing(email)) || (email.indexOf("@") == -1)) {
         makeWarning(request, "email address");
         return(mapping.findForward("missing-value"));
         
       } else if (userBean.isMissing(faxNumber)) {
         makeWarning(request, "fax number");
         return(mapping.findForward("missing-value"));
         
       } else {
         return(mapping.findForward("success"));
       }      
   }
   
   protected void makeWarning(HttpServletRequest request, String message) {
      MessageBean messageBean = new MessageBean();
      messageBean.setMessage(message);
      request.setAttribute("messageBean", messageBean);
   }   
}
