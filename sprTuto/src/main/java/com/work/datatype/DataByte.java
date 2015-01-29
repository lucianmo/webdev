package com.work.datatype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataByte {

   private static final Logger logger = LoggerFactory.getLogger(DataByte.class);
   /**
    * @param args
    */
   public static void main(String[] args) {
      byte by = (byte) 'A';
      Byte by2 = new Byte(by);
      logger.info(" by2: "+by2.byteValue());
      
      Byte bObj2 = new Byte("4");
      logger.info(" bObj2: "+bObj2.byteValue());
      logger.info(" bObj2= "+bObj2);
      
      Byte bObj3 = (byte)'4';
      logger.info(" bObj3: "+bObj3.byteValue());
      
      //Convert byte to string
      byte b = 65;
      logger.info(">>> Convert byte 65 in String, is: "+new String(new byte[] {b}));
      
      //Convert String to byte[] array.
      String aLongString = "All hierarchy of classes to deal with Input and Output streams";
      byte[] anArray = aLongString.getBytes();
      logger.info(">>> Convert String 'All' in byte is: "+anArray[0]);

      /*
         I|DataByte                                | by2: 65
         I|DataByte                                | bObj2: 4
         I|DataByte                                | bObj2= 4
         I|DataByte                                | bObj3: 52
         I|DataByte                                |>>> Convert byte 65 in String, is: A
         I|DataByte                                |>>> Convert String 'All' in byte is: 65
       */
   }
}
