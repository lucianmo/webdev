package com.work.generics.core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PairV1Test {
   
   private static final Logger logger = LoggerFactory.getLogger(PairV1Test.class);
   
   /**
    * Gets the minimum and maximum of an array of strings.
    * @param stringsArray - an array of strings
    * @return - a pair with the min and max value, or null if a is null or empty
    */
   public static PairV1<String> minmax (String[] stringsArray ) {
      if (stringsArray == null || stringsArray.length == 0) return null;
      
      String min = stringsArray[0];
      String max = stringsArray[0];
      
      for(int k=1; k<stringsArray.length; k++) {
         if(min.compareTo(stringsArray[k])>0) min = stringsArray[k];
         if(max.compareTo(stringsArray[k])<0) max = stringsArray[k];
      }
      
      return new PairV1<String>(min, max);
   }
   
   /**
    * This method needs to place RESTRICTIONS on type variables.
    * The variable "min" has type T, which means that it could be an object of an arbitrary class.
    * How do we know that the class to which "T" belongs has a compareTo method?
    * The solution is to RESTRICT "T" to a class that implements the Comparable interface.
    * A standard interface with a single method, compareTo. 
    * 
    *    public static <T extends Comparable<T>> PairV1<T> minmaxOfCalendar ... 
    * 
    * It would work fine for many classes. For example, if you compute the minimum of a String array, 
    * then T is the type String, and String is a subtype of Comparable<String>. Or for Calendar that implements Comparable<Calendar>.
    * 
    * @param calendarArray
    * @return
    */
   public static <T extends Comparable<T>> PairV1<T> minmaxOfCalendar (T[] calendarArray) {
      if (calendarArray == null || calendarArray.length == 0) return null;
      
      T min = calendarArray[0];
      T max = calendarArray[0];      
      
      for(int k=1; k<calendarArray.length; k++) {
         if (min.compareTo(calendarArray[k])>0) min = calendarArray[k];
         if (max.compareTo(calendarArray[k])<0) max = calendarArray[k];
      }
      return new PairV1<T>(min, max);
   }   
   
   
   /**
    * But we run into a problem when processing an array of GregorianCalendar objects. 
    * As it happens, GregorianCalendar is a subclass of Calendar, and Calendar implements Comparable<Calendar>. 
    * Thus, GregorianCalendar implements Comparable<Calendar> but not Comparable<GregorianCalendar>.
    * In a situation we use: Comparable<? super T>. <? super T> means T or a superclass. 
    * To summarise, this says first that the type T must implement Comparable. 
    * Then, the type variable declaration states "T is a type that is comparable to itself or to some superclass of itself."
    * 
    *    public static <T extends Comparable<? super T>> PairV1<T> minmaxOfObjects
    * 
    * Now the compareTo method has the form: int compareTo(? super T)
    * That means the "?" can be an object of type T, or—for example, 
    * when T is GregorianCalendar — a supertype of T. 
    * 
    * @param objArray - an array of Object that implement Interface Comparable
    * @return - a pair with the min and max value, or null if a is null or empty
    */
   public static <T extends Comparable<? super T>> PairV1<T> minmaxOfObjects (T[] objArray) {
      if (objArray == null || objArray.length == 0) return null;
      
      T min = objArray[0];
      T max = objArray[0];      
      
      for(int k=1; k<objArray.length; k++) {
         if (min.compareTo(objArray[k])>0) min = objArray[k];
         if (max.compareTo(objArray[k])<0) max = objArray[k];
      }
      return new PairV1<T>(min, max);
   }
   
   public static void main(String[] args) {
      // TEST METHODE minmax
      String[] myTest = new String[] {"un","deux","trois","quatre","cinq"};
      
      PairV1<String> calcule = minmax (myTest);
      logger.info("  >>> Le 'min' est: "+calcule.getFirst()+" et le 'max' est: "+calcule.getSecond());
      /*
I|PairV1Test                              |  >>> Le 'min' est: cinq et le 'max' est: un      
      */
      
      // TEST METHODE minmaxOfCalendar
      Calendar[] lotOfCalendar = {
            new GregorianCalendar(1903, Calendar.DECEMBER, 19), 
            new GregorianCalendar(1990, Calendar.JANUARY, 12),
            new GregorianCalendar(1905, Calendar.SEPTEMBER, 7), 
            new GregorianCalendar(1910, Calendar.JUNE, 3)  
      };
      PairV1<Calendar> calculateCalendar = minmaxOfCalendar(lotOfCalendar);
      SimpleDateFormat date_format = new SimpleDateFormat("MMM dd, yyyy");
      logger.info("  >>> Min Date: "+ date_format.format(calculateCalendar.getFirst().getTime()));
      logger.info("  >>> Min Date: "+ date_format.format(calculateCalendar.getSecond().getTime()));
      /*
I|PairV1Test                              |  >>> Min Date: Dec 19,1903
I|PairV1Test                              |  >>> Min Date: Jan 12,1990      
      */
      
      // TEST METHODE minmaxOfObjects
      GregorianCalendar[] objDate = {
            new GregorianCalendar(1907, Calendar.DECEMBER, 19), 
            new GregorianCalendar(1900, Calendar.FEBRUARY, 12),
            new GregorianCalendar(1907, Calendar.SEPTEMBER, 7), 
            new GregorianCalendar(1912, Calendar.JUNE, 3)
      };
      PairV1<GregorianCalendar> calculateGregorianDate = minmaxOfObjects(objDate);
      logger.info("  >>> Min Date: "+ date_format.format(calculateGregorianDate.getFirst().getTime()));
      logger.info("  >>> Min Date: "+ date_format.format(calculateGregorianDate.getSecond().getTime()));      
      /*
I|PairV1Test                              |  >>> Min Date: Feb 12, 1900
I|PairV1Test                              |  >>> Min Date: Jun 03, 1912      
      */
   }
}
