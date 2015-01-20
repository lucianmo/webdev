package com.work.junit.mockito;

import java.util.List;

/** 
 * Interface IPersistanceModeleVoiture 
 * Signatures des méthodes permettant l'interaction des objets à persister et la base de données 
 * @author ok.Idriss 
 */ 
public interface IPersistanceModeleVoiture { 
    /** 
     * Rechercher une liste de modèles de voiture en base de données à partir de critères 
     * @param CritereRerchercheModeleVoiture critere de recherche 
     * @return List<ModeleVoiture> liste de résultats correspondant à la recherche 
     */ 
    public List<ModeleVoiture> searchModeleVoiture(CritereRerchercheModeleVoiture critere); 
  
    /** 
     * Rechercher un modèle de voiture via son id en base 
     * @param Long id 
     * @return ModeleVoiture résultat correspondant à la recherche 
     * @throws TooMuchResultException lorsque la recherche correspond à plusieurs résultats 
     */ 
    public ModeleVoiture searchModeleVoitureById(Long id) throws TooMuchResultException; 
  
    /** 
     * Persister une instance de ModeleVoiture en base de données 
     * @param ModeleVoiture modele instance à persister en base 
     * @return boolean true si l'insertion s'est bien passée sinon false 
     * @throws ErreurPersistance en cas d'erreur 
     */ 
    public boolean addModeleVoiture(ModeleVoiture modele) throws ErreurPersistance; 
  
    /** 
     * Mettre à jour une instance de ModeleVoiture en base de données 
     * @param ModeleVoiture modele instance à modifier en base 
     * @return boolean true si la mise à jour s'est bien passée sinon false 
     * @throws ErreurPersistance en cas d'erreur 
     */ 
    public boolean updateModeleVoiture(ModeleVoiture modele) throws ErreurPersistance; 
  
    /** 
     * Supprimer une instance de ModeleVoiture en base de données 
     * @param ModeleVoiture modele instance à supprimer en base 
     * @return boolean true si la suppression s'est bien passée sinon false 
     * @throws ErreurPersistance en cas d'erreur 
     */ 
    public boolean deleteModeleVoiture(ModeleVoiture modele) throws ErreurPersistance; 
}