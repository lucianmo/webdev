package com.work.actionobjects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RegisterAction2 extends Action {

   public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
                                          throws Exception {
      /* In this simple example we use request.getParameter explicitly.
       * In later examples we let Struts automatically populate a bean from the request data.
       */
      String email = request.getParameter("email");
      String password = request.getParameter("password");
      
      if ((email == null) || (email.trim().length() < 3) || (email.indexOf("@") == -1)) {
         return(mapping.findForward("bad-address"));
      } else if ((password == null) || (password.trim().length() < 6)) {
         return(mapping.findForward("bad-password"));
      } else {
         return(mapping.findForward("success"));
      }
   }
}
