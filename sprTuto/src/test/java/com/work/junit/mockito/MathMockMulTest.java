package com.work.junit.mockito;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * 
 * @author myname
 *
 */
public class MathMockMulTest {

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
      //Multiply any number with zero. The function should return zero.
      //The static method anyInt accepts any argument as input and static method eq checks that the argument is zero. 
      when(mathObj.add(anyInt(), eq(0))).thenReturn(0);
   }
   
   /**
    * Test the Multiply function in math object return zero if one of the argument is zero
    */
   @Test
   public void testMul() {
      assertSame(0, mathObj.add(10,0));
      assertSame(0, mathObj.add(-5,0));
   }

}
