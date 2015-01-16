package com.work.junit.first;

import org.junit.Test;
/**
 * Cette annotation permet de vérifier qu'un test ne dépasse pas une durée. 
 * Au delà de cette durée, le test passe en erreur.
 *
 */
public class TestDureeLimitee {

   @Test(timeout=1000)
   public void dureeRespectee() {
       
   }

   @Test(timeout=1000)
   public void dureeNonRespectee() throws InterruptedException {
       Thread.sleep(10000);
   }   
}
