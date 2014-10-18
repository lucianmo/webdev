package com.work.generics.stack;

public class Stack<E> {

   private int size;
   
   private int top;
   private E[] elements;
   
   public Stack () {
      this(10);
   }
   

   @SuppressWarnings("unchecked")
   public Stack(int s) {
      // TODO Auto-generated constructor stub
      size = s > 0 ? s: 10;
      top = -1;
      elements = (E[]) new Object[size];
   }

   public void push(E pushValue) {
      if (top <= size) {
         elements[top] = pushValue;
         top++;
      } else {
         throw new FullStackException(); 
      }
   }

   public E pull() {
      if (top < 0) {
         throw new EmptyStackException();
      } else {
        return elements[top--]; 
      }    
   }
   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub

   }

}

