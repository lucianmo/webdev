package com.work.exception.core1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.work.junit.First;

public class FirstTest {
   
   private static final Logger logger = LoggerFactory.getLogger(FirstTest.class);
   
   
   @Test(expected = IllegalArgumentException.class)
   public void testExceptionIsThrown() {
      First anIstance = new First();
      anIstance.multiply(1000, 50);
   }
   
   @Test
   public void testMultiply() {
      First anIstance = new First();
      assertEquals("10 x 5 must be 50", 50, anIstance.multiply(10, 5));
   }

}
