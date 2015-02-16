package com.work.generics.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Manager.Manager;

public class PairTest3 {
   
   private static final Logger logger = LoggerFactory.getLogger(PairTest3.class);
   
   public static void main(String[] args) {
   
   Manager ceo =  new Manager("ChiefExecutive Officer", 50000, 1990, 01, 01);
   Manager cfo =  new Manager("ChiefFinancial Officer", 60000, 1993, 03, 03);
   PairV1<Manager> buddies = new PairV1<>(ceo, cfo);
   
   printBuddies(buddies);
   /*
I|PairTest3                               | ceo name: ChiefExecutive Officer - cfo name: ChiefFinancial Officer   
   */
   
   ceo.setBonus(1000000);
   cfo.setBonus(500000);
   Manager[] managers = { ceo, cfo };

   PairV1<Employee> result = new PairV1<>();
   
   
   }
   
   /**
    * Let’s say you want to write a method that prints out pairs of employees, like this:
    *    public static void printBuddies(Pair<Employee> p) {
    *       Employee first = p.getFirst();
    *       Employee second = p.getSecond();
    *       System.out.println(first.getName() + " and " + second.getName() + " are buddies.";
    *    }
    * You CANNOT pass a Pair<Manager> to that method.
    * There is no relationship between Pair<Manager> and Pair<Employee>, no matter how "Manager" and "Employee" are related
    * The solution is the wildcard type "?".
    *    Pair<? extends Employee>
    * denotes any generic Pair type whose type parameter "?" is a subclass of Employee, such as
    * Pair<Manager>, but not Pair<String>.  
    * Let us have a closer look at the type Pair<? extends Employee>. Its methods look like this:
    *    ? extends Employee getFirst() {return this.newValue;}
    *    void setFirst(? extends Employee) {this.first = newValue;}
    *  
    *  It is perfectly legal to assign the return value (this.newValue may be Employee or a subclass) of "getFirst" to an Employee reference.
    *  It's impossible to call the "setFirst" method. That generate a type error.
    *  The compiler only knows that it needs some subtype of Employee, but it doesn’t know which type.
    *  So wildcards with subtype bounds let you read from a generic object.
    */
   public static void printBuddies(PairV1<? extends Employee> buddies) {
      Manager ceo = (Manager) buddies.getFirst();
      Manager cfo = (Manager) buddies.getSecond();
      logger.info(" ceo name: "+ceo.getName() + " - cfo name: "+cfo.getName() );         
   }
   
   /**
    * supertype bound: <? super Manager> is restricted to all supertypes of Manager.
    * 
    * Intuitively speaking, wildcards with supertype bounds let you write to a generic object.
    *  
    *  
    * @param a
    * @param result
    */
   public static void minmaxBonus(Manager[] a, PairV1<? super Manager> result)
   {
      if (a == null || a.length == 0) return;
      Manager min = a[0];
      Manager max = a[0];
      for (int i = 1; i < a.length; i++)
      {
         if (min.getBonus() > a[i].getBonus()) min = a[i];
         if (max.getBonus() < a[i].getBonus()) max = a[i];
      }
      result.setFirst(min);
      result.setSecond(max);
   }
}
