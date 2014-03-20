package com.serie4it.coreservlets.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class GatewayService extends HttpServlet {
   protected static final Logger logger = LoggerFactory.getLogger(GatewayService.class);
   
   public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      logger.info("In doPost GatewayService!?? ");
      
      String user = (String)request.getParameter("user");
      String pass = (String)request.getParameter("pass");
      
      // Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println("user: "+user+" pass: "+pass);      
      
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException
{
      doPost(request, response); 
}
        
}
