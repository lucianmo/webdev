package com.work.junit.jenkov;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MyUnitTest {

   private MyUnit forTest;
   
   @Before
   public final void setup() {
      forTest = new MyUnit();
   }
   

   @Test
   public final void testConcatenateNo1() {
 
      assertEquals("123end", forTest.concatenate("1","2","3","end"));
   }

   // Empty is not equal at null.
   @Test
   public final void testConcatenateNo2() {
 
      assertNull(forTest.concatenate(""));
   }   

   // Test Empty
   @Test
   public final void testConcatenateNo3() {
 
      assertThat("", IsEqual.equalTo(forTest.concatenate("")) );
   } 
   
   @Test
   public final void testGetStringArray() {
      String[] expecteds = new String[]{"La","multi","ani"};      
      
      assertArrayEquals(expecteds, forTest.getStringArray("La","multi","ani")); 
   }
}
