package com.work.junit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteFactory {

   private static int current = 0;
   
   public static List<Note> createListNotes () {
      List<Note> myNotes = new ArrayList<Note>();
      myNotes.add(createNote("templates","Log error and throw exception"));
      myNotes.add(createNote("declare","Therefore they can but suitably value"));
      myNotes.add(createNote("XPath","Sending and Parsing Response"));
      return myNotes;
   }
   
   public static Note createNote (String summary, String description) {
      return new Note(current++, summary, description, false, new Date());
   }
}
