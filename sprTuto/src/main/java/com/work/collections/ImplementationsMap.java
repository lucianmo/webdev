package com.work.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The HashMap allows one null value as a key and multiple null values as the values.
 * A HashMap does not guarantee any specific iteration order of entries in the Map. 
 * The LinkedHashMap implementation class keeps the iteration ordering as the insertion order. 
 * Example: http://www.java2s.com/Tutorial/Java/0140__Collections/0280__HashMap.htm
 */
public class ImplementationsMap {
   
   private static final Logger logger = LoggerFactory.getLogger(ImplementationsMap.class);
   private static Random rand = new Random();
   
   /** View operations
    * All keys and all <key, value> pairs are always unique in a Map and returned as Set views. 
    * Since a Map may contain duplicate values, it returns a Collection view for the values.
    *  
    * Set<K> keySet() - all keys in a Map as a Set, 
    * Collection<V> values() - all values as a Collection, 
    * all <key, value> pairs as a Set - Set<Map.Entry<K,  V>> entrySet() 
    */
   public static void mapIteration() {
      Map<String, String> mymap = new HashMap<>();
      
      mymap.put("CSS", "style");
      mymap.put("HTML", "mark up");
      mymap.put("Oracle", "database");
      mymap.put("XML", "data");      
      logger.info("Map: " + mymap);
      /*
I|ImplementationsMap                      |Map: {HTML=mark up, CSS=style, Oracle=database, XML=data}      
      */
      
      // Iterating over key/values pairs  
      for (Map.Entry<String, String> entry : mymap.entrySet()) {
         String key = entry.getKey();
         String value = entry.getValue();
         logger.info("key: "+ key +" value: "+value);
      }      
      /*
I|ImplementationsMap                      |key: HTML value: mark up
I|ImplementationsMap                      |key: CSS value: style
I|ImplementationsMap                      |key: Oracle value: database
I|ImplementationsMap                      |key: XML value: data      
      */
      logger.info("\n" );
      
      // HOW TO PRINT ALL VALUES OF A MAP.
      Collection<String> values = mymap.values();
      for(String myValue: mymap.values()) {
         logger.info("  >>> Solution 1: value: "+ myValue);
      }
      /*
I|ImplementationsMap                      |  >>> Solution 1: value: mark up
I|ImplementationsMap                      |  >>> Solution 1: value: style
I|ImplementationsMap                      |  >>> Solution 1: value: database
I|ImplementationsMap                      |  >>> Solution 1: value: data      
      */
      
      // HOW TO PRINT ALL KEYS OF A MAP.
      // Get the set of keys
      Set<String> keys  = mymap.keySet();
      // Print all keys  using the   for method.
      for (String myStr : mymap.keySet()) {
         logger.info("  >>> Solution 1: key: "+ myStr);
      }
      /*
I|ImplementationsMap                      |  >>> Solution 1: key: HTML
I|ImplementationsMap                      |  >>> Solution 1: key: CSS
I|ImplementationsMap                      |  >>> Solution 1: key: Oracle
I|ImplementationsMap                      |  >>> Solution 1: key: XML      
      */
      
      //Solution 2. iterate over a Map
      for (Iterator<String> it = mymap.keySet().iterator(); it.hasNext();) {
         logger.info("  >>> Solution 2: key: "+ it.next());
      }
      /*
I|ImplementationsMap                      |  >>> Solution 2: key: HTML
I|ImplementationsMap                      |  >>> Solution 2: key: CSS
I|ImplementationsMap                      |  >>> Solution 2: key: Oracle
I|ImplementationsMap                      |  >>> Solution 2: key: XML      
      */
   }
   
   
   public static void operations() {
      HashMap<String, String> hMap  =  new HashMap<>();
      
      hMap.put("1", "one");
      hMap.put("2", "Two");
      hMap.put("3", "Three");
      hMap.put(null, null); // We can put null values in key and values. With Hashtable is not possible.
      
      //Get Set view of Keys from HashMap
      Set<String> keyM = hMap.keySet();
      Iterator<String> it = keyM.iterator();
      while(it.hasNext()) {
         logger.info(" Keys from HashMap "+it.next());
      }
      // remove "2" from Set, remove from Map too.
      keyM.remove("2");
      logger.info(" Keys is still in HashMap: "+ hMap.containsKey("2"));
      /*
      I|ImplementationsMap                      | Keys from HashMap 3
I|ImplementationsMap                      | Keys from HashMap 2
I|ImplementationsMap                      | Keys from HashMap 1
I|ImplementationsMap                      | Keys is styll in HashMap false      
      */
      
      //Get Synchronized Map from HashMap
      Map sMap = Collections.synchronizedMap(hMap);
      
      //Cloning Hash Map: public Object clone(). If the reference is "Map" insted of "HashMap" the clone() don't existe.
      HashMap<String, String> secondHmap = (HashMap<String, String>)hMap.clone();
      
      
   }
   
   //If key is not in add the key value pair
   public static void countRandom() {
      Map<Integer, Counter> hm = new HashMap<>();
      
      for (int i = 0; i < 10; i++) {
         // Produce a number between 0 and 3:
         Integer r = new Integer(rand.nextInt(3));
         logger.info(" randum number is: "+r);
         if (hm.containsKey(r)) {
            Counter obj = (Counter) hm.get(r);
            obj.count = obj.count + 1;
            //the short way: ((Counter) hm.get(r)).count++;
      } else {
            hm.put(r, new Counter());}
      }
      logger.info(" Map hm is:  "+hm); 
      /*
I|ImplementationsMap                      | randum number is: 2
I|ImplementationsMap                      | randum number is: 2
I|ImplementationsMap                      | randum number is: 1
I|ImplementationsMap                      | randum number is: 1
I|ImplementationsMap                      | randum number is: 1
I|ImplementationsMap                      | randum number is: 2
I|ImplementationsMap                      | randum number is: 2
I|ImplementationsMap                      | randum number is: 1
I|ImplementationsMap                      | randum number is: 1
I|ImplementationsMap                      | randum number is: 0
I|ImplementationsMap                      | Map hm is:  {0=1, 1=5, 2=4} 
     1 + 5 + 4 = 10. The number of "for" iterations.
      */
   }
   
   /**
    * @param args
    */
   public static void main(String[] args) {
      // 
      //mapIteration();
      //operations();
      countRandom();
   }   
}

class Counter {
   int count = 1;

   public String toString() {
     return Integer.toString(count);
   }
 }
