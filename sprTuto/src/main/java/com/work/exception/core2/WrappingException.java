package com.work.exception.core2;

public class WrappingException extends Exception {

   public WrappingException () {}
   
   public WrappingException (String message) {
      super(message);
   }
 
   public WrappingException (String message, Throwable ex) {
      super(message, ex);
  }
   
}
