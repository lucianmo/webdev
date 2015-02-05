package com.work.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Implementations {

   
   private static final Logger logger = LoggerFactory.getLogger(Implementations.class);
   
   public static void findDuplicates() {
      
      String[] aLotOfWord = {"I","came","I","was","I","left"};
      
      // HashSet, which makes no guarantees as to the order of the elements in the Set.
      Set<String> noDupl =  new HashSet<String>(Arrays.asList(aLotOfWord));
      logger.info("With HashSet: "+noDupl.size() + " distinct words: " + noDupl);
      
      // TreeSet orders its elements based on their values
      Set<String> withTree =  new TreeSet<String>(Arrays.asList(aLotOfWord));
      logger.info("With TreeSet: "+withTree.size() + " distinct words: " + withTree);
      
      //LinkedHashSet keeps the element order as the elements were inserted. 
      Set<String> withLinkedHashSet =  new LinkedHashSet<String>(Arrays.asList(aLotOfWord));
      logger.info("With LinkedHashSet: "+withLinkedHashSet.size() + " distinct words: " + withLinkedHashSet);
      
      
   }
   
   /**
    * Sorting list of objects of Wrapper classes (String, Date, Integer)
    */
   public static void howToSort() {
      
      //Sort Array
      Integer[] myIntArray = {12, 7, 3, 40};
      logger.info("  >>> 'Array' Avant le sort: "+Arrays.toString(myIntArray));
      Arrays.sort(myIntArray);
      logger.info("  >>> 'Array' Apres le sort: "+Arrays.toString(myIntArray));
      
      // Sort Wrapper classes (String, Date, Integer). All Wrapper have implemented Comparable interface. 
      String[] myStrArray = new String[] {"M","O","L","D","V"};
      
      List<String> myList = new ArrayList<String>(Arrays.asList(myStrArray));
      logger.info("  >>> 'Collection' Avant le sort: "+myList);
      Collections.sort(myList);
      logger.info("  >>> 'Collection' Apres le sort: "+myList);
   }
   
   
   public static void sortArrayAndCollections () {
      Employee e1 = new Employee(30, "Toto", 20, 30000);
      Employee e2 = new Employee(10, "Zoro", 25, 40000);
      Employee e3 = new Employee(70, "Adam", 30, 50000);      
      Implementations myImpl = new Implementations(); 
      
      
      //Sort Array
      Employee[] allEmployee = {e1, e2, e3};
      logger.info("  >>> 'Array' Avant le sort by Id: "+Arrays.toString(allEmployee));
      //
      Arrays.sort(allEmployee);
      logger.info("  >>> 'Array' Apres le sort by Id: "+Arrays.toString(allEmployee));
      
      //Sort by Name. Employee.NameComparator is anonymous inner class. 
      Arrays.sort(allEmployee, Employee.NameComparator);
      logger.info("  >>> 'Array' Apres le sort by Name: "+Arrays.toString(allEmployee));
      
      // expand Array
      int arrayGrowth = 1;
      allEmployee = Arrays.copyOf(allEmployee, allEmployee.length + arrayGrowth);
      // Add element with the "Id" existing number 10.
      allEmployee[3] = new Employee(10, "Bebe", 3, 3000);
      for (Employee employee : allEmployee) {
         if (employee != null) System.out.println(" >>> "+employee.toString());
      }
      
      logger.info("Employees list sorted by ID and Name. Two maner to define a class that implement Comparator!");
      //Separate class implementation of Comparator interface that will compare two Employees object
      Arrays.sort(allEmployee, new EmployeeComparatorByIdAndName());
      
      //Inner class implementation of Comparator interface
      Arrays.sort(allEmployee, myImpl.new ComparatorByIdAndName());
      logger.info(Arrays.toString(allEmployee));
            
      //Class in the same file to implement Comparator interface
      Arrays.sort(allEmployee, new SameFileComparatorByIdAndName()); 
      logger.info(Arrays.toString(allEmployee));
   }
   
   /**
    * Inner class to implement Comparator<Employee>
    * First on their id and if they are same, then on name.
    */
   private class ComparatorByIdAndName implements Comparator<Employee> {

      @Override
      public int compare(Employee o1, Employee o2) {
         if (o1.getId() == o2.getId()) {         
            return o1.getName().compareToIgnoreCase(o2.getName());            
         } else {
            return o1.getId() - o2.getId();
         }
      }      
   }   
   /**
    * @param args
    */
   public static void main(String[] args) {
      findDuplicates();
      /*
I|Implementations                         |With HashSet: 4 distinct words: [left, came, I, was]
I|Implementations                         |With TreeSet: 4 distinct words: [I, came, left, was]
I|Implementations                         |With LinkedHashSet: 4 distinct words: [I, came, was, left]
       */
      howToSort();
      /*
I|Implementations                         |  >>> 'Array' Avant le sort: [12, 7, 3, 40]
I|Implementations                         |    >>> 'Array' Apres le sort: [3, 7, 12, 40]
I|Implementations                         |  >>> 'Collection' Avant le sort: [M, O, L, D, V]
I|Implementations                         |    >>> 'Collection' Apres le sort: [D, L, M, O, V]      
      */
      
      sortArrayAndCollections ();
      /*
I|Implementations                         |  >>> 'Array' Avant le sort by Id: [Employee [id=30, name=Toto, age=20, salary=30000], Employee [id=10, name=Zoro, age=25, salary=40000], Employee [id=70, name=Adam, age=30, salary=50000]]
I|Implementations                         |  >>> 'Array' Apres le sort by Id: [Employee [id=10, name=Zoro, age=25, salary=40000], Employee [id=30, name=Toto, age=20, salary=30000], Employee [id=70, name=Adam, age=30, salary=50000]]
I|Implementations                         |  >>> 'Array' Apres le sort by Name: [Employee [id=70, name=Adam, age=30, salary=50000], Employee [id=30, name=Toto, age=20, salary=30000], Employee [id=10, name=Zoro, age=25, salary=40000]]
 >>> Employee [id=70, name=Adam, age=30, salary=50000]
 >>> Employee [id=30, name=Toto, age=20, salary=30000]
 >>> Employee [id=10, name=Zoro, age=25, salary=40000]
 >>> Employee [id=10, name=Bebe, age=3, salary=3000]
I|Implementations                         |Employees list sorted by ID and Name:
I|Implementations                         |[Employee [id=10, name=Bebe, age=3, salary=3000], Employee [id=10, name=Zoro, age=25, salary=40000], Employee [id=30, name=Toto, age=20, salary=30000], Employee [id=70, name=Adam, age=30, salary=50000]]      
      */
   }

}

/**
 * One Java file can consist of multiple classes with the restriction that only one of them can be public.
 * Class in the same file, can be declared package (no access modifier).
 */
class SameFileComparatorByIdAndName implements Comparator<Employee> {

   @Override
   public int compare(Employee o1, Employee o2) {

      if (o1.getId() == o2.getId()) {         
         return o1.getName().compareToIgnoreCase(o2.getName());            
      } else {
         return o1.getId() - o2.getId();
      }
   }
}