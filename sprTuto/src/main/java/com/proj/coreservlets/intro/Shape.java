package com.proj.coreservlets.intro;

public abstract class Shape {
   public abstract double getArea();
   
   public void printInfo() {
      System.out.printf("%s with area of %,.2f%n", 
                        getClass().getSimpleName(),
                        getArea());
    }   
}
