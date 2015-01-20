package com.work.junit.mockito;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.work.junit.mockito.IPersistanceModeleVoiture;
import com.work.junit.mockito.ModeleVoiture;
/** 
 * Class programmeVoiture 
 * La classe à tester unitairement  
 */ 
public class ProgrammeVoiture { 
    
    private static final Logger logger = LoggerFactory.getLogger(ProgrammeVoiture.class);
    // Objet persistance qui sera lié par le principe d'injection de dépendance 
    private IPersistanceModeleVoiture persistance; 
  
    /** Méthodes à tester */ 
  
    /** 
     * Rechercher une liste de modèles en fonction de la marque 
     * @param String marque 
     * @return List<ModeleVoiture> tous les modèles en base appartenant à cette marque 
     */ 
    public List<ModeleVoiture> rechercherVoitureParMarque(String marque) { 
        CritereRerchercheModeleVoiture critere = new CritereRerchercheModeleVoiture(); 
        critere.setMarqueModele(marque); 
        return persistance.searchModeleVoiture(critere); 
    } 
  
    /** 
     * Rechercher un modèle de voiture via son id en base 
     * @param Long id 
     * @return ModeleVoiture résultat correspondant à la recherche 
     */ 
    public ModeleVoiture rechercherVoitureParId(Long id){ 
        try { 
            return persistance.searchModeleVoitureById(id); 
        } catch (TooMuchResultException e){ 
            logger.error("Trop de résultats avec le même id, revoyez la structure de votre table !"); 
            return null; 
        } 
    } 
  
    /** 
     * Enregistrer un modèle valorisé à partir d'un formulaire de création/modification 
     * Doit mettre à jour en base le modèle ou l'ajouter dans le cas ou il n'existe pas 
     * @param ModeleVoiture modele 
     */ 
    public boolean enregisterModeleVoiture(ModeleVoiture modele){ 
        try{ 
            if (null != modele.getId()){ 
                persistance.updateModeleVoiture(modele); 
            } else { 
                persistance.addModeleVoiture(modele); 
            }
            return true;
        } catch (ErreurPersistance e){ 
            logger.error ("Erreur : " + e.getMessage());
            return false;
        } 
    } 
  
    /** Getters et setters */ 
    public IPersistanceModeleVoiture getPersistance() { 
        return persistance; 
    } 
  
    public void setPersistance(IPersistanceModeleVoiture persistance) { 
        this.persistance = persistance; 
    } 
}