package com.work.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringMatcherTest {

   private StringMatcher instaceStrMath;
   
   @Before
   public void createInstance() {
      instaceStrMath = new StringMatcher();
   }
   
   @Test
   public final void testContainsTrue() {
      assertEquals("<Inca un test> don't match regex <.*true.*>", false, instaceStrMath.containsTrue("Inca un test"));
      assertEquals("<tata is true > match regex <.*true.*>", true, instaceStrMath.containsTrue("tata is true"));
      assertEquals("<avant true apres> match regex <.*true.*>", true, instaceStrMath.containsTrue("avant true apres"));
      assertEquals("<avant True apres> don't match regex <.*true.*>", false, instaceStrMath.containsTrue("avant True apres"));
   }

   @Test
   public final void testIsThreeLetters() {
      assertEquals("<BLA> match regex <[a-zA-Z]{3}>", true, instaceStrMath.isThreeLetters("BLA"));
      assertEquals("<t3i> don't match regex <[a-zA-Z]{3}>", false, instaceStrMath.isThreeLetters("t3i"));
   }

}
