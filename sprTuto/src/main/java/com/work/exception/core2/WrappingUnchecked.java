package com.work.exception.core2;

public class WrappingUnchecked extends RuntimeException {

   public WrappingUnchecked () {}
   
   public WrappingUnchecked (String message) {
      super(message);
   }
 
   public WrappingUnchecked (String message, Throwable ex) {
      super(message, ex);
  }
}
