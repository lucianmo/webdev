package com.proj.springrecipes.sequence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

   /**
    * @param args
    */
   @SuppressWarnings("resource")
   public static void main(String[] args) {
      // 
      ApplicationContext context = 
            new ClassPathXmlApplicationContext("springrecipes/beansSequence.xml");

        SequenceGenerator generator =
            (SequenceGenerator) context.getBean("sequenceGenerator");

        System.out.println(generator.getSequence());
        System.out.println(generator.getSequence());
   }

}
