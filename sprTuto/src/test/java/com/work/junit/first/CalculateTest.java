package com.work.junit.first;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.work.junit.Calculate;

public class CalculateTest {

   private Calculate mytest;
   @Before
   public void setUp () {
      mytest = new Calculate();
   }
   
   @Test(expected=IllegalArgumentException.class)
   public void testDivisonWithOneNumber () {
      mytest.diviser(3);
   }
   
   @Test(expected=ArithmeticException.class)
   public void testDivisonByZero () {
      mytest.diviser(3,0);
   }
   
   @Test
   public void testDivisonThreeNumber () {
      assertEquals(5, mytest.diviser(50,5,2));
   }   
   
}
