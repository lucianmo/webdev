package com.work.exception.core2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileReadingUnchecked {

   private static final Logger logger = LoggerFactory.getLogger(FileReadingUnchecked.class);
   
   /**
    * 
    * @param fileName
    * @param path
    * @throws WrappingException 
    */
   public static void readFile (String path, String fileName) {
      // Stream to read file
      FileInputStream fin = null;
      Scanner scanner = null;
      
      try {
         // Open an input stream
         fin = new FileInputStream (path+fileName);
         
         scanner = new Scanner(fin);
         
         logger.info("   >>> Start writing\n");
         while(scanner.hasNextLine()) {
            logger.info(scanner.nextLine());
         }
         scanner.close();
         fin.close();
         
      } catch (FileNotFoundException e) {
         //logger.info("       >>> catch FileNotFoundException FileInputStream: "+ fin + " Scanner: "+scanner);
         throw new WrappingUnchecked("In FileNotFoundException", e);
      } catch (IllegalStateException e) { 
         logger.info("       >>> catch IllegalStateException");
         throw new WrappingUnchecked("IllegalStateException", e);
      } catch (IOException e) {
         logger.info("       >>> catch IOException");
         throw new WrappingUnchecked("IOException", e);
      }  
      
      logger.info("       >>> End readFile methode \n");
   }
   
   /**
    * @param args
    * @throws WrappingException 
    */
   public static void main(String[] args) {
      
      readFile("src/main/resource/flat/","myTest.txt");
      try {
         readFile("src/main/resource/flat/","myTest.txt");
      } catch (WrappingUnchecked e) {
         //logger.info("  >>> catch WrappingException");
         e.printStackTrace();
      }
      logger.info("       >>> End main methode \n");
   }


}
