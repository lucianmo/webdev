package com.work.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatchesNo2Test {

   //Examples: [hc]+at matches "hat", "cat", "hhat", "chat", "hcat", "cchchat", and so on, but not "at".
   @Test
   public void testIsValidThisString() {
      assertEquals("<hat> match [hc]+at", true, MatchesRegex.isValidThisString("hat"));
      assertEquals("<chat> match [hc]+at", true, MatchesRegex.isValidThisString("chat"));      
      assertEquals("<at> match [hc]+at", true, MatchesRegex.isValidThisString("at"));
   }

}
