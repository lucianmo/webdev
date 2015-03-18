package com.work.formbeans.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.work.formbeans.form.UserFormBean;
import com.work.formbeans.logic.SuggestionUtils;

public class BeanRegisterAction extends Action {

   public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
                                       throws Exception {
      
      UserFormBean userBean = (UserFormBean)form;
      String email = userBean.getEmail();
      String password = userBean.getPassword();
      
      if ((email == null) || (email.trim().length() < 3) || (email.indexOf("@") == -1)) {
         request.setAttribute("suggestionBean", SuggestionUtils.getSuggestionBean());
         return(mapping.findForward("bad-address"));
         
      } else if ((password == null) ||(password.trim().length() < 6)) {
         request.setAttribute("suggestionBean", SuggestionUtils.getSuggestionBean());
         return(mapping.findForward("bad-password"));
         
      } else {
         return(mapping.findForward("success"));
      }
   }
}
