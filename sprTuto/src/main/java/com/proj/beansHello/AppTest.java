package com.proj.beansHello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

   /**
    * @param args
    */
   public static void main(String[] args) {
      // 
      ApplicationContext context = new ClassPathXmlApplicationContext("hello/beansHello.xml");
      HelloWorld obj = (HelloWorld) context.getBean("helloBean");
      obj.printHello();
   }

}
