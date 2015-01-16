package com.work.junit.jenkov;

import java.util.ArrayList;
import java.util.List;

public class MyUnit {
   
   /**
    * 
    * @param pManyString
    * @return
    */
   public String concatenate (String ... pManyString) {
      StringBuffer rez = new StringBuffer();
      
      for (String oneString : pManyString) {
         rez.append(oneString);
      }
      return rez.toString();
   }
   
   /**
    * Take the String parameter and construct a Array.
    * @param pManyString
    * @return
    */
   public String[] getStringArray (String ... pManyString) {
      List<String> myArrayList = new ArrayList<String>();
      
      for (String oneString : pManyString) {
         myArrayList.add(oneString);
      }
      //return Array from ArrayList with the same size.
      return myArrayList.toArray(new String[myArrayList.size()]);
   }

}
