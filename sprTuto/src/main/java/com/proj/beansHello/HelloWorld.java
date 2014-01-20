package com.proj.beansHello;

public class HelloWorld {
   private String message;
   
   /*
    * 
    */
   public void setMessage(String message) {
      this.message = message;
   }
 
   public void printHello() {
      System.out.println("Spring 3 : Hello ! " + message);
   }
}
