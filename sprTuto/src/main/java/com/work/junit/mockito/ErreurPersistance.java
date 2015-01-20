package com.work.junit.mockito;

public class ErreurPersistance extends Exception {

   public ErreurPersistance () {}
   
   public ErreurPersistance (String message) {
      super(message);
   }
 
   public ErreurPersistance (String message, Throwable ex) {
      super(message, ex);
  }   
}
