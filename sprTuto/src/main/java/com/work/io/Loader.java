package com.work.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Loader {

   
   private static final Logger logger = LoggerFactory.getLogger(Loader.class);
   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      //InputStream is =  ClassLoader.getSystemClassLoader().getResourceAsStream("resources/flat/myTest.txt");
      
      //InputStream is = Loader.class.getResourceAsStream("myFile.txt");
      
//      InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("myFile_3.txt");
//      if(is == null)
//         logger.info("input stream is null");
//      else
//        logger.info("input stream is NOT null. OK!!!"); 
      
      Properties prop = new Properties();
      String filePath = "";
      try {
         
         InputStream inputStream = Loader.class.getClassLoader().getResourceAsStream("config.properties");
     
         prop.load(inputStream);
         filePath = prop.getProperty("json.filepath");
     
       } catch (IOException e) {
          e.printStackTrace();
       }
     
      logger.info(" filePath: "+ filePath);      
      
      
   }

}
