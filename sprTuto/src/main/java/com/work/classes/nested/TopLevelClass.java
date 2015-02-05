package com.work.classes.nested;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.work.collections.Employee;

/**
 * http://www.journaldev.com/996/java-nested-classes-java-inner-class-static-nested-class-local-inner-class-and-anonymous-inner-class
 * For anonymous inner class, see:
 * http://www.programmerinterview.com/index.php/java-questions/java-anonymous-class-example/
 * http://www.programmerinterview.com/index.php/java-questions/anonymous-class-interface/
 */
public class TopLevelClass {
   
   private static final Logger logger = LoggerFactory.getLogger(TopLevelClass.class);
   
   private int privateMemberVariable = 100;
   private static String nameClass = "TopLevelClass";
   
   private   int tlcPrivate;
   protected int tlcProtected;
   int           tlcPackage;
   public int    tlcPublic;   

   public TopLevelClass() {}
   
   public TopLevelClass(int tlcPrivate ,int tlcProtected, int tlcPackage, int tlcPublic) {
      setTlcPrivate(tlcPrivate);
      this.tlcProtected = tlcProtected;
      this.tlcPackage = tlcPackage;
      this.tlcPublic = tlcPublic;
   }
   
   public int getTlcPrivate() {
      return tlcPrivate;
   }

   public void setTlcPrivate(int tlcPrivate) {
      this.tlcPrivate = tlcPrivate;
   }   
   
   @Override
   public String toString() {
      return "TopLevelClass [tlcPrivate=" + tlcPrivate + ", tlcProtected="
            + tlcProtected + ", tlcPackage=" + tlcPackage + ", tlcPublic="
            + tlcPublic + "]";
   }



   /** Example of STATIC NESTED CLASS
    * A static nested class is essentially a normal class that has just been nested inside another class. 
    * static nested class, can access TopLevelClass STATIC variables/methods
    */
   static class StaticNestedClass {
      private   int sncPrivate;
      protected int sncProtected;
      int           sncPackage;
      public    int sncPublic;
      
      //TopLevelClass STATIC variables
      public String getName() {
         return nameClass;
      }      
      
      //access the private members of their enclosing class (only via the use of an object instance)
      public void printPrivateVariables() {
         TopLevelClass topLevel = new TopLevelClass();
         logger.info("privateMemberVariable in StaticNestedClass: "+ topLevel.privateMemberVariable);
      }
      
   }
   
   /** Example of INNER CLASS, non static.
    * Can access all the variables/methods of outer class.
    * Since inner classes are associated with instance, we can’t have any static variables in them.
    *
    */
   class InnerClass {
      private   int icPrivate;
      protected int icProtected;
      int           icPackage;
      public    int icPublic;

      //ERROR: The field "toto" cannot be declared static in a non-static inner type, unless initialized with a constant expression
      //public static String toto = ""; 
      
      public InnerClass() {}
      
      public InnerClass(int icPrivate, int icProtected, int icPackage,
            int icPublic) {
         this.icPrivate = icPrivate;
         this.icProtected = icProtected;
         this.icPackage = icPackage;
         this.icPublic = icPublic;
      }
      
      //Access the private members of their enclosing class
      public void getPrivateMemberVariable () {
         logger.info("privateMemberVariable in InnerClass: "+ privateMemberVariable);
      }

      @Override
      public String toString() {
         return "InnerClass [icPrivate=" + icPrivate + ", icProtected="
               + icProtected + ", icPackage=" + icPackage + ", icPublic="
               + icPublic + "]";
      }
            
   }
   
   /**Anonymous inner class that implement "Comparator" interface.
    * The code below is actually creating an instance of an anonymous inner class that implements the Comparator interface.
    * The class that is being instantiated (where "sortByTlcPrivate" is the instance variable) is anonymous because it has no name. 
    * This means that we are SIMULTANEOUSLY creating an anonymous class that implements the Comparator interface 
    * and also creating an instance of that anonymous class.
    */
   public static Comparator<TopLevelClass> sortByTlcPrivate = new Comparator<TopLevelClass>() {
      @Override      
      public int compare(TopLevelClass obj1, TopLevelClass obj2) {          
         return (int)(obj1.getTlcPrivate() - obj2.getTlcPrivate());
      }
   };
   
