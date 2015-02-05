package com.work.collections;

import java.util.Comparator;

/**
 * Comparable.compareTo(Object o) method implementation can sort based on one field only.
 * 
 * But, in most real life scenarios, we want sorting based on different parameters.
 * For example: sort the employees based on Salary or sort them based on the age.
 */
public class Employee implements Comparable<Employee> {

   private int id;
   private String name;
   private int age;
   private long salary;
      
   public Employee(int id, String name, int age, long salary) {
      this.id = id;
      this.name = name;
      this.age = age;
      this.salary = salary;
   }
   
   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getAge() {
      return age;
   }
   public void setAge(int age) {
      this.age = age;
   }
   public long getSalary() {
      return salary;
   }
   public void setSalary(long salary) {
      this.salary = salary;
   }
   
   @Override
   public String toString() {
      return "Employee [id=" + id + ", name=" + name + ", age=" + age
            + ", salary=" + salary + "]";
   }
   
   /**
    * We should override compareTo method in such a way that it returns a negative integer, zero, or a positive integer 
    * if “this” object is less than, equal to, or greater than the object passed as argument.
    */
   @Override
   public int compareTo(Employee obj) {
      
      return this.id - obj.id;
   }

   /**
    * Comparator to sort employees list or array in order of Salary
    * anonymous inner class implementing Comparator interface
    */
   public static Comparator<Employee> SalaryComparator = new Comparator<Employee>() {
      @Override      
      public int compare(Employee obj1, Employee obj2) {          
         return (int)(obj1.getSalary() - obj2.getSalary());
      }
   };
   
   public static Comparator<Employee> NameComparator = new Comparator<Employee>() {
      @Override
      public int compare(Employee o1, Employee o2) {         
         return o1.getName().compareTo(o2.getName());
      }      
   };
   
}


