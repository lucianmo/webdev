package com.work.junit.mockito;

public class HelloApplication {

   public static interface Greeter {
      String getGreeting(String subject);
      String getIntroduction(String actor);
   }
   
   public static class HelloGreeter implements Greeter {
      private String hello;
      private String segmenter;
 
      public HelloGreeter(String hello, String segmenter) {
         this.hello = hello;
         this.segmenter = segmenter;
      }
      public String getGreeting(String subject) {
         return hello + " " + subject; 
      }
      public String getIntroduction(String actor) {
         return actor+segmenter;
      }
   }   
   
}
