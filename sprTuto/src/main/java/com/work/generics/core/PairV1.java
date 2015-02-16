package com.work.generics.core;

/**
 * 
 *
 */
public class PairV1<T> {
   
   private T first;
   private T second;
   
   public PairV1() {};
   
   public PairV1 (T firstFiels, T secondFiels) {
      this.first = firstFiels;
      this.second = secondFiels;
   }
   
   public T getFirst () {
      return this.first;
   }
 
   public T getSecond () {
      return this.second;
   }

   public void setFirst(T newValue) {
      this.first = newValue;
   }

   public void setSecond(T newValue) {
      this.second = newValue;
   }
      
}
