package com.work.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Parameterized.class)
public class CalculateParameterizedTest {
   
   private static final Logger logger = LoggerFactory.getLogger(CalculateParameterizedTest.class);
   private int expected;
   private int valNo1;
   private int valNo2;
   
   public CalculateParameterizedTest(int expected, int valNo1, int valNo2) {
      this.expected = expected;
      this.valNo1 = valNo1;
      this.valNo2 = valNo2;
   }

   private Calculate mytest;
   @Before
   public void setUp () {
      mytest = new Calculate();
   }

   @Parameters(name = "{index}: {0} = sum({1}+{2})")
   public static Collection addedNumbers () {
      return Arrays.asList(new Integer[][] {{101, 80,20},{13,10,3},{-8,-7,-1}});
   }

   @Test
   public void testSum() {
      
      logger.info("Addition with parameters : " + valNo1 + " and "+ valNo2);
      assertEquals(expected, mytest.sum(valNo1, valNo2));
   }

}
