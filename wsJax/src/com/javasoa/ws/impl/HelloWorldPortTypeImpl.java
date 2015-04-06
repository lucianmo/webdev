package com.javasoa.ws.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.javasoa.ws.HelloWorldPortType;

/**
* HelloWorld WS implementation.
*/
@WebService(endpointInterface = "com.javasoa.ws.HelloWorldPortType")
public class HelloWorldPortTypeImpl implements HelloWorldPortType {

   /** suffix : hello. */
   private static final String SUFFIX_HELLO = "Hello ";
   
   /**
    * Say hello to in.
    * @param in name
    * @return response
    */
   @Override
   @WebMethod
   @WebResult(name = "response", targetNamespace = "http://java-soa.blogspot.com/", partName = "out")
   public String hello(
         @WebParam(name = "name", targetNamespace = "http://java-soa.blogspot.com/", partName = "in") String in) {
      // TODO Auto-generated method stub
      return (SUFFIX_HELLO + in);
   }

}
