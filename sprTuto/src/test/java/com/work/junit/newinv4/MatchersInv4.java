package com.work.junit.newinv4;

import static org.junit.Assert.*;

import org.hamcrest.core.IsSame;
import org.junit.Test;

/**
 * http://rpouiller.developpez.com/tutoriels/java/tests-unitaires-junit4/#LIV-A
 * Le contrat vérifie que l'instance passée en premier paramètre de l'assertion et celle passée en paramètre du contrat sont les mêmes. 
 */
public class MatchersInv4 {

   @Test
   public void pareil() {
   // Remarque : c'est la même instance à cause du cache
      assertThat("texte", IsSame.sameInstance("texte"));
   }

   @Test
   public void pasPareil() {
   // Remarque : ce n'est pas la même instance parce que new String() force une nouvelle instance.
      assertThat(new String("texte"), IsSame.sameInstance("texte"));
   }   
}
