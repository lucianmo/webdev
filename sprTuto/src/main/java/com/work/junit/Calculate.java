package com.work.junit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculate {
   
   private static final Logger logger = LoggerFactory.getLogger(Calculate.class);
   
   public int sum(int val1, int val2) {
      logger.info("return value = " + (val1 + val2));      
      return val1 + val2;
   }
   
   /**
    * Divide numbers
    * @param pNombres
    * @return
    */
   public long diviser (long ...pNombres) {
      
      if (pNombres.length < 2) {
         throw new IllegalArgumentException("We must to have two numbers");
      }
      long lRetour = pNombres[0];
      for (int i = 1; i < pNombres.length; i++) {
         lRetour /= pNombres[i];
      }
      
      return lRetour;
   }
}
