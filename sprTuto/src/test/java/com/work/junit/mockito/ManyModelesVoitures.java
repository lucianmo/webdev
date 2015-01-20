package com.work.junit.mockito;

import com.work.junit.mockito.ModeleVoitureBuilder;
import com.work.junit.mockito.ModeleVoiture;

public class ManyModelesVoitures {

   /**
    * Hide the utility class constructor (only static method)
    */
   protected ManyModelesVoitures() {
      throw new RuntimeException("Utility class don't have any constructor");
   }
   
   public static ModeleVoiture bobsModelVoiture() {
      return ModeleVoitureBuilder.aModeleVoiture()
            .withId(3L)
            .withLibelle("Corolla")
            .withMarque("Toyota").build();
   }
}
