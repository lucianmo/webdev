package com.work.junit.mockito;

import static org.mockito.Mockito.*; 
import static org.junit.Assert.*;
import static org.mockito.Matchers.*; 

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/** 
 * http://java.developpez.com/faq/tests/?page=Le-framework-Mockito
 *
 */
public class ProgrammeVoitureTest {

   private IPersistanceModeleVoiture persistanceMock; 
   private ProgrammeVoiture programme; 
   
   /** Jeu de données */ 
   private ModeleVoiture modeleTest;
   Long idExistant = 1L; 
   Long idInexistant = 2L;    
   List<ModeleVoiture> listTest = new ArrayList<ModeleVoiture>();
   
   @Before
   public void setUp() throws Exception {
      programme = new ProgrammeVoiture();
      
      // Création du mock 
      persistanceMock = mock(IPersistanceModeleVoiture.class);
      
      // Injection du mock en lieu et place d'une réelle implémentation de IPersistanceModeleVoiture 
      programme.setPersistance(persistanceMock); 
      
      // Initialisation du jeu de données 
      modeleTest = ModeleVoitureBuilder.aModeleVoiture().withId(idExistant).withLibelle("Clio").withMarque("Renault").build();
      listTest.add(modeleTest);
      
   }
 
   /**
    * Comment prédire le résultat d'une méthode via Mockito ?
    * when(objetMock.methode(any(ClassArgument.class))).thenReturn(objetResultat);
    * when(objetMock.methode(eq(valeurArgument))).thenReturn(objetResultat);
    * when(objetMock.methode(valeurArgument)).thenReturn(objetResultat);  
    */
   @Test
   public final void testRechercherVoitureParId() throws TooMuchResultException { 
      // Lorsque l'on appelera la méthode searchModeleVoitureById avec comme paramètre "idExistant", le mock retournera modeleTest 
      when(persistanceMock.searchModeleVoitureById(idExistant)).thenReturn(modeleTest); 

      // l'id existe en base (tel qu'est défini le mock) 
      // on vérifie qu'on renvoie bien le résultat retourné par la persistance 
      ModeleVoiture result = programme.rechercherVoitureParId(idExistant); 
      assertNotNull(result); 
      assertEquals(idExistant, result.getId()); 
      assertEquals("Clio", result.getLibelle()); 
      assertEquals("Renault", result.getMarque());   
      
      // L'id n'existe pas en base 
      // on vérifie que l'on renvoie bien null dans ce cas-là 
      result = programme.rechercherVoitureParId(idInexistant); 
      assertNull(result);       
   }
   
   /**
    * Comment faire une assertion sur l'appel d'une méthode avec Mockito ?
    * verify(objetMock).methode(valeurArgument);
    * verify(objetMock).methode(eq(valeurArgument)); 
    * verify(objetMock).methode(any(ClassArgument.class));
    * @throws ErreurPersistance 
    */
   @Test
   public final void testEnregisterModeleVoiture_Creation() throws ErreurPersistance{ 
      ModeleVoiture modeleVoiture = new ModeleVoiture();
      // Prendre note que "UnNouveauLibelle" n'a pas de Id setté. 
      // Donc la valeur "modeleVoiture.getId() == null" et persistance.addModeleVoiture(modeleVoiture) sera executé. 
      modeleVoiture.setLibelle("UnNouveauLibelle");
      
      when(persistanceMock.addModeleVoiture(modeleVoiture)).thenReturn(true);
      assertSame(true, programme.enregisterModeleVoiture(modeleVoiture));  
      
      //La methode addModeleVoiture a été appelé.
      verify(persistanceMock).addModeleVoiture(modeleVoiture);
          
   }
   
   @Test
   public final void testEnregisterModeleVoiture_Update() throws ErreurPersistance{
      ModeleVoiture modeleVoiture = new ModeleVoiture();
      // Prendre note que "ExistantLibelle" et le Id sont setté. 
      // Donc la valeur "modeleVoiture.getId() != null" et persistance.updateModeleVoiture(modeleVoiture) sera executé. 
      modeleVoiture.setLibelle("ExistantLibelle");
      modeleVoiture.setId(3L);
      
      when(persistanceMock.updateModeleVoiture(modeleVoiture)).thenReturn(true);
      assertSame(true, programme.enregisterModeleVoiture(modeleVoiture)); 
      
      verify(persistanceMock).updateModeleVoiture(modeleVoiture);      
   }
   
   /**
    * Nous n'avons pas besoin de "(expected = ErreurPersistance.class)" car la methode "enregisterModeleVoiture"
    * ne throw pas aucune exception. Elle le catch et donc nous devons utilisé "thenThrow(new ErreurPersistance()"
    * pour visiter le block catch. Suivi de "thenReturn(false)"
    */
   @Test      
   public final void testShouldThrowException_OnCreation() throws ErreurPersistance {
      ModeleVoiture modeleVoiture = new ModeleVoiture();
      modeleVoiture.setLibelle("UnAutreExistantLibelle");
      
      // when
      when(persistanceMock.addModeleVoiture(modeleVoiture)).thenThrow(new ErreurPersistance()).thenReturn(false);
      
      // then
      assertSame(false, programme.enregisterModeleVoiture(modeleVoiture));      
      //La methode addModeleVoiture a été appelé.
      verify(persistanceMock).addModeleVoiture(modeleVoiture);
   }
}
