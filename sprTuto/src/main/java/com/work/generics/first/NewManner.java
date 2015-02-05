package com.work.generics.first;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewManner<T> {
   protected static final Logger logger = LoggerFactory.getLogger(NewManner.class);
   
   private T myVariable;
 
   public T getMyVariable() {
      return myVariable;
   }
   
   public void setMyVariable(T t) {
      this.myVariable = t;
   }
   
   public static void main(String[] args) {
      NewManner<Integer> nm = new NewManner<Integer>();
      nm.setMyVariable(new Integer(7));
      Integer rez = nm.getMyVariable();
      logger.info("rez: "+rez);
      
      NewManner<String> ns = new NewManner<String>();
      ns.setMyVariable("What is that");
      String rezs = ns.getMyVariable();
      logger.info("rezs: "+rezs);
      
      /*
      I|NewManner                               |rez: 7
      I|NewManner                               |rezs: What is that
      */
   }
}
