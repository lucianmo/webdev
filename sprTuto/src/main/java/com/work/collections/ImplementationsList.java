package com.work.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://www.journaldev.com/1289/java-arraylist-vs-copyonwritearraylist-and-exploring-iterator
 * http://www.java2s.com/Tutorials/Java/Java_Collection/0130__Java_List.htm
 *
 */
public class ImplementationsList {
   
   private static final Logger logger = LoggerFactory.getLogger(ImplementationsList.class);
   
   /**
    * 
    */
   public static void main(String[] args) {
      
      List<String> list = new ArrayList<>();
      list.add("1");
      list.add("2");
      list.add("3");
      list.add("4");
      list.add("5");
       
      Iterator<String> it = list.iterator();
      while (it.hasNext()) {
         logger.info("list is:"+list);
         String str = (String) it.next();
         logger.info(" iterator >>> "+str);
         if(str.equals("2"))list.remove("5");
      }
      
      /* Basically iterator throws ConcurrentModificationException if list size is changed.      
I|ImplementationsList                     | >>> 1
Exception in thread "main" java.util.ConcurrentModificationException
   at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:819)
   at java.util.ArrayList$Itr.next(ArrayList.java:791)
   at com.work.collections.ImplementationsList.main(ImplementationsList.java:27)
I|ImplementationsList                     | >>> 2      
      */
      
      //A ListIterator can look ahead or look back in a List. 
      ListIterator<String> lstit = list.listIterator();
      while(lstit.hasNext()) {
         logger.info("list is:"+list);
         String str = (String) lstit.next();
         logger.info(" listIterator >>> "+str);
         if(str.equals("2"))list.remove("5");
      }

      /* Basically iterator throws ConcurrentModificationException if list size is changed.
I|ImplementationsList                     | listIterator >>> 1
Exception in thread "main" I|ImplementationsList                     | listIterator >>> 2
java.util.ConcurrentModificationException
   at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:819)
   at java.util.ArrayList$Itr.next(ArrayList.java:791)
   at com.work.collections.ImplementationsList.main(ImplementationsList.java:43)      
      */

      List<String> copylist = new CopyOnWriteArrayList<>();
      copylist.add("1");
      copylist.add("2");
      copylist.add("3");
      copylist.add("4");
      copylist.add("5");
      
      Iterator<String> cpyit = copylist.iterator();
      while (cpyit.hasNext()) {
         logger.info("Copy list is:"+copylist);
         String str = (String) cpyit.next();
         logger.info(" Element >>> "+str);
         if(str.equals("2"))copylist.remove("5");
         if(str.equals("3"))copylist.add("3 found");
         
         if(str.equals("4")) copylist.set(0, "4");
      }
      
      //Is possible to remove when the iterator was finish.
      copylist.remove("3");
      logger.info("Copy list at final :"+copylist);
      
      /* CopyOnWriteArrayList - This is a thread-safe variant of java.util.ArrayList in which 
       * all mutative operations (add, set, and so on) are implemented by making a fresh copy 
       * of the underlying array.
I|ImplementationsList                     |Copy list is:[1, 2, 3, 4, 5]
I|ImplementationsList                     | Element >>> 1
I|ImplementationsList                     |Copy list is:[1, 2, 3, 4, 5]
I|ImplementationsList                     | Element >>> 2
I|ImplementationsList                     |Copy list is:[1, 2, 3, 4]
I|ImplementationsList                     | Element >>> 3
I|ImplementationsList                     |Copy list is:[1, 2, 3, 4, 3 found]
I|ImplementationsList                     | Element >>> 4
I|ImplementationsList                     |Copy list is:[4, 2, 3, 4, 3 found]
I|ImplementationsList                     | Element >>> 5 
I|ImplementationsList                     |Copy list at final :[4, 2, 4, 3 found]
     
      */
   }

}
