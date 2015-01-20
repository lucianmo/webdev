package com.work.junit.mockito;

public class ModeleVoiture{ 
   private Long id; 
   private String libelle; 
   private String marque; 
   private Long nbKilometres; 
   private Long age; 
 
   /** Getters et setters */ 
 
   public Long getId() { 
       return id; 
   } 
   public void setId(Long id) { 
       this.id = id; 
   } 
   public String getLibelle() { 
       return libelle; 
   } 
   public void setLibelle(String libelle) { 
       this.libelle = libelle; 
   } 
   public String getMarque() { 
       return marque; 
   } 
   public void setMarque(String marque) { 
       this.marque = marque; 
   } 
   public Long getNbKilometres() { 
       return nbKilometres; 
   } 
   public void setNbKilometres(Long nbKilometres) { 
       this.nbKilometres = nbKilometres; 
   } 
   public Long getAge() { 
       return age; 
   } 
   public void setAge(Long age) { 
       this.age = age; 
   } 
}
