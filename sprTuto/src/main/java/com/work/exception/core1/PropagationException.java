package com.work.exception.core1;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropagationException {

   private static final Logger logger = LoggerFactory.getLogger(PropagationException.class);
   
   public PropagationException() {
     
   }

   /**
    * @param args
    * @throws IOException 
    */
   public static void main(String[] args) throws IOException {
      try {
         callFunction(-10);
         callFunction(-7);
      } catch (FileNotFoundException ex) {
         ex.printStackTrace();         
      } catch (IOException eio) {
         eio.printStackTrace();
      }finally{
         logger.info("Releasing resources");         
      }
      callFunction(15);

   }

   
   public static void callFunction (Integer no) throws IOException {
      if (no < 0) {
         FileNotFoundException myexc = new FileNotFoundException("Negative Integer "+no);
         throw myexc;
      } else if (no > 10) {
         throw new IOException("Only supported for index 0 to 10");
      }
   }
   
}
