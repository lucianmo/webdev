package com.work.junit;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MatchesRegex {

   
   private static final Logger logger = LoggerFactory.getLogger(MatchesRegex.class);
   private static Pattern myPatternName;
 
   //Examples: [hc]+at matches "hat", "cat", "hhat", "chat", "hcat", "cchchat", and so on, but not "at".
   private static final String FUNNY_PATTERN = "[hc]+at";
 
   static {
      myPatternName = Pattern.compile(FUNNY_PATTERN);
   }
   
   public static boolean isValidThisString (String toTest) {
      return myPatternName.matcher(toTest).find();
   }
   
   public static void main (String[] arg) {
      logger.info("<hat> is valid ? "+isValidThisString("hat"));
      logger.info("<at> is valid ? "+isValidThisString("at"));
   }
}
