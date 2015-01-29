package com.work.io;

import java.awt.image.BufferStrategy;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://docs.oracle.com/javase/tutorial/essential/io/datastreams.html
 *
 */
public class WithStream {
   
   private static final Logger logger = LoggerFactory.getLogger(WithStream.class);
   
   private static final String dataFile = "src/main/resources/flat/invoicedata.dta";
   
   private static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
   private static final int[] units = { 12, 8, 13, 29, 50 };
   private static final String[] descs = {
       "Java T-shirt",
       "Java Mug",
       "Duke Juggling Dolls",
       "Java Pin",
       "Java Key Chain"
   };
   
   /**
    * DataStreams uses one very bad programming technique: it uses floating point numbers to represent monetary values. (double, flot)
    *  In general, floating point is bad for precise values. It's particularly bad for decimal fractions, 
    *  because common values (such as 0.1) do not have a binary representation.
    * @throws FileNotFoundException 
    */
   public static void DosDisDemo() throws IOException {
   
      DataOutputStream dos = null;
      BufferedOutputStream buffOut = null;
      
      try {
         buffOut = new BufferedOutputStream(new FileOutputStream(dataFile), 2*1024);
         dos = new DataOutputStream(buffOut);
         
         for (int i = 0; i < prices.length; i++) {
            dos.writeDouble(prices[i]);
            dos.writeInt(units[i]);
            dos.writeUTF(descs[i]);
         }
         
         buffOut.flush();
         buffOut.close();
         
      } catch (IOException e) {
         logger.error("Error on write file invoicedata.dta. "+e.getMessage ());
         return;
      } finally {
         if (dos != null) {
            try {
               dos.close(); buffOut.close();
            } catch (IOException e2) {
               logger.error("Error on close DataOutputStream!");
            }
         }
      }
      
      logger.info("\n   >>> Begin read file on stream");
      DataInputStream in = null;
      double total = 0.0;
      try {
          in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));

          double price;
          int unit;
          String desc;

          try {
              while (true) {
                  price = in.readDouble();
                  unit = in.readInt();
                  desc = in.readUTF();
                  logger.info("prices: "+ price+" units: "+unit+" descs: "+desc);
                  total += unit * price;
              }
          } catch (EOFException e) { }
          logger.info("For a TOTAL of: "+ total);
      }
      finally {
          in.close();
      }      
      
   }

   /**
    * Convert InputStream in string.
    * @param is
    * @return String
    */
   public static String getStringFromInputStream(InputStream is) {
      
      BufferedReader br = null;
      StringBuffer sb = new StringBuffer();    
      
      String line;
      try {
         br = new BufferedReader(new InputStreamReader(is));
         
         // read InputStream with BufferedReader
         while ((line = br.readLine()) != null) {
            sb.append(line);
         }
         logger.info(" >>> Voila le string: "+sb.toString());
         
      } catch (IOException e) {
         logger.error(" >>> SEVERE Error on reading a stream "+e.getMessage());
      } finally {
         if (br != null) {
            try {
               br.close();
            } catch (IOException eio) {
               logger.error(" >>> Error on cloasing a stream "+eio.getMessage());
            }
         }   
      }
                     
      return sb.toString();
   }
 
   /**
    * shows the usage of java.io.ByteArrayOutputStream.write(byte[] b, int off, int len)
    * b -- The specified buffer
    * off -- Offset to start in the data (le décalage dans le début des données)
    * len -- The length of the bytes to write
    */
   public static void ByteArrayOutputStreamDemo() {
      
      byte[] bt = {63, 125, 84, 69};
      ByteArrayOutputStream baos = null;
      
      try {
         // Donc on commence avec 125, et on prend trois bytes: 125, 84, 69 
         baos = new ByteArrayOutputStream();
         baos.write(bt, 1, 3);
      } catch (Exception eio) {
         logger.error(" >>> Error on OutputStream "+eio.getMessage());
      } finally {
         if (baos != null) {
            try {
               baos.close();
            } catch (Exception e) {
               logger.error(" >>> Error: "+e.getMessage());
            }
         }
      }
      
      /**
       * read all the bytes in the output stream.
       * Closing a ByteArrayOutputStream has no effect. 
       * The methods in this class can be called after the stream has been closed without generating an IOException.
       */
      for (byte b : baos.toByteArray()) {
         logger.info(" >>> The value in ByteArray is: "+ b);
      }
      /*
      I|WithStream                              | >>> The value in ByteArray is: 125
      I|WithStream                              | >>> The value in ByteArray is: 84
      I|WithStream                              | >>> The value in ByteArray is: 69
      */
   }
   
   /**
    * demonstrate ByteArrayInputStream. Converting characters to Upper case
    */
   public static void ByteArrayInputStreamDemo() {
      byte[] bArray = {64, 101, 87};
      
      ByteArrayInputStream bais = new ByteArrayInputStream (bArray);
      
      int c;
      while ((c = bais.read()) != -1) {
         logger.info(" >>> The value of Byte[] is: "+ Character.toUpperCase((char)c));
      }
      /*
      I|WithStream                              | >>> The value of Byte[] is: @
      I|WithStream                              | >>> The value of Byte[] is: E
      I|WithStream                              | >>> The value of Byte[] is: W 
      */     
   }
   
   /**
    * @param args
    */
   public static void main(String[] args) {
      
/*      try {
         DosDisDemo();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      logger.info("Create file invoicedata.dta");
      
      // intilize an InputStream. Convert String into InputStream
      InputStream myStream = new ByteArrayInputStream("Takes a byte array as the parameter".getBytes());
      logger.info(" convert stream in streang: "+getStringFromInputStream(myStream)); */
      
      //
      ByteArrayOutputStreamDemo();
      
      //ByteArrayInputStreamDemo();
   }

}
