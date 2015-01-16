package com.work.junit.mockito;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Often In the Test Driven Development we will not have Math class before we write tests around it. 
 *
 */
public class MathTest {

   private Math mathObj;
   
   /**
    * Create Math object before you use them.
    */
   @Before
   public void set() {
      mathObj = new Math();
   }
   
   @Test
   public void testAdd() {
      assertEquals(8, mathObj.add(3,5));
   }

}
