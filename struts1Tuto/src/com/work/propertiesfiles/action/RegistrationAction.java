package com.work.propertiesfiles.action;

import javax.servlet.http.*;
import org.apache.struts.action.*;

public class RegistrationAction extends Action {
  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response)
      throws Exception {
    return(mapping.findForward("success"));
  }
}