   /**
    * Test INSIDE the TopLevelClass code (outer class) 
    * 
    */
   public static void main(String args[]) {
      //STATIC NESTED CLASSES EXAMPLE.
      StaticNestedClass staticNested = new StaticNestedClass();
      staticNested.printPrivateVariables();
      /*
 I|TopLevelClass                           |privateMemberVariable: 100     
      */
      staticNested.sncPublic = 10; 
      logger.info("Static nested class public value for FIRST instance: "+ staticNested.sncPublic);
      
      StaticNestedClass newStaticNested = new StaticNestedClass();
      logger.info("Static nested class public value for SECOND instance: "+ newStaticNested.sncPublic);
      /*
I|TopLevelClass                           |static nested class public value for FIRST instance: 10
I|TopLevelClass                           |Static nested class public value for SECOND instance: 0      
      */
      
      //INNER CALSS EXAMPLE
      TopLevelClass myTopLevelObject = new TopLevelClass();
      InnerClass myInnerObject = myTopLevelObject.new InnerClass();
      myInnerObject.getPrivateMemberVariable();
      /*
 I|TopLevelClass                           |privateMemberVariable in InnerClass: 100     
      */
      
      //ANONYMOUS INNER CLASS
      TopLevelClass objTop1 = new TopLevelClass(20, 1,1,1);
      TopLevelClass objTop2 = new TopLevelClass(10, 1,1,2);
      TopLevelClass objTop3 = new TopLevelClass(30, 1,1,3);
      List<TopLevelClass> myList = new ArrayList<TopLevelClass>();
      myList.add(objTop1);myList.add(objTop2);myList.add(objTop3);
      
      Collections.sort(myList, sortByTlcPrivate);
      logger.info("After sort by TlcPrivate: "+myList);
      /*
I|TopLevelClass                           |After sort by TlcPrivate: [TopLevelClass [tlcPrivate=10, tlcProtected=1, tlcPackage=1, tlcPublic=2], TopLevelClass [tlcPrivate=20, tlcProtected=1, tlcPackage=1, tlcPublic=1], TopLevelClass [tlcPrivate=30, tlcProtected=1, tlcPackage=1, tlcPublic=3]]      
      */
   }
}

/**
 * Test OUTSIDE the TopLevelClass code (outer class)
 */
class NestedClassTest { 
   
   private static final Logger logger = LoggerFactory.getLogger(NestedClassTest.class);
   
   public static void main(String[] args) {
      /** STATIC NESTED CLASSES EXAMPLE.
       * Static nested classes can’t directly access the members of the class that they are defined in,
       * but they can do so using an object instance of the enclosing top-level-class.
       * Obtain an instance of a static nested class from within code defined outside the enclosing class
       */
      TopLevelClass.StaticNestedClass staticNestedInstance = new TopLevelClass.StaticNestedClass();
      logger.info("Top Class name: "+ staticNestedInstance.getName());
      /*
I|NestedClassTest                         |Top Class name: TopLevelClass      
      */
      
      /** INNER CLASSES EXAMPLE.
       * Object of inner class are part of the outer class object and to create an instance of inner class, 
       * we first need to create instance of outer class. 
       */
      TopLevelClass.InnerClass secondInnerObject = new TopLevelClass().new InnerClass(10,20,30,40);
      secondInnerObject.getPrivateMemberVariable();
      logger.info("secondInnerObject: "+ secondInnerObject.toString());
      /*
I|TopLevelClass                           |privateMemberVariable in InnerClass: 100 
I|NestedClassTest                         |secondInnerObject: InnerClass [icPrivate=10, icProtected=20, icPackage=30, icPublic=40]     
      */
            
      //ANONYMOUS INNER CLASS EXAMPLE
      TopLevelClass objTop1 = new TopLevelClass(20, 1,1,1);
      TopLevelClass objTop2 = new TopLevelClass(10, 1,1,2);
      TopLevelClass objTop3 = new TopLevelClass(30, 1,1,3);
      List<TopLevelClass> myList = new ArrayList<TopLevelClass>();
      myList.add(objTop1);myList.add(objTop2);myList.add(objTop3);
      
      Collections.sort(myList, TopLevelClass.sortByTlcPrivate);
      logger.info("After sort by TlcPrivate: "+myList);
      /*
I|NestedClassTest                         |After sort by TlcPrivate: [TopLevelClass [tlcPrivate=10, tlcProtected=1, tlcPackage=1, tlcPublic=2], TopLevelClass [tlcPrivate=20, tlcProtected=1, tlcPackage=1, tlcPublic=1], TopLevelClass [tlcPrivate=30, tlcProtected=1, tlcPackage=1, tlcPublic=3]]      
      */
   }
}
