package com.work.collections;

import java.util.Comparator;

/**
 * Class implementation of Comparator interface that will compare two Employees object 
 * first on their id and if they are same, then on name. 
 *
 */
public class EmployeeComparatorByIdAndName implements Comparator<Employee> {

   @Override
   public int compare(Employee o1, Employee o2) {

      if (o1.getId() == o2.getId()) {         
         return o1.getName().compareToIgnoreCase(o2.getName());            
      } else {
         return o1.getId() - o2.getId();
      }
   }



}
