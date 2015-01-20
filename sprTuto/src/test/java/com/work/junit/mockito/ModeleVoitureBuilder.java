package com.work.junit.mockito;

import java.util.ArrayList;
import java.util.List;

import com.work.junit.mockito.ModeleVoiture;

public class ModeleVoitureBuilder {

   private Long id; 
   private String libelle; 
   private String marque; 
   private Long nbKilometres; 
   private Long age; 
   
   public static ModeleVoitureBuilder aModeleVoiture() {
      return new ModeleVoitureBuilder();
   }

   public ModeleVoitureBuilder withId(Long id) {
      this.id = id;
      return this;
   }

   public ModeleVoitureBuilder withLibelle(String libelle) {
      this.libelle = libelle;
      return this;
   }

   public ModeleVoitureBuilder withMarque(String marque) {
      this.marque = marque;
      return this;
   }

   public ModeleVoitureBuilder withNbKilometres(Long nbKilometres) {
      this.nbKilometres = nbKilometres;
      return this;
   }

   public ModeleVoitureBuilder withAge(Long age) {
      this.age = age;
      return this;
   }
   
   public ModeleVoiture build() {
      ModeleVoiture modeleVoiture = new ModeleVoiture();
      modeleVoiture.setId(id);
      modeleVoiture.setLibelle(libelle);
      modeleVoiture.setMarque(marque);
      modeleVoiture.setNbKilometres(nbKilometres);
      modeleVoiture.setAge(age);
      return modeleVoiture;
   }
   
   public static ModeleVoiture[] array(ModeleVoitureBuilder ...modeleVoitures) {
      ModeleVoiture[] array = new ModeleVoiture[modeleVoitures.length];
      for (int i = 0; i < array.length; i++) {
         array[i] = modeleVoitures[i].build();
      }
      return array;
   }
   
   public static List<ModeleVoiture> list(ModeleVoitureBuilder ...modeleVoitures) {
      List<ModeleVoiture> list = new ArrayList<ModeleVoiture>();
      for (int i = 0; i < modeleVoitures.length; i++) {
         list.add(modeleVoitures[i].build());
      }
      return list;
   }
}
