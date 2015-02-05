package com.work.generics.first;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OldManner {
   protected static final Logger logger = LoggerFactory.getLogger(OldManner.class);
   
   private Object t;

   public Object getT() {
      return t;
   }

   public void setT(Object t) {
      this.t = t;
   }
   
   public static void main(String[] args) {
      OldManner om = new OldManner();
      om.setT("toto");
      String rez = (String) om.getT();
      logger.info(" >>> rez: "+rez);
      
      OldManner omInteger = new OldManner();
      omInteger.setT(new Integer(12));
      Integer rezInt = (Integer) omInteger.getT();
      logger.info(" >>> rezInt: "+rezInt);
      
      /*
      I|OldManner                               | >>> rez: toto
      I|OldManner                               | >>> rezInt: 12
      */
   }
}
