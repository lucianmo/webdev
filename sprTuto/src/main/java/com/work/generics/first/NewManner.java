package com.work.generics.first;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewManner<T> {
   protected static final Logger logger = LoggerFactory.getLogger(NewManner.class);
   
   private T t;
 
   public T getT() {
      return t;
   }
   
   public void setT(T t) {
      this.t = t;
   }
   
   public static void main(String[] args) {
      NewManner<Integer> nm = new NewManner<Integer>();
      nm.setT(new Integer(7));
      Integer rez = nm.getT();
      logger.info("rez: "+rez);
      
      NewManner<String> ns = new NewManner<String>();
      ns.setT("What is that");
      String rezs = ns.getT();
      logger.info("rezs: "+rezs);
   }
}
