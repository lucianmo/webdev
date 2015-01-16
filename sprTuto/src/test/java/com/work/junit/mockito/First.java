package com.work.junit.mockito;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
 
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;

import org.junit.Test;

/**
 * http://gojko.net/2009/10/23/mockito-in-six-easy-examples/
 *
 */
public class First {

   /**
    * To create a stub (or a mock), use mock(class). Then use when(mock).thenReturn(value) to specify the stub value for a method. 
    * If you specify more than one value, they will be returned in sequence until the last one is used, after which point the 
    * last specified value gets returned.
    */
   @SuppressWarnings("unchecked")
   @Test
   public final void iterator_will_return_hello_world() {
      //arrange.  
      Iterator<String> i = mock(Iterator.class);
      when(i.next()).thenReturn("Hello", "World");

      //act. The actual string will be made when next() method is called, two times.
      String actuals=i.next()+" "+i.next();
      
      //assert
      assertEquals("Hello World", actuals);
   }

   /**
    * Stubs can also return different values depending on arguments passed into the method.
    * This creates a stub Comparable object and returns 1 if it is compared to a particular String value "Test". 
    */
   @Test
   public void with_arguments(){
      @SuppressWarnings("unchecked")
      Comparable<String> c=mock(Comparable.class);
      when(c.compareTo("Test")).thenReturn(1);
      assertEquals(1,c.compareTo("Test"));
   }
   
   /**
    * If the method has arguments but you really don’t care what gets passed or cannot predict it, use anyInt()
    *  (and alternative values for other types).
    */
   @SuppressWarnings("unchecked")
   @Test
   public void with_unspecified_arguments(){      
      Comparable<Integer> c=mock(Comparable.class);
      when(c.compareTo(anyInt())).thenReturn(-1);
      assertEquals(-1,c.compareTo(5));
   }   

   /**
    * When method to test, return "void" the when(mock).thenReturn(value) syntax don't work.
    * The alternative syntax is doReturn(result).when(mock_object).void_method_call().
    * Instead of returning, you can also use .thenThrow() or doThrow() for void methods.
    * This example throws an IOException when the mock OutputStream close method is called.
    * @throws IOException
    */
   @Test(expected=IOException.class)
   public void OutputStreamWriter_rethrows_an_exception_from_OutputStream() 
      throws IOException{
      OutputStream mock=mock(OutputStream.class);
      OutputStreamWriter osw=new OutputStreamWriter(mock);
      doThrow(new IOException()).when(mock).close();
      osw.close();
   }
   
}
