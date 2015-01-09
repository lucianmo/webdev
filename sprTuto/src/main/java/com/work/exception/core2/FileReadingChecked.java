package com.work.exception.core2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileReadingChecked {

   private static final Logger logger = LoggerFactory.getLogger(FileReadingChecked.class);
   
   /**
    * 
    * @param fileName
    * @param path
    * @throws WrappingException 
    */
   public static void readFile (String path, String fileName) throws WrappingException {
      // Stream to read file
      FileInputStream fin = null;
      Scanner scanner = null;
      
      try {
         // Open an input stream
         fin = new FileInputStream ("src/main/resource/flat/myTest.txt");
         
         scanner = new Scanner(fin);
         
         logger.info("   >>> Start writing\n");
         while(scanner.hasNextLine()) {
            logger.info(scanner.nextLine());
         }
         scanner.close();
         fin.close();
         
      } catch (FileNotFoundException e) {
         //logger.info("       >>> catch FileNotFoundException FileInputStream: "+ fin + " Scanner: "+scanner);
         throw new WrappingException("In FileNotFoundException", e);
      } catch (IllegalStateException e) { 
         logger.info("       >>> catch IllegalStateException");
         throw new WrappingException("IllegalStateException", e);
      } catch (IOException e) {
         logger.info("       >>> catch IOException");
         throw new WrappingException("IOException", e);
      }  
      
      logger.info("       >>> End readFile methode \n");
   }
   
   /**
    * @param args
    * @throws WrappingException 
    */
   public static void main(String[] args) {

      try {
         readFile("src/main/resource/flat/","myTest.txt");
      } catch (WrappingException e) {
         //logger.info("  >>> catch WrappingException");
         e.printStackTrace();
      }
      logger.info("       >>> End main methode \n");
   }

}
