package com.work.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class MatchesRegexTest {

   private String stringToTest;
   private boolean expected;
   
   public MatchesRegexTest(String stringToTest, boolean expected) {
      this.stringToTest = stringToTest;
      this.expected = expected;
   }

   //Examples: [hc]+at matches "hat", "cat", "hhat", "chat", "hcat", "cchchat", and so on, but not "at".
   @Parameters(name= "{index}: isValid({0})={1}")
   public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][] {
            { "hat", true },
            { "cat", true },
            { "hhat", true },
            { "cchchat", true },
            { "at", true }
      });
   }

   @Ignore
   @Test
   public void testIsValidThisString() {
      assertEquals(expected, MatchesRegex.isValidThisString(stringToTest));
   }

}
