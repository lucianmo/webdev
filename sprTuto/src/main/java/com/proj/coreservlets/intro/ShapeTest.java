package com.proj.coreservlets.intro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShapeTest {

   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("/coreservlets/introContext.xml");
      
      for (int i=1; i<=4; i++) {
         Shape shape = (Shape)context.getBean("shape" + i);
         shape.printInfo();
      }
   
      for(int i=1; i<=2; i++) {
         ShapeList shapes = (ShapeList)context.getBean("shapeList" + i);
         shapes.printInfo();
      }      
   }

}
