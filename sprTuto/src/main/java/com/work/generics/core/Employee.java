package com.work.generics.core;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {

   private String name;
   private double salary;
   private Date hireDay;

   /**
    * Constructor
    * @param name    the employee's name
    * @param salary  the salary
    * @param year    the hire year
    * @param month   the hire month
    * @param day     the hire day
    */
   public Employee(String name, double salary, int year, int month, int day) {
      this.name = name;
      this.salary = salary;
      GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);
      this.hireDay = calendar.getTime();
   }

   public String getName() {
      return name;
   }

   public double getSalary() {
      return salary;
   }

   public Date getHireDay() {
      return hireDay;
   }
   
   public void raiseSalary(double byPercent) {
      double raise = salary * byPercent / 100;
      salary += raise;
   }
   
}
