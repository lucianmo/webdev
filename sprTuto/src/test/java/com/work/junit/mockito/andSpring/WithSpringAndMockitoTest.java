package com.work.junit.mockito.andSpring;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:/hello/beansCalculator.xml"})   //specifies the path of spring bean definition.
@RunWith(SpringJUnit4ClassRunner.class)                                       // makes the class is runned with SpringJUnit4ClassRunner
public class WithSpringAndMockitoTest {

   @Mock
   Rectangle rectangle; // create Mock for rectangle class
   
   /**
    * Mockito will try to inject mocks by Property setter injection.
    * @InjectMocks annotation of Mockito inject mocked rectangle object into calculator bean.
    */
   @InjectMocks
   @Autowired
   Calculator calculator;
   
   @Before
   public void create() {
      initMocks(this);// Initialise this mock objects      
   }
   
   @Test
   public void testCalucator() {
      //rectangle is a Mock. It's not a instance of the bean from "hello/beansCalculator.xml".
      //Look at the difference between values of length in Mock (value=12) and in Spring Container(value=10).
      when(rectangle.getLength()).thenReturn(12);
      when(rectangle.getBreadth()).thenReturn(5);
      //
      assertEquals(60, calculator.getArea());
   }

}
