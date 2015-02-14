package com.work.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class First {
   
   private static final Logger logger = LoggerFactory.getLogger(First.class);
   
   /**
    * Converts the given collection to a <code>java.util.List</code>.
    * @param <T>
    * @param aCollection: The collection to convert to a list.
    * @return A <code>java.util.List</code> containing all of the elements from the
    *         supplied collection.
    */
   public static <T> List<T> toList(Collection<T> aCollection) {
      if (aCollection instanceof List) return (List<T>) aCollection;
      
      List<T> aList = new ArrayList<T>();
      
      Iterator<T> it = aCollection.iterator();
      while (it.hasNext()) {
         aList.add((T) it.next());         
      }
      return aList;      
   }

   /**
    * Determine if the two collections are equal.
    * @param collection1: first collection to compare
    * @param collection2: second collection to compare
    * @return
    */
   public static boolean areEqual(Collection<?> collection1, Collection<?> collection2){
      
      if (collection1.size() != collection2.size()) return false;
      
      Iterator<?> it = collection1.iterator();
      while (it.hasNext()) {
         if (!collection2.contains(it.next())) return false;
      }      
      return true;
   }
   
   /**
    * Traverse the collection removing specific elements.
    * @param thisElement
    * @param aCol
    */
   public static <E, T> void filter (T thisElement, Collection<E> aCol) {
      
      for(Iterator<E> it = aCol.iterator();it.hasNext();) {
          E aElement = it.next();
          if (thisElement.equals(aElement)) { 
             //Iterator.remove is the only safe way to modify a collection during iteration
             it.remove();
             logger.info("Element: "+thisElement.toString()+" is equal to "+aElement.toString());
          }
      }      
   }
   
   /**
    * Traverse the collection removing specific elements.
    * @param thisElement
    * @param aCol
    */
   public static <T> void filterVersion2 (T thisElement, Collection<?> aCol) {
      
      for(Iterator<?> it = aCol.iterator(); it.hasNext();) {
         
          Object anObj = it.next();
          if(thisElement.equals(anObj)) {
             it.remove(); //Iterator.remove is the only safe way to modify a collection during iteration
             logger.info("Element: "+thisElement.toString()+" is equal to "+anObj.toString());
          }          
      }
   }
   
   /**
    * Don't use Iterator. Using a for-each Loop 
    * Remove Elements.
    */
   public static void useForEach () {
      //For JDK 7 or later — you can use the diamond operator: 
      List<Integer> intList = new ArrayList<>();
      intList.add(Integer.valueOf(10));intList.add(new Integer(20));intList.add(new Integer(30)); intList.add(new Integer(40)); //intList.add(new Integer(50));
      
      for(Integer myInt : intList) {
         
         if(myInt.equals(new Integer(20))) {            
            logger.info("           >>> Element: "+myInt);
         }  
            
      }
      
      logger.info("  >>> Collection : "+Arrays.toString(intList.toArray(new Integer[0])));
   }
   
   /**
    * @param args
    */
   public static void main(String[] args) {
      
      //Converts the given collection to a java.util.List.
      Set<String> aSet = new HashSet<String>();
      aSet.add("un");aSet.add("deux");aSet.add("trois");//aSet.add("quatre");
      
      List<String> newList = toList(aSet);
      logger.info("  >>> Solution 1");
      for (String aString : newList) {
         logger.info("Element: "+aString);
      }
      
      List<String> newList2 = new ArrayList<String>(aSet);
      logger.info("  >>> Solution 2");
      for (String aString2 : newList2) {
         logger.info("Element: "+aString2);
      }
      
      List<String> newList3 = new ArrayList<String>();
      newList3.addAll(aSet);
      logger.info("  >>> Solution 3");
      for (String aString3 : newList2) {
         logger.info("Element: "+aString3);
      }
      
      /*
      I|First                                   |  >>> Solution 1
      I|First                                   |Element: deux
      I|First                                   |Element: trois
      I|First                                   |Element: un
      I|First                                   |  >>> Solution 2
      I|First                                   |Element: deux
      I|First                                   |Element: trois
      I|First                                   |Element: un
      I|First                                   |  >>> Solution 3
      I|First                                   |Element: deux
      I|First                                   |Element: trois
      I|First                                   |Element: un
      */
      
      logger.info("This two collections are equals? " +areEqual(aSet, newList));
      /*I|First                                   |This two collections are equals? true*/
      
      //The array operations allow the contents of a Collection to be translated into an array.
      Object[] firstArray = newList.toArray();
      logger.info("firstArray of Objects: "+Arrays.toString(firstArray));
      
      //Dumps the contents of "newList" into a newly allocated array of String whose length is identical to the number of elements in newList.
      String[] secondArray = newList.toArray(new String[] {});      
      logger.info("secondArray of String: "+Arrays.toString(secondArray));
      /*
      I|First                                   |firstArray of Objects: [deux, trois, un]
      I|First                                   |secondArray of String: [deux, trois, un]
       */
      
      //Removing element 
      filter ("deux", newList);
      logger.info("  >>> Collection After filter: "+Arrays.toString(newList.toArray(new String[] {})));
      /*
      I|First                                   |Element: deux is equal to deux
      I|First                                   |  >>> Collection After filter: [trois, un]
      */
      
      filterVersion2 ("un", newList);
      logger.info("  >>> Collection After filter: "+Arrays.toString(newList.toArray(new String[0])));
      /*
      I|First                                   |Element: un is equal to un
      I|First                                   |  >>> Collection After filter: [deux, trois]
      */
      
      useForEach ();
      /*
      I|First                                   |   >>> Element: 20 was removed!
      I|First                                   |  >>> Collection After remove: [10, 30]
      */
      
   }

}
