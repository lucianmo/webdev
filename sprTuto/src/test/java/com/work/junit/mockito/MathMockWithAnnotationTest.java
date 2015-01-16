package com.work.junit.mockito;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Creates a mock object with Mockito Annotations 
 * 
 */

public class MathMockWithAnnotationTest {

   /**
    *  Create Math mock Object.
    *  We need to Initialise this mock objects in Before method.
    */
   @Mock
   Math mathObj; //
   
   /**
    * Create mock object before you use them.
    */
   @Before
   public void create() {
      initMocks(this);      
   }
   
   @Test
   public void testAdd() {
      when(mathObj.add(3,5)).thenReturn(8);
      assertSame(8, mathObj.add(3,5));
   }

   @Test
   public void testMul() {
      //Multiply any number with zero. The function should return zero.
      //The static method anyInt accepts any argument as input and static method eq checks that the argument is zero. 
      when(mathObj.add(anyInt(), eq(0))).thenReturn(0);      
      assertSame(0, mathObj.add(10,0));
      assertSame(0, mathObj.add(-5,0));
   }
   
   
}
