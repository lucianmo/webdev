package com.work.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class First {

   
   private static final Logger logger = LoggerFactory.getLogger(First.class);  
   
   public First() {}

   /**
    * Use byte streams to perform input and output of 8-bit bytes.
    * @throws IOException
    */
   public static void readByteSteam () throws IOException {
      
      /* FileInputStream is meant for reading streams of raw bytes such as image data. 
       * For reading streams of characters, consider using FileReader.*/
      FileInputStream in = null;
      FileOutputStream out = null;
      
      try {
         in = new FileInputStream("src/main/resources/flat/myTest.txt");
         out = new FileOutputStream("src/main/resources/flat/myOutput.txt");         
         //the int 'byteread' variable holds a 'byte' value in its last 8 bits.
         int byteread;
         
         while ((byteread  = in.read()) != -1) {
            out.write(byteread);
         }         
      } finally {
         /* finally block guarantee that both streams will be closed even if an error occurs 
          * If 'readWriteFile' was unable to open one or both files, the stream variable corresponding to the file never changes from its initial "null" value.
          * That's why 'readWriteFile' makes sure that each stream variable contains an object reference before invoking close. 
          */
         if (in != null) {
            in.close();
         }
         if (out != null) {
            out.close();
         }         
      }
   }
   
   /**
    * Use characters streams to perform input and output of 16-bit bytes.
    * @throws IOException  
    */
   public static void readCharStream () throws IOException {
    //FileReader is meant for reading streams of characters. FileWriter is meant for writing streams of characters.
      FileReader inputStream = null;
      FileWriter outputStream = null;
      
      try {
         inputStream = new FileReader("src/main/resources/flat/myTest.txt");
         outputStream = new FileWriter("src/main/resources/flat/myCharOutput.txt");
         
         //We an int variable to read to and write from. The int variable 'charRead' holds a character value in its last 16 bits.
         int charRead ;
         
         while (( charRead = inputStream.read()) != -1) {
            outputStream.write(charRead);
         }
      } finally {
         if (inputStream != null) {
            inputStream.close();
         }
         if (outputStream != null) {
            outputStream.close();
         } 
      }
   }

   /**
    *  line-oriented I/O
    *  A line terminator can be a carriage-return/line-feed sequence ("\r\n"), a single carriage-return ("\r"), or a single line-feed ("\n").
    *  BufferedReader.readLine() - and automatically recognizes the end of line character.
    */
   public static void copyLineByLine()  {
      
      BufferedReader in = null;
      PrintWriter out = null;      
      
      try {
         in = new BufferedReader(new FileReader("src/main/resources/flat/myTest.txt"));
         out = new PrintWriter(new File("src/main/resources/flat/myLineByLine.txt"));
         
         String line;
         
         while ((line = in.readLine()) != null) {
            // outputs each line using println, which appends the line terminator for the current operating system.
            out.println(line);
         }
         
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         if (in != null) {
            try {
               in.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
         if (out != null) {
            out.close();
         }          
      }

      
   }
   
   /**
    * The file "maneges.txt" contains informations about "Carousels".
    * Each line contains the carousel name , maximum height, maximum speed and maximum number of passengers. Ex:
    * Batman the ride   109   50 36
    * Deja vu  178   65 32
    * 
    * Read line from file and for each read values separated by "\t"(tab)
    */
   public static void readLineAndContentOf () {
      
      BufferedReader br = null;
      Scanner sc = null;
      
      try {
         br = new BufferedReader(new FileReader("src/main/resources/flat/maneges.txt"));         
         String oneLine;
                  
         while ((oneLine = br.readLine()) != null) {
            sc = new Scanner(oneLine).useDelimiter("\t");
            String nomManege = sc.next();
            Integer hauteur = sc.nextInt();
            Integer vitesse = sc.nextInt();
            Integer nbPassagers = sc.nextInt();
            logger.info("Line: "+nomManege+" "+hauteur+" "+vitesse+" "+nbPassagers);
            sc.close();
         }
         
         br.close();
         
      } catch (Exception e) {
         logger.error(" Error: "+e.getMessage());
      } finally {
         if (br != null) {
            try {
               br.close();
            } catch (IOException e) {
               logger.error(" Error arrived: "+e.getMessage());
            }
         }
         if (sc != null) {
            sc.close();
         }
      }
      
   }
   
   public static void printDetails(Path p) {
      logger.info("Details for path: " + p);
      
      int count = p.getNameCount();
      logger.info("the number of name elements in the path.: "+p.getNameCount());
      
      for (int i = 0; i < count; i++) {
         logger.info("  >>> Name element: "+p.getName(i));
      }

      Path parent = p.getParent();
      Path root = p.getRoot();
      Path fileName = p.getFileName();
      logger.info("Parent: " + parent + ", Root:   " + root + ", File Name: " + fileName);
      logger.info("Absolute Path: " + p.isAbsolute()+"\n");
      
      /*
      I|First                                   |URI Path: file:///C:/Temp/2/test1.txt 
      I|First                                   |Details for path: C:\Temp\2\test1.txt
      I|First                                   |the number of name elements in the path.: 3
      I|First                                   |  >>> Name element: Temp
      I|First                                   |  >>> Name element: 2
      I|First                                   |  >>> Name element: test1.txt
      I|First                                   |Parent: C:\Temp\2, Root:   C:\, File Name: test1.txt
      I|First                                   |Absolute Path: true
      
      I|First                                   |Details for path: test1.txt
      I|First                                   |the number of name elements in the path.: 1
      I|First                                   |  >>> Name element: test1.txt
      I|First                                   |Parent: null, Root:   null, File Name: test1.txt
      I|First                                   |Absolute Path: false      
      */
   }
   
   /**
    * http://www.java2s.com/Tutorials/Java/Java_io/0990__Java_nio_Files.htm
    */
   public static void creatingNewFiles() {
      Path pth1 = Paths.get("C:\\Temp\\2\\testCreate.txt");
      
      try {
         Files.createFile(pth1);
      } catch (FileAlreadyExistsException e) {
         logger.error("File "+pth1.normalize()+" already exists.");
       } catch (NoSuchFileException e) {
          logger.error("Directory does  not  exists:"+ pth1.normalize().getParent());         
      } catch (IOException e) {
         logger.error(" Error: "+e.getMessage());
         e.printStackTrace();
      }
      
   }
   
   /**
    * @param args
    * @throws IOException 
    */
   public static void main(String[] args) throws IOException {
      
      //readByteSteam();
      //logger.info("Process end for readByteSteam()");
      
      //readCharStream();
      //logger.info("Process end for readCharStream()");
      
      //copyLineByLine();
      //logger.info("Process end for copyLineByLine()");
      
      //readLineAndContentOf();
      //logger.info(" \nProcess end for readLineAndContentOf()");
      
      //A path does not have to exist when we create a Path object. 
/*      Path p1 = Paths.get("C:\\Temp\\2\\test1.txt");
      
      URI p1UriPath = p1.toUri();
      logger.info("URI Path: " + p1UriPath);    
      printDetails(p1);
      
      Path p2 = Paths.get("test1.txt");
      printDetails(p2);*/
      
      //creatingNewFiles();
   }

}
