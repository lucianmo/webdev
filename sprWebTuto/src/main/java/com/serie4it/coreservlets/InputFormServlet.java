package com.serie4it.coreservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.*;
import org.springframework.web.context.support.*;

public class InputFormServlet extends HttpServlet {
   
   static final Logger logger = LoggerFactory.getLogger(InputFormServlet.class); 
   
   public void doGet(HttpServletRequest request, HttpServletResponse response)
                                                            throws ServletException, IOException {
      

      ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext((getServletContext()));
      ColorPreferences color = (ColorPreferences)context.getBean("colorPreferences");
      
      logger.info("In doGet Foreground: "+color.getForeground());
      String address = "/WEB-INF/views/coreservlets/input-form.jsp";
      RequestDispatcher dispatcher = request.getRequestDispatcher(address);
      dispatcher.forward(request, response);      
      
   }
}
