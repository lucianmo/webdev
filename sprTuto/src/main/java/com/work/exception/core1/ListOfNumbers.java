package com.work.exception.core1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListOfNumbers {

   private static final Logger logger = LoggerFactory.getLogger(ListOfNumbers.class);
   
   private static ArrayList<Integer> list;
   private static final int SIZE = 10;
   
   
   public ListOfNumbers() {
      list = new ArrayList<Integer>(SIZE);
      for (int i=0; i<SIZE;i++) {
         list.add(new Integer(i));
      }
   }

   /**
    * Implement try/catch/finally statement.
    * @throws IOException
    */
   public static void writeList() {
      
      PrintWriter out = null;
      
      try {
         logger.info("Entering try statement");
         //FileWriter throws IOException
         out = new PrintWriter(new FileWriter("src/main/resources/flat/OutFile.txt"));
         
         for (int i = 0; i < SIZE; i++) {
            //get(i) throw IndexOutOfBoundsException - if the index is out of range. 
            out.println("Value at: " + i + " = " + list.get(i));
         }
      } catch (IndexOutOfBoundsException e) {
         logger.error("Caught IndexOutOfBoundsException: " +  e.getMessage());
                     
      } catch (IOException e) {
         logger.error("Caught IOException: " +  e.getMessage());
                           
      } finally {
         /* The correct way to handle "out PrintWriter" is to check if references assigned inside the try block are null 
            before invoking any methods on them */         
         if (out != null) {
            logger.info("Closing PrintWriter");
            out.close();
         } 
         else {
            logger.info("PrintWriter not open");
         }
      }
   }
   
   /**
    * 
    * @throws IOException
    */
   public static void writeListWithThrow() throws IOException {
    //FileWriter throws IOException
      PrintWriter out = new PrintWriter(new FileWriter("src/main/resources/flat/OutFile.txt"));

      for (int i = 0; i < SIZE; i++) {
         //get(i) throw IndexOutOfBoundsException - if the index is out of range. 
         //Is a unchecked exception so we don't need to add in method signature.
         out.println("Value at: " + i + " = " + list.get(i));
      }
      out.close();
   }
   
   /**
    * @param args
    */
   public static void main(String[] args) {
      //
      writeList();
      
      //
      try {
         writeListWithThrow();
         logger.info("File was created! ");
      } catch (IOException e) {         
         e.printStackTrace();
      }
   }

}
