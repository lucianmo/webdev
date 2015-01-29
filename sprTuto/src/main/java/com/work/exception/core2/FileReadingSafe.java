package com.work.exception.core2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.core.joran.conditional.IfAction;

public class FileReadingSafe {

   private static final Logger logger = LoggerFactory.getLogger(FileReadingSafe.class);
   
   
   /**
    * The last exception thrown in a try-catch-finally block is
    * the exception that will be propagated up the call stack.
    * All earlier exceptions will disappear.
    * @param path
    * @param fileName
    */
   public static void readFileBuffered (String path, String fileName) {
      // Stream to read file
      FileInputStream fin = null;
      BufferedReader reader = null;
      
      try {
         // Open an input stream
         fin = new FileInputStream (path+fileName);         
         reader = new BufferedReader(new InputStreamReader(fin));
         
         logger.info("Reading File line by line using BufferedReader\n");
         String line = reader.readLine();
         
         while (line != null) {
            logger.info(line);
            line = reader.readLine();      
         }
         
      } catch ( FileNotFoundException efnt) {
         throw new WrappingUnchecked("In FileNotFoundException", efnt);
      } catch (IOException eio) {
         throw new WrappingUnchecked("In FileNotFoundException", eio);         
      } finally {
         /*Never throw any exception from finally block. The original first exception (correct reason from catch) will be lost forever. 
           Insted either Handle it, or log it. */
         if (reader != null) {
            try {
               reader.close();
            } catch (Exception e) {
               logger.error(" >>> BufferedReader was't closed!");
            } 
         }
         
         if (fin != null)  {
            try {
               fin.close();
            } catch (Exception e) {
               logger.error(" >>> FileInputStream was't closed!");
            }
         }    
      }
   }
   
   /**
    * @param args
    */
   public static void main(String[] args) {
      readFileBuffered("src/main/resources/flat/","myTest.txt");
      logger.info("       >>> End main methode \n");

   }

}
