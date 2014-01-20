package com.proj.coreservlets.intro;

public class Rectangle extends Shape {
   private double length, width;
   
   /*
    * If you instantiate an object from the bean definition file, it is common to use
      zero-arg constructor and then to invoke setter methods (via <property> tags).
    */
   public Rectangle() {}
   
   public Rectangle(double length, double width) {
      this.length = length;
      this.width = width;
   }

   public double getLength() {
      return length;
   }
   /*
    * You can use <property name="length" …/> or
      <property name="width"…/>. Property names
      are based on setter method names, not on
      instance variable names.
    */
   public void setLength(double length) {
      this.length = length;
   }

   public double getWidth() {
      return width;
   }

   public void setWidth(double width) {
      this.width = width;
   }

   public double getArea() {
      return(length * width);
    }
}
