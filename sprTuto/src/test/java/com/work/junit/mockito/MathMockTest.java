package com.work.junit.mockito;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.work.junit.mockito.Math; 
import static org.mockito.Mockito.*;

/**
 * Often In the Test Driven Development we will not have "Math" class before we write tests around it. 
 * The "add" method was changed to return a "null" value instead calculate the sum.
 * Important to bear in mind is - we never creating a Math concrete object it is only creating Math mock object. 
 */
public class MathMockTest {
   private Math mathObj;

   @Before
   public void create()  {
      //arrange.
      mathObj = mock(Math.class);  //Create Math mock Object 
      //The static method when defines the behavior of add method.
      when(mathObj.add(1, 2)).thenReturn(3);
   }
   
   @Test
   public void testAdd() {
      //We use the mock object that don't implement the sum operation.
      assertSame(3, mathObj.add(1, 2));
   }
   
}
