package com.work.junit;

public class StringMatcher {

   // returns true if the string contains exactly "true"
   public boolean containsTrue(String s){
     return s.matches(".*true.*");
   }
   
   /* returns true if the string contains of three letters.
    * Ex: Ags, MCM,
    */
   public boolean isThreeLetters(String s){
     return s.matches("[a-zA-Z]{3}");
   }
}
