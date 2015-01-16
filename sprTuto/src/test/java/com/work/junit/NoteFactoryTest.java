package com.work.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.work.junit.NoteFactory;

public class NoteFactoryTest {

   @Test(expected = RuntimeException.class)
   public void testExceptionIsThrown() {
      NoteFactory.createListNotes().get(5);
   }
   
   @Test
   public void testCreateListNotes() {
      assertEquals("We have three notes", 3, NoteFactory.createListNotes().size());
   }



}
